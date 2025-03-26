package org.example.chickenstockex.model.repository;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.chickenstockex.model.dto.Account;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository implements JDBCRepository {
    final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    final String URL = dotenv.get("DB_URL");
    final String USER = dotenv.get("DB_USER");
    final String PASSWORD = dotenv.get("DB_PASSWORD");

    public List<Account> findAll() throws Exception {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = getConnection(URL, USER, PASSWORD)) {
            Statement stmt = conn.createStatement(); // PreparedStatement로 왜 안 만듦?
            String query = "SELECT * FROM accounts";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                accounts.add(new Account(rs.getLong("account_id"), rs.getString("nickname")));
            }
        }
        return accounts;
    }

    public void save(Account account) throws Exception {
        try (Connection conn = getConnection(URL, USER, PASSWORD)) {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO accounts (nickname) VALUES ('%s')" .formatted(account.nickname());
            // 작은 따옴표 주의 '%s'. 없으면 column명으로 받아들인다.
            int rowsAffected = stmt.executeUpdate(query);
            System.out.println("Rows affected: " + rowsAffected);
        }
    }
    public void delete(long id) throws Exception {
        try (Connection conn = getConnection(URL, USER, PASSWORD)) {
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM accounts WHERE account_id = %d" .formatted(id);
            // 작은 따옴표 주의 '%s'. 없으면 column명으로 받아들인다.
            int rowsAffected = stmt.executeUpdate(query);
            System.out.println("Rows affected: " + rowsAffected);
        }
    }
}
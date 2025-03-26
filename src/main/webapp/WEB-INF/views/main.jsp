<%@ page import="org.example.chickenstockex.model.dto.Account" %><%--
  Created by IntelliJ IDEA.
  User: iream
  Date: 25. 3. 26.
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>주식 거래소</title>
</head>
<body>
    <p>ㅎㅇㅌ</p>
    <p><%= request.getAttribute("accounts")%></p>
    <form method="POST">
        <input hidden name ="id" value = "0">
        <label>
            별명 :
            <input type="text" name="nickname">
        </label>
        <button>등록</button>
    </form>
    <form action="delete">
        <label>
            번호 :
            <input type="text" name="id">
        </label>
        <button>삭제</button>
    </form>
</body>
</html>

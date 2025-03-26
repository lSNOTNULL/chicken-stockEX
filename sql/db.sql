CREATE TABLE accounts
(
    account_id int primary key auto_increment,
    nickname   varchar(255) not null unique
);

INSERT INTO accounts (nickname)
values ('가'),
       ('나'),
       ('다'),
       ('라'),
       ('마'),
       ('바'),
       ('사');
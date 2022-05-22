CREATE TABLE user
(
    email     varchar(100) not null,
--     firstName varchar(100) not null,
--     lastName  varchar(100) not null,
    password  varchar(60)  not null,
    boolean   boolean      not null,
    PRIMARY KEY (email)
);
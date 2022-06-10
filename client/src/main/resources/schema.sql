CREATE TABLE myuser
(
    username     varchar(100) not null primary key,
    password varchar(60) not null,
    enabled boolean not null
);

create table authorities(
    username     varchar(100) not null primary key,
    authority varchar(100) not null,
    constraint fk_authorities_users foreign key (username) references  myuser(username)
);

create unique index ix_auth_username on authorities(username, authority);
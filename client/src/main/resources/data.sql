INSERT INTO myuser (username, password, enabled)
values ('user', 'pass', true);

INSERT INTO myuser (username, password, enabled)
values ('admin', 'pass', true);

INSERT INTO authorities (username, authority)
values ('user','ROLE_USER');

INSERT INTO authorities (username,authority)
values ('admin','ROLE_ADMIN');

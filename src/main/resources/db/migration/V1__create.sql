CREATE TABLE ASSET(
ID INT AUTO_INCREMENT,
NAME VARCHAR(255),
TYPE VARCHAR(255),
AMOUNT INT,
WORTH INT,
IDENTIFIER VARCHAR(255)
);

CREATE TABLE USER_ACCOUNT(
ID INT AUTO_INCREMENT,
USERNAME VARCHAR(255),
PASSWORD VARCHAR(255),
ROLE VARCHAR(255)
);

INSERT INTO USER_ACCOUNT (USERNAME, PASSWORD, ROLE) VALUES ('admin', 'admin', 'ADMIN');
INSERT INTO USER_ACCOUNT (USERNAME, PASSWORD, ROLE) VALUES ('test', 'test', 'USER');

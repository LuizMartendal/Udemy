CREATE TABLE IF NOT EXISTS users (
id binary(16) PRIMARY KEY,
user_name varchar(30) NOT NULL UNIQUE,
full_name varchar(100) NOT NULL,
password varchar(30) NOT NULL,
account_non_expired integer NOT NULL,
account_non_locked integer NOT NULL,
credentials_non_expired integer NOT NULL,
enabled integer NOT NULL
);
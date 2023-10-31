CREATE TABLE IF NOT EXISTS users (
    id int(20) NOT NULL,
    user_name varchar(100) NOT NULL,
    full_name varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    account_non_expired bit(1) DEFAULT NULL,
    account_non_locked bit(1) DEFAULT NULL,
    credentials_non_expired bit(1) DEFAULT NULL,
    enabled bit(1) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (user_name)
);
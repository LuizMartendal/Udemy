CREATE TABLE IF NOT EXISTS cidade (
    id char(36) NOT NULL,
    nome varchar(100) NOT NULL UNIQUE,
    habitantes int NOT NULL,
    PRIMARY KEY (id)
);
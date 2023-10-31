CREATE TABLE IF NOT EXISTS books (
    id_book int NOT NULL,
    author varchar(100),
    launch_date datetime NOT NULL,
    price decimal(65) NOT NULL,
    title varchar(200) NOT NULL,
    CONSTRAINT PRIMARY KEY (id_book)
);

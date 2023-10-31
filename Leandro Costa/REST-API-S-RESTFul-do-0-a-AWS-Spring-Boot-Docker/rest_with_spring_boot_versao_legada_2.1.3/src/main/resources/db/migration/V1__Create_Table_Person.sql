CREATE TABLE IF NOT EXISTS person (
    person_id int(20) AUTO_INCREMENT,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    enabled bit(1) NOT NULL,
    gender varchar(15) NOT NULL,
    address varchar(100) NOT NULL,
    CONSTRAINT PRIMARY KEY (person_id)
);
CREATE TABLE IF NOT EXISTS person (
    person_id int(20) NOT NULL,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    gender varchar(15) NOT NULL,
    adress varchar(100) NOT NULL,
    CONSTRAINT PRIMARY KEY (person_id)
);
CREATE TABLE IF NOT EXISTS user_permission (
    id_user int(20) NOT NULL,
    id_permission int(20) NOT NULL,
    PRIMARY KEY (id_user, id_permission),
    CONSTRAINT fk_user FOREIGN KEY (id_user) REFERENCES users (id),
    CONSTRAINT fk_permission FOREIGN KEY (id_permission) REFERENCES permission (id)
);
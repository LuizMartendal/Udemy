CREATE TABLE IF NOT EXISTS user_permission (
id_user binary(16) NOT NULL,
id_permission binary(16) NOT NULL,
CONSTRAINT PRIMARY KEY (id_user, id_permission),
CONSTRAINT id_user_fk FOREIGN KEY (id_user) REFERENCES users(id),
CONSTRAINT id_permission_fk FOREIGN KEY (id_permission) REFERENCES permission(id)
);
CREATE TABLE IF NOT EXISTS cliente (
    id char(36) NOT NULL,
    nome varchar(100) NOT NULL,
    cpf varchar(14) NOT NULL UNIQUE,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS produto (
    id char(36) NOT NULL,
    descricao varchar(200) NOT NULL,
    preco_unitario numeric(20,2) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS pedido (
    id char(36) NOT NULL,
    cliente_id char(36) NOT NULL,
    data_pedido date NOT NULL,
    total numeric(20,2),
    status varchar(20),
    PRIMARY KEY (id),
    FOREIGN KEY (cliente_id) REFERENCES cliente (id)
    );

CREATE TABLE IF NOT EXISTS item_pedido (
    id char(36) NOT NULL,
    pedido_id char(36) NOT NULL,
    produto_id char(36) NOT NULL,
    quantidade integer NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (pedido_id) REFERENCES pedido (id),
    FOREIGN KEY (produto_id) REFERENCES produto (id)
    );
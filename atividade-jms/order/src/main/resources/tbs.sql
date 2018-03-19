CREATE TABLE cliente(
    id serial PRIMARY KEY,
    nome VARCHAR(40) NOT NULL,
     email VARCHAR(50)
);
CREATE TABLE Produto(
    id serial PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    PRECO decimal
);
CREATE TABLE Pedido(
    id serial PRIMARY KEY,
    id_cliente int,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id) ON DELETE SET NULL
);
CREATE TABLE Produto_cliente(
    pedido int,
    produto int,
    FOREIGN KEY (pedido) REFERENCES pedido(id) ON DELETE SET NULL,
    FOREIGN KEY (produto) REFERENCES produto(id) ON DELETE SET NULL
    
);

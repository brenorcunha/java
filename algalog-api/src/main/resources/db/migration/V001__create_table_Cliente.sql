create table Cliente(
    id bigint NOT NULL AUTO_INCREMENT,
    nome varchar(60) NOT NULL,
    email varchar(60) not NULL,
    telefone varchar(20) NOT NULL,
    PRIMARY KEY(id)
);
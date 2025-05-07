create database if not exists cadastro;
use vendas;
create table if not exists clientes
(
	id int PRIMARY KEY AUTO_INCREMENT,
    cpf varchar(11) UNIQUE,
	nome varchar(30) not null,
    email varchar(50) not null,
    telefone varchar(15) not null,
    endereco varchar(255) not null,
    data_nascimento date not null
);

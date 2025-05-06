create database if not exists vendas;
use vendas;
create table if not exists clientes
(
	cli_cpf varchar(11) primary key,
	cli_nome varchar(30) not null,
    cli_email varchar(50) not null,
    cli_phone varchar(15) not null,
    cli_address varchar(255) not null,
    cli_birthdata date not null
);

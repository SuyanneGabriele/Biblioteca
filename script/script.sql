CREATE DATABASE biblioteca;

CREATE TABLE biblioteca.livro(
	id_livro INT NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(255) NOT NULL,
	autor VARCHAR(255) NOT NULL,
	ano_lancamento int,
	editora varchar(255),
	edicao varchar(255),
	tempoReservaDias INT DEFAULT 5,
	PRIMARY KEY (id_livro)
);
CREATE TABLE biblioteca.revista(
	id_revista INT NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(255) NOT NULL,
	autor VARCHAR(255) NOT NULL,
	ano_lancamento int,
	editora varchar(255),
	edicao varchar(255),
	tempoReservaDias INT DEFAULT 5,
	PRIMARY KEY (id_revista)
);
CREATE TABLE biblioteca.periodico(
	id_periodico INT NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(255) NOT NULL,
	autor VARCHAR(255) NOT NULL,
	ano_lancamento int,
	editora varchar(255),
	edicao varchar(255),
	tempoReservaDias INT DEFAULT 5,
	PRIMARY KEY (id_periodico)
);

CREATE TABLE biblioteca.acervo(
	id_acervo INT NOT NULL AUTO_INCREMENT,
	id_item INT NOT NULL,
	tipo_item VARCHAR(255) NOT NULL,
	PRIMARY KEY (id_acervo)
);

CREATE TABLE biblioteca.pessoa(
	id_pessoa INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	data_nascimento date,
	documento varchar(20),
	telefone varchar(20),
	email varchar(200),
	data_cadastro date,
	endereco varchar(200),
	numero_endereco int,
	PRIMARY KEY (id_pessoa)
);

CREATE TABLE biblioteca.cliente(
	id_cliente INT NOT NULL AUTO_INCREMENT,
	id_pessoa int not null,
	cod_registro int,
	PRIMARY KEY (id_cliente),
	CONSTRAINT fk_cliente_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES biblioteca.pessoa (id_pessoa)
);

CREATE TABLE biblioteca.funcionario(
	id_funcionario INT NOT NULL AUTO_INCREMENT,
	id_pessoa int not null,
	cod_funcionario int,
	PRIMARY KEY (id_funcionario),
	CONSTRAINT fk_funcionario_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES biblioteca.pessoa (id_pessoa)
);

CREATE TABLE biblioteca.emprestimo(
	id_emprestimo INT NOT NULL AUTO_INCREMENT,
	id_cliente INT NOT NULL,
	id_funcionario int not null,
	id_acervo INT NOT NULL,
	data_inicio DATE NOT NULL,
	data_devolucao DATE,
	status varchar(20),
	PRIMARY KEY (id_emprestimo),
	CONSTRAINT fk_emprestimo_id_cliente FOREIGN KEY (id_cliente) REFERENCES biblioteca.cliente (id_cliente),
	CONSTRAINT fk_emprestimo_id_funcionario FOREIGN KEY (id_funcionario) REFERENCES biblioteca.funcionario (id_funcionario),
	CONSTRAINT fk_emprestimo_id_acervo FOREIGN KEY (id_acervo) REFERENCES biblioteca.acervo (id_acervo)
);


-----------INSERT LIVRO----------
insert into biblioteca.livro (titulo, autor, ano_lancamento, editora, edicao) values ('Harry Potter 1', 'JK Rowling', 1900, 'Editora abc', 'edicao 1');
insert into biblioteca.livro (titulo, autor, ano_lancamento, editora, edicao) values ('Harry Potter 2', 'JK Rowling', 1901, 'Editora abc', 'edicao 1');
insert into biblioteca.livro (titulo, autor, ano_lancamento, editora, edicao) values ('Harry Potter 3', 'JK Rowling', 1902, 'Editora abc', 'edicao 1');

-----------INSERT REVISTA----------
insert into biblioteca.revista (titulo, autor, ano_lancamento, editora, edicao) values ('Revistinha avon 1', 'Avon', 1900, 'Editora abc', 'edicao 1');
insert into biblioteca.revista (titulo, autor, ano_lancamento, editora, edicao) values ('Revistinha avon 2', 'Avon', 1901, 'Editora abc', 'edicao 1');
insert into biblioteca.revista (titulo, autor, ano_lancamento, editora, edicao) values ('Revistinha avon 3', 'Avon', 1902, 'Editora abc', 'edicao 1');

-----------INSERT PERIODICO--------
insert into biblioteca.periodico (titulo, autor, ano_lancamento, editora, edicao) values ('periodico 1', 'periodico', 1900, 'Editora abc', 'edicao 1');
insert into biblioteca.periodico (titulo, autor, ano_lancamento, editora, edicao) values ('periodico 2', 'periodico', 1901, 'Editora abc', 'edicao 1');
insert into biblioteca.periodico (titulo, autor, ano_lancamento, editora, edicao) values ('periodico 3', 'periodico', 1902, 'Editora abc', 'edicao 1');


-----------INSERT ACERVO------------
insert into biblioteca.acervo (id_item, tipo_item) values (1, 'Livro');
insert into biblioteca.acervo (id_item, tipo_item) values (1, 'Revista');
insert into biblioteca.acervo (id_item, tipo_item) values (1, 'Periodico');

-----------INSERT PESSOA------------
insert into pessoa (nome, data_nascimento, documento, telefone, email, data_cadastro, endereco, numero_endereco) 
values ('Kauê Fábio Jesus', 20/04/1980, '748.029.674-62', '(44) 3857-1019', 'kauefabiojesus@flama.biz', 19/11/2022, 'Rua Nova Zelândia', 108);
insert into pessoa (nome, data_nascimento, documento, telefone, email, data_cadastro, endereco, numero_endereco) 
values ('Tomás Eduardo Jesus', 14/08/1978, '732.387.543-94', '(19) 3926-5834', 'tomas-jesus99@yahoo.com .br', 19/11/2022, 'Rua da Savana', 472);

-----------INSERT CLIENTE-----------
insert into cliente (id_pessoa, cod_registro) VALUES (2, 101);

-----------INSERT FUNCIONARIO-------
insert into funcionario (id_pessoa, cod_funcionario) VALUES (1, 101);

-----------INSERT EMPRESTIMO--------
insert into emprestimo (id_cliente, id_funcionario, id_acervo, data_inicio, data_devolucao, status) values 
(1, 1, 1, 19/11/2022, null, 'NO PRAZO');


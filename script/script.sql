-- https://www.w3schools.com/SQl/sql_create_db.asp
CREATE DATABASE library;

-- https://www.w3schools.com/SQl/sql_create_table.asp
-- https://data.world/alexandra/bohemian-literature/workspace/file?filename=bohemian_literature.csv
CREATE TABLE library.book(
	idbook INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	author VARCHAR(255) NOT NULL,
	dayreserve INT DEFAULT 5,
	PRIMARY KEY (idbook)
);

INSERT INTO library.book(idbook, author, title) VALUES(1, 'Paul Deitel', 'Java How to program');
INSERT INTO library.book(idbook, author, title) VALUES(2, 'Acker Kathy', 'Blood And Guts In High School');
INSERT INTO library.book(idbook, author, title) VALUES(3, 'Acker Kathy', 'Empire Of The Senseless');
INSERT INTO library.book(idbook, author, title) VALUES(4, 'Acker Kathy', 'Great Expectations');
INSERT INTO library.book(idbook, author, title) VALUES(5, 'Acker Kathy and McKenzie Wark', 'Im Very Intro You: Correspondence 1965-1996');
INSERT INTO library.book(idbook, author, title) VALUES(6, 'Acker Kathy', 'In Memoriam To Identity');
INSERT INTO library.book(idbook, author, title) VALUES(7, 'Acker Kathy', 'Literal Madness: Three Novels');
INSERT INTO library.book(idbook, author, title) VALUES(8, 'Acker Kathy', 'My Mother: Demonology');
INSERT INTO library.book(idbook, author, title) VALUES(9, 'Acker Kathy', 'Pussy King Of The Pirates');
INSERT INTO library.book(idbook, author, title) VALUES(10, 'Acosta Oscar Zeta', 'Revolt Of The Cockroach People');
INSERT INTO library.book(idbook, author, title) VALUES(11, 'Aes-Nihil Jon', 'William S. Burroughs In The Dreamachine');
INSERT INTO library.book(idbook, author, title) VALUES(12, 'Allen Donald', 'Poetics of the New American Poetry');

CREATE TABLE library.magazine(
	idmagazine INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	edition VARCHAR(255) NOT NULL,
	dayreserve INT DEFAULT 3,
	PRIMARY KEY (idmagazine)
);

INSERT INTO library.magazine(idmagazine, title, edition) VALUES(1, 'SQL Magazine', 'Volume 1');

CREATE TABLE library.collection(
	idcollection INT NOT NULL AUTO_INCREMENT,
	iditem INT NOT NULL,
	typecollection VARCHAR(255) NOT NULL,
	PRIMARY KEY (idcollection)
);

INSERT INTO library.collection(idcollection, iditem, typecollection) VALUES(1, 1, 'book');
INSERT INTO library.collection(idcollection, iditem, typecollection) VALUES(2, 1, 'magazine');

-- userSys (user system)
CREATE TABLE library.userSys(
	iduser INT NOT NULL AUTO_INCREMENT,
	firstname VARCHAR(255) NOT NULL,
	lastname VARCHAR(255) NOT NULL,
	PRIMARY KEY (iduser)
);

INSERT INTO library.userSys(iduser, firstname, lastname) VALUES(1, 'Everton', 'Pereira');
INSERT INTO library.userSys(iduser, firstname, lastname) VALUES(2, 'Richard', 'Matthew Stallman');
INSERT INTO library.userSys(iduser, firstname, lastname) VALUES(3, 'Linus', 'Tolvads');
INSERT INTO library.userSys(iduser, firstname, lastname) VALUES(4, 'Roberto', 'Carlos');

-- https://dev.mysql.com/doc/refman/8.0/en/date-and-time-types.html
-- https://www.w3schools.com/mysql/mysql_foreignkey.asp
-- https://dev.mysql.com/doc/refman/5.6/en/create-table-foreign-keys.html
-- https://www.softwaretestinghelp.com/mysql-foreign-key-constraint/
CREATE TABLE library.loan(
	idloan INT NOT NULL AUTO_INCREMENT,
	idtuser INT NOT NULL,
	idtcollection INT NOT NULL,
	loandate DATETIME NOT NULL,
	PRIMARY KEY (idloan),
	FOREIGN KEY (idtuser) REFERENCES userSys(iduser),
	FOREIGN KEY (idtcollection) REFERENCES collection(idcollection)
);


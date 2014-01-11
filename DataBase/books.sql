CREATE DATABASE IF NOT EXISTS books;

USE books;

DROP TABLE IF EXISTS authorISBN;
DROP TABLE IF EXISTS titles;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS publishers;

CREATE TABLE publishers (
	publisherID INT NOT NULL AUTO_INCREMENT,
	publisherName varchar (30) NOT NULL,
	PRIMARY KEY (publisherID)
) ENGINE=INNODB
;

CREATE TABLE authors (
	authorID INT NOT NULL AUTO_INCREMENT,
	firstName varchar (20) NOT NULL,
	lastName varchar (30) NOT NULL,
	PRIMARY KEY (authorID)
) ENGINE=INNODB
;

CREATE TABLE titles (
	isbn varchar (20) NOT NULL,
	title varchar (100) NOT NULL,
	editionNumber INT NOT NULL,
	copyright varchar (4) NOT NULL,
	publisherID INT NOT NULL,
	imageFile varchar (20) NOT NULL,
	price REAL NOT NULL,
	PRIMARY KEY (isbn),
	INDEX (publisherID),
	FOREIGN KEY (publisherID) REFERENCES publishers(publisherID)
) ENGINE=INNODB
;
CREATE TABLE authorISBN (
	authorID INT NOT NULL,
	isbn varchar (20) NOT NULL,
	INDEX (authorID),
	FOREIGN KEY (authorID) REFERENCES authors (authorID), 
	INDEX (isbn),
	FOREIGN KEY (isbn) REFERENCES titles (isbn)
) ENGINE=INNODB
;

insert into publishers (publisherName) values ('Prentice Hall')
;
insert into publishers (publisherName) values ('Prentice Hall PTG')
;

insert into authors (firstName,lastName) values ('Harvey','Deitel')
;
insert into authors (firstName,lastName) values ('Paul','Deitel')
;
insert into authors (firstName,lastName) values ('Tem','Nieto')
;
insert into authors (firstName,lastName) values ('Sean','Santry')
;

insert into titles (isbn,title,editionNumber,copyright,publisherID,imageFile,price) values ('0131426443','C How to Program',4,'2004',1,'chtp4.jpg',85.00)
;
insert into titles (isbn,title,editionNumber,copyright,publisherID,imageFile,price) values ('0130895725','C How to Program',3,'2001',1,'chtp3.jpg',69.95)
;
insert into titles (isbn,title,editionNumber,copyright,publisherID,imageFile,price) values ('0132261197','C How to Program',2,'1994',1,'chtp2.jpg',49.95)
;
insert into titles (isbn,title,editionNumber,copyright,publisherID,imageFile,price) values ('0130384747','C++ How to Program',4,'2003',1,'cpphtp4.jpg',85.00)
;
insert into titles (isbn,title,editionNumber,copyright,publisherID,imageFile,price) values ('0130895717','C++ How to Program',3,'2001',1,'cpphtp3.jpg',69.95)
;
insert into titles (isbn,title,editionNumber,copyright,publisherID, imageFile,price) values ('0135289106','C++ How to Program',2,'1998',1,'cpphtp2.jpg',49.95)
;
insert into titles (isbn,title,editionNumber,copyright,publisherID,imageFile,price) values ('013100252X','The Complete C++ Training Course',4,'2003',2,'cppctc4.jpg',109.99)
;
insert into titles (isbn,title,editionNumber,copyright,publisherID,imageFile,price) values ('0139163050','The Complete C++ Training Course',3,'2001',2,'cppctc3.jpg',109.95)
;

insert into authorISBN (authorID,isbn) values (1,'0130895725')
;
insert into authorISBN (authorID,isbn) values (1,'0132261197')
;
insert into authorISBN (authorID,isbn) values (1,'0130895717')
;
insert into authorISBN (authorID,isbn) values (1,'0135289106')
;
insert into authorISBN (authorID,isbn) values (1,'0139163050')
;
insert into authorISBN (authorID,isbn) values (1,'013028419x')
;
insert into authorISBN (authorID,isbn) values (1,'0130161438')
;
insert into authorISBN (authorID,isbn) values (1,'0130856118')
;
insert into authorISBN (authorID,isbn) values (4,'0130895601')
;

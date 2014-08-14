use test;

CREATE TABLE account (
	id_ INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(40) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	date_of_birth DATETIME,
	PRIMARY KEY (id_)
);
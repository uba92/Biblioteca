CREATE TABLE pubblicazioni(
	codice_ISBN SERIAL PRIMARY KEY,
	titolo VARCHAR(50) NOT NULL,
	anno_pubblicazione DATE NOT NULL,
	numero_pagine INT NOT NULL
);

CREATE TABLE autore(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	cognome VARCHAR(50) NOT NULL
);

CREATE TABLE genere(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL
);

CREATE TABLE libri(
	codice_ISBN SERIAL PRIMARY KEY,
	CONSTRAINT fk_pubblicazioni FOREIGN KEY (codice_ISBN) REFERENCES pubblicazioni(codice_ISBN),
	autore_id INT,
	CONSTRAINT fk_autore FOREIGN KEY (autore_id) REFERENCES autore(id),
	genere_id INT,
	CONSTRAINT fk_genere FOREIGN KEY (genere_id) REFERENCES genere(id)
);

CREATE TABLE riviste(
	codice_ISBN SERIAL PRIMARY KEY,
	CONSTRAINT fk_pubblicazioni FOREIGN KEY (codice_ISBN) REFERENCES pubblicazioni(codice_ISBN),
	periodicita VARCHAR(50) NOT NULL,
	CHECK (periodicita IN ('SETTIMANALE', 'MENSILE', 'SEMESTRALE'))
);

CREATE TABLE utente(
	numero_tessera SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	cognome VARCHAR(50) NOT NULL
);

CREATE TABLE prestiti(
	id SERIAL PRIMARY KEY,
	utente_id INT,
	CONSTRAINT fk_utente FOREIGN KEY(utente_id) REFERENCES utente(numero_tessera),
	pubblicazione_id INT,
	CONSTRAINT fk_pubblicazioni FOREIGN KEY(pubblicazione_id) REFERENCES pubblicazioni(codice_ISBN),
	data_inizio DATE NOT NULL,
	data_fine_prevista DATE NOT NULL,
	data_fine_effettiva DATE NOT NULL
);
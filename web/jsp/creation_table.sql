DROP TABLE ALUMNI.HISTORIQUE_ETUDIANT_POSTE;
DROP TABLE ALUMNI.RESPONSABLE;
DROP TABLE ALUMNI.MESSAGE;
DROP TABLE ALUMNI.ETUDIANT;
DROP TABLE ALUMNI.ENTREPRISE;
DROP TABLE ALUMNI.COMPTE;
DROP TABLE ALUMNI.PROMOTION;
DROP TABLE ALUMNI.POSTE;




CREATE TABLE ALUMNI.COMPTE(
	idCompte 	INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	login 		VARCHAR(30) NOT NULL UNIQUE, 
	pass 		VARCHAR(8) NOT NULL,
        statut          VARCHAR(15) CHECK (statut IN('ETUDIANT','ENTREPRISE','RESPONSABLE')),
	PRIMARY KEY(idCompte)
);

CREATE TABLE ALUMNI.ENTREPRISE(
	idEntreprise            INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	idCompte		INT NOT NULL, 
	nomResponsable          VARCHAR(30) NOT NULL,
	siteWeb			VARCHAR(30),
	nomEntreprise           VARCHAR(30),
	adresseSiege            VARCHAR(30),
	mail			VARCHAR(30) NOT NULL,
	tel                     INTEGER,
	FOREIGN KEY(idCompte) REFERENCES ALUMNI.Compte(idCompte),
	PRIMARY KEY(idEntreprise)
);

CREATE TABLE ALUMNI.PROMOTION(
	idPromotion             INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	annee 			DATE NOT NULL, 
	type 			VARCHAR(20) NOT NULL,
	PRIMARY KEY(idPromotion)
);

CREATE TABLE ALUMNI.POSTE(
	idPoste 		INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	idEntreprise            INT, 
	intitule		VARCHAR(30),
	description		VARCHAR(255),
	salaire			DOUBLE,
	PRIMARY KEY(idPoste)
);

CREATE TABLE ALUMNI.ETUDIANT(
	idEtudiant		INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	idPromotion		INT NOT NULL,
	idCompte		INT NOT NULL,
	nom 			VARCHAR(30)NOT NULL,
	prenom 			VARCHAR(30)NOT NULL,
	adresese 		VARCHAR(255)NOT NULL,
	mail			VARCHAR(30)NOT NULL,
	tel			INTEGER,
        sexe                    VARCHAR(1),
        dateNaissance           Date,
        PRIMARY KEY (idEtudiant),
        FOREIGN KEY (idPromotion) REFERENCES ALUMNI.PROMOTION,
        FOREIGN KEY (idCompte) REFERENCES ALUMNI.COMPTE
);

CREATE TABLE ALUMNI.HISTORIQUE_ETUDIANT_POSTE(
	idEtudiant 		INT NOT NULL,
	idPoste			INT NOT NULL, 
	dateDebut		DATE NOT NULL,
	dateFin			DATE NOT NULL,
	salaire			INT NOT NULL,
	localisation            VARCHAR(30) NOT NULL,
	categorie		VARCHAR(10) NOT NULL,
	FOREIGN KEY(idEtudiant) REFERENCES ALUMNI.Etudiant(idEtudiant),
	FOREIGN KEY(idPoste) REFERENCES ALUMNI.Poste(idPoste),
	PRIMARY KEY(idEtudiant, idPoste)
);

CREATE TABLE ALUMNI.RESPONSABLE(
        idInscrit		INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
        idCompte		INT NOT NULL,
        numHarpege		INTEGER,
        nom 			VARCHAR(30) NOT NULL,
        prenom 			VARCHAR(30) NOT NULL,
        adresese 		VARCHAR(255) NOT NULL,
        mail			VARCHAR(30) NOT NULL,
        tel			INTEGER,      
        PRIMARY KEY (idInscrit),
        FOREIGN KEY (idCompte) REFERENCES ALUMNI.COMPTE
);

CREATE TABLE ALUMNI.MESSAGE(
        idMessage                   INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
        idCompteEmmetteur           INT NOT NULL,
        idCompteDestinataire        INT NOT NULL,
        date                        DATE,
        message                     VARCHAR(255)NOT NULL,    
        PRIMARY KEY (idMessage),
        FOREIGN KEY (idCompteEmmetteur) REFERENCES ALUMNI.COMPTE,
        FOREIGN KEY (idCompteDestinataire) REFERENCES ALUMNI.COMPTE
);

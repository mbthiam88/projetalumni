DROP TABLE ALUMNI.HISTORIQUE_ETUDIANT_POSTE;
DROP TABLE ALUMNI.POSTE;
DROP TABLE ALUMNI.RESPONSABLE;
DROP TABLE ALUMNI.MESSAGE;
DROP TABLE ALUMNI.RELATION_ETUDIANT;
DROP TABLE ALUMNI.ETUDIANT;
DROP TABLE ALUMNI.ENTREPRISE;
DROP TABLE ALUMNI.PROMOTION;
DROP TABLE ALUMNI.COMPTE;





CREATE TABLE ALUMNI.COMPTE(
	idCompte 	INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	login 		VARCHAR(30) NOT NULL, 
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
	typePromo 		VARCHAR(20) CHECK (typePromo IN('CLASSIQUE','APPRENTISSAGE')),
	PRIMARY KEY(idPromotion)
);

CREATE TABLE ALUMNI.POSTE(
	idPoste 		INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	intitule		VARCHAR(30),
	description		VARCHAR(255),
        localisation            VARCHAR(10) NOT NULL CHECK (localisation IN('FRANCE','AUTRES')) DEFAULT 'FRANCE',   
        dateDebut               Date,
	salaire			DOUBLE,
	PRIMARY KEY(idPoste)
);

CREATE TABLE ALUMNI.ETUDIANT(
	idEtudiant		INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	idPromotion		INT,
	idCompte		INT NOT NULL, 
        idPoste                 INT,
        genre                   VARCHAR(7) CHECK (genre IN('HOMME','FEMME')),
        dateDeNaissance         DATE,
	nom 			VARCHAR(30)NOT NULL,
	prenom 			VARCHAR(30)NOT NULL,
	adresse 		VARCHAR(255)NOT NULL,
	mail			VARCHAR(30)NOT NULL,
	tel			VARCHAR(15),      
        photoProfil             VARCHAR(20),
        CV                      VARCHAR(20),
        PRIMARY KEY (idEtudiant),
        FOREIGN KEY (idCompte) REFERENCES ALUMNI.COMPTE
);

CREATE TABLE ALUMNI.RELATION_ETUDIANT(
        idEtudiant1 INT NOT NULL,
        idEtudiant2 INT NOT NULL,
        PRIMARY KEY (idEtudiant1, idEtudiant2),
        FOREIGN KEY (idEtudiant1) REFERENCES ALUMNI.ETUDIANT,
        FOREIGN KEY (idEtudiant2) REFERENCES ALUMNI.ETUDIANT
);

CREATE TABLE ALUMNI.HISTORIQUE_ETUDIANT_POSTE(
	idEtudiant 		INT,
	idPoste			INT, 
	dateFin			DATE,
	FOREIGN KEY(idEtudiant) REFERENCES ALUMNI.Etudiant(idEtudiant),
	FOREIGN KEY(idPoste) REFERENCES ALUMNI.Poste(idPoste),
	PRIMARY KEY(idEtudiant, idPoste)
);

CREATE TABLE ALUMNI.RESPONSABLE(
        idInscrit		INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
        idCompte		INT NOT NULL,
        numHarpege		VARCHAR(15),
        nom 			VARCHAR(30) NOT NULL,
        prenom 			VARCHAR(30) NOT NULL,
        adresse 		VARCHAR(255) NOT NULL,
        mail			VARCHAR(30) NOT NULL,
        tel			INTEGER,      
        PRIMARY KEY (idInscrit),
        FOREIGN KEY (idCompte) REFERENCES ALUMNI.COMPTE
);

CREATE TABLE ALUMNI.MESSAGE(
        idMessage                   INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
        idCompteEmmetteur           INT NOT NULL,
        idCompteDestinataire        INT NOT NULL,
        dateEnvoie                  DATE,
        message                     VARCHAR(255)NOT NULL,    
        PRIMARY KEY (idMessage),
        FOREIGN KEY (idCompteEmmetteur) REFERENCES ALUMNI.COMPTE,
        FOREIGN KEY (idCompteDestinataire) REFERENCES ALUMNI.COMPTE
);
DROP TABLE IF EXISTS utilisateur_role;
DROP TABLE IF EXISTS utilisateur;
DROP TABLE IF EXISTS contact;

CREATE TABLE contact (
    id integer NOT NULL,
    nom character varying(64),
    prenom character varying(64)
);

CREATE TABLE utilisateur (
    id integer NOT NULL,
    email character varying(255) NOT NULL UNIQUE,
    mot_de_passe character varying(64),
    actif boolean NOT NULL
);

CREATE TABLE utilisateur_role (
    email character varying(255) NOT NULL UNIQUE,
    role character varying(64)
);

ALTER TABLE contact ADD CONSTRAINT contact_pkey PRIMARY KEY (id);
ALTER TABLE utilisateur ADD CONSTRAINT utilisateur_pkey PRIMARY KEY (id);
ALTER TABLE utilisateur_role ADD CONSTRAINT utilisateur_role_pkey PRIMARY KEY (email, role);
ALTER TABLE utilisateur_role ADD CONSTRAINT utilisateur_role_nom_fkey FOREIGN KEY (email) REFERENCES utilisateur(email);

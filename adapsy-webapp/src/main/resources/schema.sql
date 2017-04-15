drop table if exists utilisateur_role;
drop table if exists utilisateur;
drop table if exists contact;
drop table if exists contact_statut;
drop table if exists adresse;
drop table if exists pays;
drop table if exists contact_fonction;
drop table if exists annonceur_groupe;
drop table if exists liaison_annonceur_groupe_annonceur;
drop table if exists annonceur;
drop table if exists liaison_annonceur_secteur;
drop table if exists secteur;
drop table if exists marque;
drop table if exists liaison_annonceur_groupe;
drop table if exists agence;
drop table if exists devis;
drop table if exists devis_statut;
drop table if exists devis_ligne;
drop table if exists facture;
drop table if exists produit;
drop table if exists devis_ligne;
drop table if exists facture;
drop table if exists facture_ligne;
drop table if exists reglement;
drop table if exists tarif;
drop table if exists tarif_famille;
drop table if exists tarif_type;
drop table if exists tva;
drop table if exists support;
drop table if exists support_interet;
drop table if exists emplacement;
drop table if exists rubrique;
drop table if exists support_type;
drop table if exists liaison_reglement_facture_ligne;

create table contact (
    id serial not null primary key,
    nom varchar(64),
    prenom varchar(64)
    
);

create table utilisateur (
    id serial not null primary key,
    email varchar(255) not null unique,
    mot_de_passe varchar(64),
    actif boolean NOT NULL
);

create table utilisateur_role (
    email varchar(255) not null unique,
    role varchar(64)
);

create table adresse (
    id serial not null primary key,
    adresse_1 varchar(45),
    adresse_2 varchar(45),
    adresse_3 varchar(45),
    cp varchar(45),
    ville varchar(45),
    email varchar(45),
    phone varchar(45),
    fax varchar(45),
    ref_pays integer not null
);

create table pays (
    id serial not null primary key,
    libelle varchar(45) not null,
    code_iso char(2) not null
);

create table contact_fonction (
    id serial not null primary key,
    libelle varchar(45) not null
);

create table annonceur_groupe (
    id serial not null primary key,
    libelle varchar(45) not null,
    ref_contact integer not null
);

create table liaison_annonceur_groupe_annonceur (
    id serial not null primary key,
    ref_annonceur_groupe integer not null,
    ref_annonceur integer not null
);

create table annonceur (
    id serial not null primary key,
    ref_contact integer not null
);

create table liaison_annonceur_secteur (
    id serial not null primary key,
    ref_annonceur integer not null,
    ref_secteur integer not null
);

create table secteur (
    id serial not null primary key,
    libelle varchar(45) not null
);

create table marque (
    id serial not null primary key,
    ref_annonceur integer not null
);

create table liaison_annonceur_groupe (
    id serial not null primary key,
    ref_annonceur integer not null,
    ref_agence integer not null
);

create table agence (
    id serial not null primary key,
    ref_contact integer not null
);

create table devis (
    id serial not null primary key,
    ref_contact integer not null,
    ref_devis_statut integer not null,
    commentaire varchar(45) not null
);

create table devis_statut (
    id serial not null primary key,
    libelle varchar(45) not null
);
create table contact_statut (
    id serial not null primary key,
    libelle varchar(45) not null
);

create table devis_ligne (
    id serial not null primary key,
    ref_devis integer not null,
    ref_tarif integer not null,
    montant decimal(14, 2) not null,
    ttc boolean not null,
    remise decimal(5, 2) not null
);

create table facture (
    id serial not null primary key,
    no_facture varchar(45) not null,
    date_echeance date not null,
    ref_devis integer not null
);

create table produit (
    id serial not null primary key,
    ref_marque integer not null
);

create table facture_ligne (
    id serial not null primary key,
    ref_devis integer not null,
    ref_facture integer not null,
    montant decimal(14, 2) not null,
    ttc boolean not null,
    remise decimal(5, 2) not null
);

create table reglement (
    id serial not null primary key,
    ref_facture integer not null,
    montant decimal(14, 2) not null
);

create table tarif (
    id serial not null primary key,
    ref_support integer not null,
    montant decimal(14, 2) not null,
    ttc boolean not null,
    ref_tarif_famille integer not null,
    ref_tarif_type integer not null,
    ref_tva integer not null
);

create table tarif_famille (
    id serial not null primary key,
    libelle varchar(45) not null
);

create table tarif_type (
    id serial not null primary key,
    libelle varchar(45) not null
);

create table tva (
    id serial not null primary key,
    taux_tva decimal(5, 2) not null
);

create table support (
    id serial not null primary key,
    ref_support_type integer not null,
    libelle varchar(45) not null
);

create table emplacement (
    id serial not null primary key,
    ref_support integer not null
);
create table support_interet (
    id serial not null primary key,
    ref_support integer not null
);

create table rubrique (
    id serial not null primary key,
    ref_support integer not null
);

create table support_type (
    id serial not null primary key,
    libelle varchar(45) not null
);

create table liaison_reglement_facture_ligne (
    id serial not null primary key,
    ref_reglement integer not null,
    ref_facture_ligne integer not null
);

alter table utilisateur_role add constraint utilisateur_role_pkey primary key (email, role);
alter table utilisateur_role add constraint utilisateur_role_nom_fkey foreign key (email) references utilisateur(email);

INSERT INTO contact (id, nom, prenom) VALUES
('1', 'Levesque', 'Anthony'),
('2', 'Defossez', 'Thomas'),
('3', 'Henrotte', 'Patrick');

INSERT INTO utilisateur (id, email, mot_de_passe, actif) VALUES
('1', 'alevesque@tbsblue.com', 'password', '1'),
('2', 'tdefossez@tbsblue.com', 'Thomas040673', '1');

INSERT INTO utilisateur_role (email, role) VALUES
('alevesque@tbsblue.com', 'ANY');

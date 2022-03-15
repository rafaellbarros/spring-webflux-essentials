--------------------------------------------------------
--  DML for Table tb_anime
--------------------------------------------------------
--DELETE FROM tb_devdojo_user;
INSERT INTO anime.tb_devdojo_user (name, username, password, authorities) VALUES ('Rafael Barros', 'rafaellbarros','{bcrypt}$2a$10$64EmdwDCHbhTVAZg7hNw3.uUUIUSsZT9M6771MXcqALFQ95da/nae', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO anime.tb_devdojo_user (name, username, password, authorities) VALUES ('Xablau', 'xablau','{bcrypt}$2a$10$64EmdwDCHbhTVAZg7hNw3.uUUIUSsZT9M6771MXcqALFQ95da/nae', 'ROLE_USER');
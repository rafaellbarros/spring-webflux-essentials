--------------------------------------------------------
--  DDL for Table tb_devdojo_user
--------------------------------------------------------

DROP TABLE IF EXISTS anime.tb_devdojo_user;
CREATE TABLE anime.tb_devdojo_user
(
    id serial NOT NULL,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    authorities VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);
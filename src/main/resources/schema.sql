--------------------------------------------------------
--  DDL for Table tb_anime
--------------------------------------------------------

DROP TABLE IF EXISTS tb_anime;
CREATE TABLE tb_anime
(
    id serial NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);


--------------------------------------------------------
--  DDL for Table tb_devdojo_user
--------------------------------------------------------

DROP TABLE IF EXISTS tb_devdojo_user;
CREATE TABLE tb_devdojo_user
(
    id serial NOT NULL,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(150) NOT NULL,
    authorities VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);
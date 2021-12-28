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
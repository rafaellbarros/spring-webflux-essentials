--------------------------------------------------------
--  DDL for Table tb_anime
--------------------------------------------------------

DROP TABLE IF EXISTS anime.tb_anime;
CREATE TABLE anime.tb_anime
(
    id serial NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

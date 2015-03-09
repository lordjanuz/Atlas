-- -----------------------------------------------------------------------------
-- Alta Base de Datos - - - SQLite
-- -----------------------------------------------------------------------------
 sqlite3 Atlas.db
-- -----------------------------------------------------------------------------
-- Tabla PLANTA
-- -----------------------------------------------------------------------------
create table PLANTA (
ID INTEGER PRIMARY KEY AUTOINCREMENT,
COMMONNAME char(50),
SCIENTIFICNAME char(50) ,
FAMILY char(50),
DESCRIPTION char(255)
);
-- -----------------------------------------------------------------------------
-- Unique Index
-- -----------------------------------------------------------------------------
create unique index UK_SCIENTIFICNAME on PLANTA(CIENTIFICNAME);
-- -----------------------------------------------------------------------------
-- PLANTAS
-- -----------------------------------------------------------------------------
INSERT INTO PLANTA (COMMONNAME, CIENTIFICNAME, FAMILY, DESCRIPTION)
VALUES ('Haya Verde Llorona', 'Fagus Silvatica', 'Fagaceas', 'Fagus - Lorem ipsum dolor sit amet consectetur adipiscing elit. Phasellus egestas pharetra quam.');

INSERT INTO PLANTA(COMMONNAME, CIENTIFICNAME, FAMILY, DESCRIPTION)
VALUES ('Fresno mayor', 'Frexinus Excelsior', 'Oleaceas', 'Frexinus','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus egestas pharetra quam.');

INSERT INTO PLANTA(COMMONNAME, CIENTIFICNAME, FAMILY, DESCRIPTION)
VALUES ('Jacaranda', 'Jacaranda Mimosifolia', 'Bignoniaceas', 'Jacaranda - Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus egestas pharetra quam.');

INSERT INTO PLANTA(COMMONNAME, CIENTIFICNAME, FAMILY, DESCRIPTION)
VALUES ('Ã�rbol del Ã¡mbar', 'Liquidambar Styraciflua', 'Altingiaceas', 'Liquidambar - Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus egestas pharetra quam.');

INSERT INTO PLANTA(COMMONNAME, CIENTIFICNAME, FAMILY, DESCRIPTION)
VALUES ('Cinamomo', 'Melia azedarach','Meliaceas', 'Melia - Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus egestas pharetra quam.');
create table PLANTA (
        ID bigint not null auto_increment,
		COMMONNAME varchar(255),
		CIENTIFICNAME varchar(255),
		FAMILY varchar(255),
		DESCRIPTION varchar(255),
        primary key (ID)
    );



DROP TABLE PLANTA;


--SQLite
--ingreso a Base
 sqlite3 Atlas.db

--Creacion de Base de datos PLANTA
create table PLANTA (
ID INTEGER PRIMARY KEY   AUTOINCREMENT,
COMMONNAME char(50),
CIENTIFICNAME char(50),
FAMILY char(50),
DESCRIPTION char(50)
);


insert into PLANTA values('Haya Verde Llorona', 'Fagus Silvatica', 'Fagaceas', 'Fagus - Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus egestas pharetra quam.');


INSERT INTO PLANTA (COMMONNAME, CIENTIFICNAME, FAMILY,  DESCRIPTION)
VALUES ('Haya Verde Llorona', 'Fagus Silvatica', 'Fagaceas', 'Fagus - Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus egestas pharetra quam.');
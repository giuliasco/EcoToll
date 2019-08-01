drop database if exists EcoToll;
create database EcoToll;
use EcoToll;

create table autostrada (
id int not null auto_increment primary key unique,
nome_autostrada varchar(50) not null,
inizio varchar(50) not null,
fine varchar(50) not null,
km double not null,
tariffa_km decimal
);


create table casello(
id int not null auto_increment primary key unique,
nome_casello varchar(50) not null,
altezza_km double not null,
id_autostrada int not null,
constraint autostrada_casello foreign key(id_autostrada) references autostrada(id) on delete cascade on update cascade
);

create table classe_europea(
id int not null auto_increment primary key unique,
tipo varchar(50) not null,
aggiunta double
);

create table classe_italiana(
id int not null auto_increment primary key unique,
tipo varchar(50) not null,
aggiunta double
);


create table normativa(
id int not null auto_increment primary key unique,
nome_normativa varchar(50),
anno_normativa int(255)
);

create table ruolo(
id int not null auto_increment primary key unique,
tipo_utente varchar(50) not null
);


create table utente(
id int not null auto_increment primary key unique,
nome_utente varchar(50) not null,
cognome_utente varchar(50) not null,
username varchar(50) not null unique,
pwd varchar(45) not null,
id_ruolo int not null,
constraint utente_ruolo foreign key(id_ruolo) references ruolo(id) on update cascade
);

create table veicolo(
id int not null auto_increment primary key unique,
targa varchar(50) not null,
id_ci int not null,
id_ceu int not null,
id_utente int not null,
constraint classeitaliana_veicolo foreign key(id_ci) references classe_italiana(id) on delete cascade on update cascade,
constraint classeuropea_veicolo foreign key(id_ceu) references classe_europea(id) on delete cascade on update cascade,
constraint utente_veicolo foreign key(id_utente) references utente(id) on delete cascade on update cascade
);



 
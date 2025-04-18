create database SafePassenger;
use SafePassenger;

drop database SafePassenger;

create table conductor(
    id_conductor int not null auto_increment,
    nombre varchar(25),
    apellido varchar(30),
    correo varchar(50),
    telefono varchar(15),
    licencia varchar(10),
    contraseña varchar(225),
    constraint PK_id_conductor primary key (id_conductor),
    constraint UNIQ_correo unique (correo)
);

create table usuario(
    id_usuario int not null auto_increment,
    nombre varchar(25),
    apellido varchar(30),
    correo varchar(50),
    telefono varchar(15),
    contraseña varchar(225),
    constraint PK_id_usuario primary key (id_usuario),
    constraint UNIQ_correo unique (correo)
);

create table automovil(
    placa varchar(20) not null, -- Cambiar el tipo de dato de la placa.
    id_conductor int,
    marca varchar(50),
    color varchar(15),
    año int,
    modelo varchar(25),
    constraint PK_placa primary key(placa),
    constraint FK_id_driver foreign key(id_conductor) references conductor(id_conductor)
);

create table scanner(
    id_scanner int not null auto_increment,
    pasajero varchar(100),
    conductor varchar(100),
    modelo varchar(25),
    color varchar(15),
    placa varchar(20) not null,
    fecha date not null,
    estado varchar(20),
    constraint PK_id_scanner primary key(id_scanner),
    constraint FK_placa_auto foreign key(placa) references automovil(placa)
);

create table history_scanner(
id_history_scanner int not null auto_increment,
id_scanner int not null,
conductor varchar(100),
telefono_conductor varchar(15),
fecha date not null,
constraint PK_id_history_scanner primary key(id_history_scanner),
constraint FK_id_scanner foreign key(id_scanner) references scanner(id_scanner)
);

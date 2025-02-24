CREATE TABLE Conductor(
idConductor INT NOT NULL PRIMARY KEY,
numeroTelefono INT NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
numeroLicencia INT NOT NULL
);
CREATE TABLE Usuario(
    idUsuario INT  NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    numeroTelefono INT NOT NULL,
    contraseña VARCHAR(100) NOT NULL,
    idConductor INT,
    constraint fk_con FOREIGN KEY (idConductor) REFERENCES Conductor(idConductor)
	);
CREATE TABLE automovil(
    placa INT  NOT NULL PRIMARY KEY,
    marca VARCHAR(30) NOT NULL,
    modelo VARCHAR(30) NOT NULL,
    año VARCHAR(30) NOT NULL,
    color VARCHAR(30) NOT NULL,
    idConductor INT,
    CONSTRAINT fk_con_auto FOREIGN KEY (idConductor) REFERENCES Conductor(idConductor)
);
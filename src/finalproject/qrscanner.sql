CREATE TABLE Usuario (
    idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    numeroTelefono VARCHAR(15) NOT NULL,
    contraseña VARCHAR(100) NOT NULL,
    tipoUsuario ENUM('Usuario', 'Conductor') NOT NULL, 
    numeroLicencia VARCHAR(20) UNIQUE NULL
)

CREATE TABLE Scanner(
idscanner INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
fecha_hora DATETIME,
codigo_qr VARCHAR(200),
idusuario INT,
constraint fk_usu_scanner FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario) ON DELETE CASCADE
)

CREATE TABLE Automovil(
idAuto INT AUTO_INCREMENT PRIMARY KEY,
marca VARCHAR(50),
modelo VARCHAR(50),
placa VARCHAR(20),
constraint fk_usu_auto FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario) ON DELETE CASCADE
)

    
DELIMITER //

CREATE TRIGGER before_insert_automovil
BEFORE INSERT ON Automovil
FOR EACH ROW
BEGIN
    DECLARE tipo VARCHAR(20);

    -- Obtener el tipo de usuario asociado al idUsuario
    SELECT tipoUsuario INTO tipo FROM Usuario WHERE idUsuario = NEW.idUsuario;

    -- Validar que el usuario exista y sea un Conductor
    IF tipo IS NULL OR tipo <> 'Conductor' THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Solo los conductores pueden registrar un automóvil';
    END IF;
END;
//

DELIMITER ;

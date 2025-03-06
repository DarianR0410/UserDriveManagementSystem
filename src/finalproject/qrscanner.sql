CREATE TABLE Usuario (
    idUsuario INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    numeroTelefono VARCHAR(15) NOT NULL,
    contraseña VARCHAR(100) NOT NULL,
    tipoUsuario ENUM('Usuario', 'Conductor') NOT NULL, 
    numeroLicencia VARCHAR(20) UNIQUE NULL
);

    
DELIMITER //
CREATE TRIGGER before_insert_automovil
BEFORE INSERT ON Automovil
FOR EACH ROW
BEGIN
    DECLARE tipo VARCHAR(20);
    
    -- Obtener el tipo de usuario
    SELECT tipoUsuario INTO tipo FROM Usuario WHERE idUsuario = NEW.idUsuario;
    
    -- Validar que solo se agreguen conductores
    IF tipo <> 'Conductor' THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Solo los conductores pueden registrar un automóvil';
    END IF;
END;
//
DELIMITER ;

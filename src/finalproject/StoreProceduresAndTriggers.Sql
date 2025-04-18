use SafePassenger;

-- SP PARA REGISTRAR EL AUTO + CONDUCTOR
DELIMITER //
CREATE PROCEDURE RegistrarConductorYAuto(
    IN p_nombre VARCHAR(25),
    IN p_apellido VARCHAR(30),
    IN p_correo VARCHAR(50),
    IN p_telefono VARCHAR(15),
    IN p_licencia VARCHAR(10),
    IN p_contrasenia VARCHAR(225),
    IN p_placa VARCHAR(20),
    IN p_marca VARCHAR(50),
    IN p_color VARCHAR(15),
    IN p_anio INT,
    IN p_modelo VARCHAR(50)
)
BEGIN
    DECLARE new_id_conductor INT;

    -- Insertar en tabla conductor
    INSERT INTO conductor(nombre, apellido, correo, telefono, licencia, contraseña)
    VALUES (p_nombre, p_apellido, p_correo, p_telefono, p_licencia, p_contrasenia);

    -- Obtener el ID generado automáticamente
    SET new_id_conductor = LAST_INSERT_ID();

    -- Insertar en tabla automovil con el ID recién generado
    INSERT INTO automovil(placa, id_conductor, marca, color, año, modelo)
    VALUES (p_placa, new_id_conductor, p_marca, p_color, p_anio, p_modelo);
END;
//
DELIMITER ;


-- TRIGGER FOR USER ID:
DELIMITER //

CREATE TRIGGER id_usuario_gen
BEFORE INSERT ON usuario
FOR EACH ROW
BEGIN
    DECLARE current_year INT;
    DECLARE last_id INT;
    DECLARE last_number INT;
    DECLARE new_id INT;

    SET current_year = YEAR(CURDATE());

    -- Get the max id_usuario that starts with the current year
    SET last_id = (
        SELECT MAX(id_usuario)
        FROM usuario
        WHERE id_usuario DIV 10000 = current_year
    );

    IF last_id IS NULL THEN
        SET new_id = current_year * 10000 + 1;
    ELSE
        SET last_number = last_id % 10000;
        SET new_id = current_year * 10000 + last_number + 1;
    END IF;

    SET NEW.id_usuario = new_id;
END//

DELIMITER ;

-- TRIGGER PARA EL ID DEL CONDUCTOR:

delimiter //
create trigger id_conductor_gen
before insert on conductor
for each row
begin
    declare current_year varchar(4);
    declare last_id varchar(8);
    declare new_id varchar(8);
    declare last_number int;

    set current_year = year(curdate());
    set last_id = (select max(id_conductor) from conductor where cast(id_conductor as char) like concat(current_year, '%'));

    if last_id is null then
        set new_id = concat(current_year, lpad(1, 4, '0'));
    else
        set last_number = cast(substring(cast(last_id as char), 5) as unsigned);
        set new_id = concat(current_year, lpad(last_number + 1, 4, '0'));
    end if;

    set new.id_conductor = new_id;
end//
delimiter ;

-- SP PARA ALMACENAR LA INFO DEL SCANNER + HISTORIAL:

DELIMITER $$

CREATE PROCEDURE InsertScannerAndHistory(
    IN p_pasajero VARCHAR(100),
    IN p_conductor VARCHAR(100),
    IN p_modelo VARCHAR(25),
    IN p_color VARCHAR(15),
    IN p_placa VARCHAR(20),
    IN p_telefono_conductor VARCHAR(15)
)
BEGIN
    DECLARE new_id_scanner INT;

    -- Insert into scanner table with current date
    INSERT INTO scanner(pasajero, conductor, modelo, color, placa, fecha)
    VALUES (p_pasajero, p_conductor, p_modelo, p_color, p_placa, CURRENT_DATE);

    -- Get the last generated id_scanner
    SET new_id_scanner = LAST_INSERT_ID();

    -- Insert into history_scanner with current date
    INSERT INTO history_scanner(id_scanner, conductor, telefono_conductor, fecha)
    VALUES (new_id_scanner, p_conductor, p_telefono_conductor, CURRENT_DATE);
END$$

DELIMITER ;


-- TRIGGER PARA EL ESTADO:

DELIMITER $$

CREATE TRIGGER trg_set_estado_scanner
BEFORE INSERT ON scanner
FOR EACH ROW
BEGIN
    IF NEW.pasajero IS NULL OR NEW.conductor IS NULL OR NEW.modelo IS NULL
       OR NEW.color IS NULL OR NEW.placa IS NULL OR NEW.fecha IS NULL THEN
        SET NEW.estado = 'invalido';
    ELSE
        SET NEW.estado = 'valido';
    END IF;
END$$

DELIMITER ;

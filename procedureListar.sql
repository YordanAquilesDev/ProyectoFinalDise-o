USE DB_universidad;

-- Cambiar el delimitador para poder crear los procedimientos en MySQL
DELIMITER //

-- 1. Procedimiento para listar Alumnos
DROP PROCEDURE IF EXISTS sp_listar_alumnos;
CREATE PROCEDURE sp_listar_alumnos()
BEGIN
    SELECT * FROM alumno;
END //

-- 2. Procedimiento para listar Secciones (Solo la tabla seccion)
DROP PROCEDURE IF EXISTS sp_listar_secciones;
CREATE PROCEDURE sp_listar_secciones()
BEGIN
    SELECT * FROM seccion;
END //

-- 3. Procedimiento para listar Horarios (Solo la tabla horario)
DROP PROCEDURE IF EXISTS sp_listar_horarios;
CREATE PROCEDURE sp_listar_horarios()
BEGIN
    SELECT * FROM horario;
END //

-- 4. Procedimiento para listar Pensiones (Solo la tabla pension)
DROP PROCEDURE IF EXISTS sp_listar_pensiones;
CREATE PROCEDURE sp_listar_pensiones()
BEGIN
    SELECT * FROM pension;
END //

-- Restaurar el delimitador por defecto
DELIMITER ;
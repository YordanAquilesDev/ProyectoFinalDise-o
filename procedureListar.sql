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

DELIMITER //

CREATE PROCEDURE sp_listar_cursos_alumno(IN id_alumno INT)
BEGIN
    SELECT 
        c.id_curso,
        c.id_carrera,
        c.codigo AS codigo_curso,
        c.nombre AS nombre_curso,
        c.creditos,
        c.ciclo_nivel,
       -- s.codigo_seccion,
      --  s.aula,
     --   p.nombre AS periodo,
      --  dm.promedio_final,
      --  dm.estado_curso
    FROM curso c
    JOIN seccion s ON c.id_curso = s.id_curso
    JOIN detalle_matricula dm ON s.id_seccion = dm.id_seccion
    JOIN matricula m ON dm.id_matricula = m.id_matricula
    JOIN periodo_academico p ON s.id_periodo = p.id_periodo
    WHERE m.id_alumno = id_alumno;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE sp_listar_calificacion_curso(IN p_id_curso INT)
BEGIN
    SELECT 
        c.id_calificacion,
        c.id_detalle_matricula,
        c.nombre_evaluacion,
        c.ponderado,
        c.nota,
        c.fecha_registro
    FROM calificacion c
    JOIN detalle_matricula dt ON c.id_detalle_matricula = dt.id_detalle_matricula
    JOIN seccion sc ON dt.id_seccion = sc.id_seccion
    JOIN curso cu ON sc.id_curso = cu.id_curso -- Corrección aquí (sc.id_curso en lugar de sc-id_curso)
    WHERE cu.id_curso = p_id_curso;
END //

DELIMITER ;

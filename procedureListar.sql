USE DB_universidad;

-- Cambiar el delimitador para poder crear los procedimientos en MySQL
DELIMITER //
CREATE PROCEDURE sp_listar_alumnos()
BEGIN
    SELECT * FROM alumno;
END //

CREATE PROCEDURE sp_listar_secciones()
BEGIN
    SELECT * FROM seccion;
END //

CREATE PROCEDURE sp_listar_horarios()
BEGIN
    SELECT * FROM horario;
END //

CREATE PROCEDURE sp_listar_pensiones()
BEGIN
    SELECT * FROM pension;
END //

-- Restaurar el delimitador por defecto
DELIMITER ;

DELIMITER //

CREATE PROCEDURE sp_listar_cursos_alumno(IN p_id_alumno INT)
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
    WHERE m.id_alumno = p_id_alumno;
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

DELIMITER //
CREATE PROCEDURE sp_listar_horarios_alumno(IN p_id_alumno INT)
BEGIN
    SELECT 
        h.id_horario,
        h.id_seccion,
        h.dia_semana,
        h.hora_inicio,
        h.hora_fin,
        h.aula
    FROM horario h
    JOIN detalle_matricula dt ON h.id_seccion = dt.id_seccion
    join Matricula m on dt.id_matricula= m.id_matricula;   
    WHERE m.id_alumno=p_id_alumno;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_matricular_alumno(
    in p_id_alumno int,
    in p_id_periodo int,
    in p_monto_total int,
)
BEGIN
    insert into matricula  id_alumno,id_periodo,fecha_matricula,monto_total,estado values
    (p_id_alumno,p_id_periodo,now(),p_monto_total,'REGISTRADA');
END //
DELIMITER ;




DELIMITER //
CREATE PROCEDURE sp_detalle_matricula_alumno(
    in p_id_matricula int,
    in p_id_seccion int,
)
BEGIN

    insert into detalle_matricula id_matricula,id_seccion,promedio_final,estado_curso values
    (p_id_matricula,p_id_seccion,null,'CURSANDO');
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_listar_secciones_periodo(
    in p_id_periodo int,
)
BEGIN
    SELECT 
        s.id_seccion,
        s.id_curso,
        s.codigo_seccion,
        s.aula,
        s.id_periodo,
        s.cupo_maximo
    FROM seccion s
    WHERE s.id_periodo = p_id_periodo;
END //
DELIMITER ;



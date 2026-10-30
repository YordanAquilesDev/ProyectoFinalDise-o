

DELIMITER //
CREATE PROCEDURE sp_listar_cursos_alumno(IN p_id_alumno INT)
BEGIN
    SELECT 
        c.id_curso,
        c.id_carrera,
        c.codigo AS codigo_curso,
        c.nombre AS nombre_curso,
        c.creditos,
        c.ciclo_nivel

    FROM curso c
    JOIN seccion s ON c.id_curso = s.id_curso
    JOIN detalle_matricula dm ON s.id_seccion = dm.id_seccion
    JOIN matricula m ON dm.id_matricula = m.id_matricula
    JOIN periodo_academico p ON s.id_periodo = p.id_periodo
    WHERE m.id_alumno = p_id_alumno;
END //

DELIMITER ;


DELIMITER //

DELIMITER //
CREATE PROCEDURE sp_listar_calificacion_curso(
    IN p_id_curso INT,
    IN p_id_alumno INT
)
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
    JOIN matricula m ON dt.id_matricula = m.id_matricula       
    JOIN seccion sc ON dt.id_seccion = sc.id_seccion
    JOIN curso cu ON sc.id_curso = cu.id_curso
    WHERE cu.id_curso = p_id_curso 
      AND m.id_alumno = p_id_alumno;                          
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
    join Matricula m on dt.id_matricula= m.id_matricula   
    WHERE m.id_alumno=p_id_alumno;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_matricular_alumno(
    in p_id_alumno int,
    in p_id_periodo int,
    in p_monto_total int
)
BEGIN
    insert into matricula  (id_alumno,id_periodo,fecha_matricula,monto_total,estado) values
    (p_id_alumno,p_id_periodo,now(),p_monto_total,'REGISTRADA');
END //
DELIMITER ;




DELIMITER //
CREATE PROCEDURE sp_detalle_matricula_alumno(
    in p_id_matricula int,
    in p_id_seccion int
)
BEGIN

    insert into detalle_matricula (id_matricula,id_seccion,promedio_final,estado_curso) values
    (p_id_matricula,p_id_seccion,null,'CURSANDO');
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_listar_secciones_periodo(
    in p_id_periodo int
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

DELIMITER //
CREATE PROCEDURE sp_listar_alumnos_seccion(
    in p_id_seccion int
)
BEGIN
select 
a.id_alumno, 
a.id_carrera,
a.nombres, 
a.apellidos, 
a.dni, 
a.email, 
a.telefono,
a.fecha_nacimiento
from alumno a
join matricula m on a.id_alumno = m.id_alumno
join detalle_matricula dm on m.id_matricula = dm.id_matricula
where dm.id_seccion = p_id_seccion;
end //
DELIMITER ;
call sp_listar_alumnos_seccion(1); -- funciona correctamente



DELIMITER //
create procedure sp_listar_secciones_docente(in p_id_docente int)
BEGIN
    SELECT 
        s.id_seccion,
        s.id_curso,
        s.codigo_seccion,
        s.aula,
        s.id_periodo,
        s.cupo_maximo
    FROM seccion s
    WHERE s.id_docente = p_id_docente;
END //
DELIMITER ;

call sp_listar_secciones_docente(1);-- funciona correctamente

DELIMITER //
create procedure sp_alumno_usuario(in p_id_usuario int)
BEGIN
   select 
a.id_alumno, 
a.id_carrera,
a.nombres, 
a.apellidos, 
a.dni, 
a.email, 
a.telefono,
a.fecha_nacimiento
from alumno a
join usuario u on a.id_usuario=u.id_usuario
where u.id_usuario=p_id_usuario;
END //
DELIMITER ;


DELIMITER //

CREATE PROCEDURE sp_login(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255)
)
BEGIN
    SELECT 
        id_usuario,
        username,
        password_hash,
        rol,
        estado
    FROM usuario
    WHERE username = p_username 
      AND password_hash = p_password 
      AND estado = TRUE;
END //
DELIMITER ;

DELIMITER //
create procedure sp_docente_usuario(in p_id_usuario int)
BEGIN
   select 
   d.*

from docente a
join usuario u on a.id_usuario=u.id_usuario
where u.id_usuario=p_id_usuario;
END //
DELIMITER ;

DELIMITER //

-- 2. Creamos la nueva versión con 4 argumentos
CREATE PROCEDURE sp_calificar_alumno(    
    IN p_id_detalle_matricula INT,
    IN p_nombre_evaluacion VARCHAR(50),
    IN p_nota DECIMAL(4,2),
    IN p_ponderado DECIMAL(5,2)
)
BEGIN
    INSERT INTO calificacion (
        id_detalle_matricula, 
        nombre_evaluacion, 
        ponderado, 
        nota
    ) 
    VALUES (
        p_id_detalle_matricula, 
        p_nombre_evaluacion, 
        p_ponderado, 
        p_nota
    );
END //

DELIMITER ;

DELIMITER //

-- 2. Creamos la nueva versión con 4 argumentos
CREATE PROCEDURE sp_matricula_alumno(    
 in p_id_alumno int
)
BEGIN
   select *
   from matricula 
   where m.id_alumno=p_id_alumno
END //

DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_matricular_alumno(    
    IN p_id_alumno INT,
    IN p_id_periodo INT,
    IN p_monto_total DECIMAL(10,2) -- Cambiado a DECIMAL para coincidir con tu tabla
)
BEGIN
    -- 1. Insertamos la matrícula
    INSERT INTO matricula (id_alumno, id_periodo, fecha_matricula, monto_total, estado) 
    VALUES (p_id_alumno, p_id_periodo, NOW(), p_monto_total, 'REGISTRADA');
    
    -- 2. Retornamos inmediatamente el ID generado para que Java lo lea con executeQuery()
    SELECT LAST_INSERT_ID() AS id_matricula;
END //

DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_listar_periodo_academico()
BEGIN
    SELECT 
      *
      from periodo_academico;
END //
DELIMITER 


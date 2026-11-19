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
    JOIN matricula m ON dt.id_matricula = m.id_matricula   
    WHERE m.id_alumno = p_id_alumno;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_detalle_matricula_alumno(
    IN p_id_matricula INT,
    IN p_id_seccion INT
)
BEGIN
    INSERT INTO detalle_matricula (id_matricula, id_seccion, promedio_final, estado_curso) 
    VALUES (p_id_matricula, p_id_seccion, NULL, 'CURSANDO');
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_listar_secciones_periodo(IN p_id_periodo INT)
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
CREATE PROCEDURE sp_listar_alumnos_seccion(IN p_id_seccion INT)
BEGIN
    SELECT 
        a.id_alumno, 
        a.id_carrera,
        a.nombres, 
        a.apellidos, 
        a.dni, 
        a.email, 
        a.telefono,
        a.fecha_nacimiento
    FROM alumno a
    JOIN matricula m ON a.id_alumno = m.id_alumno
    JOIN detalle_matricula dm ON m.id_matricula = dm.id_matricula
    WHERE dm.id_seccion = p_id_seccion;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_listar_secciones_docente(IN p_id_docente INT)
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


DELIMITER //
CREATE PROCEDURE sp_alumno_usuario(IN p_id_usuario INT)
BEGIN
    SELECT 
        a.id_alumno, 
        a.id_carrera,
        a.nombres, 
        a.apellidos, 
        a.dni, 
        a.email, 
        a.telefono,
        a.fecha_nacimiento
    FROM alumno a
    JOIN usuario u ON a.id_usuario = u.id_usuario
    WHERE u.id_usuario = p_id_usuario;
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
CREATE PROCEDURE sp_docente_usuario(IN p_id_usuario INT)
BEGIN
    SELECT d.*
    FROM docente d
    JOIN usuario u ON d.id_usuario = u.id_usuario
    WHERE u.id_usuario = p_id_usuario;
END //
DELIMITER ;


DELIMITER //
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
CREATE PROCEDURE sp_matricula_alumno(IN p_id_alumno INT)
BEGIN
    SELECT *
    FROM matricula m
    WHERE m.id_alumno = p_id_alumno;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_matricular_alumno(    
    IN p_id_alumno INT,
    IN p_id_periodo INT,
    IN p_monto_total DECIMAL(10,2)
)
BEGIN
    INSERT INTO matricula (id_alumno, id_periodo, fecha_matricula, monto_total, estado) 
    VALUES (p_id_alumno, p_id_periodo, NOW(), p_monto_total, 'REGISTRADA');
    
    -- Retorna el ID generado para que Java lo lea
    SELECT LAST_INSERT_ID() AS id_matricula;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_listar_periodo_academico()
BEGIN
    SELECT * FROM periodo_academico;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_procesar_pago_pension (
    IN p_id_pension INT,
    IN p_monto_pagado DECIMAL(10,2),
    IN p_monto_mora DECIMAL(10,2)
)
BEGIN
    DECLARE v_estado VARCHAR(20);
    SELECT estado INTO v_estado FROM pension WHERE id_pension = p_id_pension;

    IF v_estado = 'PENDIENTE' THEN
        UPDATE pension 
        SET estado = 'PAGADO',
            monto_mora = p_monto_mora,
            fecha_pago = NOW()
        WHERE id_pension = p_id_pension;
        
        SELECT 'SUCCESS' AS resultado, 'Pago registrado correctamente.' AS mensaje;
    ELSE
        SELECT 'ERROR' AS resultado, 'La pensión ya fue pagada o no existe.' AS mensaje;
    END IF;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_pensiones_pendientes_alumno(IN p_id_alumno INT)
BEGIN
    SELECT 
        id_pension,
        id_alumno,
        id_matricula,
        numero_cuota,
        monto,
        monto_mora,
        fecha_vencimiento,
        fecha_pago,
        estado
    FROM pension
    WHERE id_alumno = p_id_alumno 
      AND estado = 'PENDIENTE'
    ORDER BY numero_cuota ASC;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_pagar_pension_alumno(
    IN p_id_alumno INT,
    IN p_id_pension INT,
    IN p_fecha_pago DATETIME
)
BEGIN
    UPDATE pension
    SET estado = 'PAGADO',
        fecha_pago = p_fecha_pago
    WHERE id_alumno = p_id_alumno
      AND id_pension = p_id_pension;
END //
DELIMITER ;
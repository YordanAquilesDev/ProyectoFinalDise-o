
-- 1. Tabla Carrera
CREATE TABLE carrera (
    id_carrera INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    codigo VARCHAR(20) UNIQUE NOT NULL,
    estado BOOLEAN DEFAULT TRUE
) ENGINE=InnoDB;

-- 2. Tabla Alumno
CREATE TABLE alumno (
    id_alumno INT AUTO_INCREMENT PRIMARY KEY,
    id_carrera INT NOT NULL,
    codigo VARCHAR(20) UNIQUE NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    dni VARCHAR(15) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    fecha_nacimiento DATE,
    CONSTRAINT fk_alumno_carrera FOREIGN KEY (id_carrera) REFERENCES carrera(id_carrera)
) ENGINE=InnoDB;

-- 3. Tabla Docente
CREATE TABLE docente (
    id_docente INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(20) UNIQUE NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    dni VARCHAR(15) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    especialidad VARCHAR(100)
) ENGINE=InnoDB;

-- 4. Tabla Curso
CREATE TABLE curso (
    id_curso INT AUTO_INCREMENT PRIMARY KEY,
    id_carrera INT NOT NULL,
    codigo VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    creditos INT NOT NULL,
    ciclo_nivel INT NOT NULL,
    CONSTRAINT fk_curso_carrera FOREIGN KEY (id_carrera) REFERENCES carrera(id_carrera)
) ENGINE=InnoDB;

-- 5. Tabla Periodo Académico
CREATE TABLE periodo_academico (
    id_periodo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL, 
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    activo BOOLEAN DEFAULT TRUE
) ENGINE=InnoDB;

-- 6. Tabla Seccion
CREATE TABLE seccion (
    id_seccion INT AUTO_INCREMENT PRIMARY KEY,
    id_curso INT NOT NULL,
    id_docente INT NULL,
    id_periodo INT NOT NULL,
    codigo_seccion VARCHAR(20) NOT NULL, 
    aula VARCHAR(50),
    cupo_maximo INT DEFAULT 40,
    CONSTRAINT fk_seccion_curso FOREIGN KEY (id_curso) REFERENCES curso(id_curso),
    CONSTRAINT fk_seccion_docente FOREIGN KEY (id_docente) REFERENCES docente(id_docente),
    CONSTRAINT fk_seccion_periodo FOREIGN KEY (id_periodo) REFERENCES periodo_academico(id_periodo)
) ENGINE=InnoDB;

-- 7. Tabla Horario
CREATE TABLE horario (
    id_horario INT AUTO_INCREMENT PRIMARY KEY,
    id_seccion INT NOT NULL,
    dia_semana VARCHAR(15) NOT NULL, 
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    aula VARCHAR(50),
    CONSTRAINT fk_horario_seccion FOREIGN KEY (id_seccion) REFERENCES seccion(id_seccion) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 8. Tabla Matricula
CREATE TABLE matricula (
    id_matricula INT AUTO_INCREMENT PRIMARY KEY,
    id_alumno INT NOT NULL,
    id_periodo INT NOT NULL,
    fecha_matricula DATETIME DEFAULT CURRENT_TIMESTAMP,
    monto_total DECIMAL(10, 2) NOT NULL,
    estado VARCHAR(20) DEFAULT 'REGISTRADA', 
    CONSTRAINT fk_matricula_alumno FOREIGN KEY (id_alumno) REFERENCES alumno(id_alumno),
    CONSTRAINT fk_matricula_periodo FOREIGN KEY (id_periodo) REFERENCES periodo_academico(id_periodo),
    UNIQUE KEY uk_alumno_periodo (id_alumno, id_periodo)
) ENGINE=InnoDB;

-- 9. Tabla Detalle Matricula
CREATE TABLE detalle_matricula (
    id_detalle_matricula INT AUTO_INCREMENT PRIMARY KEY,
    id_matricula INT NOT NULL,
    id_seccion INT NOT NULL,
    promedio_final DECIMAL(4, 2) NULL,
    estado_curso VARCHAR(20) DEFAULT 'CURSANDO', 
    CONSTRAINT fk_detalle_matricula FOREIGN KEY (id_matricula) REFERENCES matricula(id_matricula) ON DELETE CASCADE,
    CONSTRAINT fk_detalle_seccion FOREIGN KEY (id_seccion) REFERENCES seccion(id_seccion)
) ENGINE=InnoDB;

-- 10. Tabla Calificacion
CREATE TABLE calificacion (
    id_calificacion INT AUTO_INCREMENT PRIMARY KEY,
    id_detalle_matricula INT NOT NULL,
    nombre_evaluacion VARCHAR(50) NOT NULL, 
    ponderado DECIMAL(5, 2) NOT NULL, 
    nota DECIMAL(4, 2) NULL,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_calificacion_detalle FOREIGN KEY (id_detalle_matricula) REFERENCES detalle_matricula(id_detalle_matricula) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 11. Tabla Pension
CREATE TABLE pension (
    id_pension INT AUTO_INCREMENT PRIMARY KEY,
    id_alumno INT NOT NULL,
    id_matricula INT NOT NULL,
    numero_cuota INT NOT NULL, 
    monto DECIMAL(10, 2) NOT NULL,
    monto_mora DECIMAL(10, 2) DEFAULT 0.00,
    fecha_vencimiento DATE NOT NULL,
    fecha_pago DATETIME NULL,
    estado VARCHAR(20) DEFAULT 'PENDIENTE', 
    CONSTRAINT fk_pension_alumno FOREIGN KEY (id_alumno) REFERENCES alumno(id_alumno),
    CONSTRAINT fk_pension_matricula FOREIGN KEY (id_matricula) REFERENCES matricula(id_matricula)
) ENGINE=InnoDB;
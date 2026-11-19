# Sistema de Gestión Académica Universitaria

Sistema de gestión académica desarrollado para el contexto de una **universidad privada**, concebido como proyecto práctico para demostrar capacidades de programación, modelado relacional, uso de **procedimientos almacenados en MySQL**, aplicación de **patrones de diseño** e integración de **requerimientos funcionales complejos**.

---

## Objetivo del Proyecto

Centralizar y validar los procesos clave de la vida académica universitaria —como matrícula, gestión de cursos, docentes, horarios, evaluaciones y consulta de avance académico— asegurando integridad de datos, reglas de negocio consistentes y una arquitectura mantenible.

---

## Tecnologías y Herramientas

* **Lenguaje:** Java (JDK 17+ / versión utilizada)
* **Base de Datos:** MySQL (con **Procedimientos Almacenados**, vistas/funciones o restricciones según corresponda)
* **Acceso a Datos:** JDBC *(o el framework/librería que utilices)*
* **Arquitectura y Patrones de Diseño:** Arquitectura en capas + Patrones de Diseño *(ver sección dedicada)*
* **Control de Versiones:** Git / GitHub

---

## Patrones de Diseño Aplicados

Indica aquí los patrones concretos que implementaste en tu código y dónde se usan:

* **MVC (Model-View-Controller) / Arquitectura en Capas:** Separa la interfaz, la lógica de negocio/control y el acceso a datos.
* **DAO (Data Access Object):** Encapsula las llamadas JDBC y la ejecución de procedimientos almacenados en MySQL.
* **Singleton:** *(Ejemplo)* Gestiona una única instancia de conexión o configuración global si aplica en tu diseño.
* **Factory / Strategy:** *(Ejemplo)* Creación de objetos o variación de reglas (por ejemplo, cálculo de notas, estados de matrícula o validaciones).
* **Service / Facade:** *(Ejemplo)* Coordina operaciones complejas que involucran múltiples tablas o procedimientos almacenados.

> *Ajusta esta lista según los patrones reales que existan en tu repositorio para mantener la documentación fiel al código.*

---

## Base de Datos y Procedimientos Almacenados (MySQL)

La lógica crítica de persistencia y transacciones se apoya en **procedimientos almacenados** en MySQL para:

* Ejecutar operaciones compuestas de forma atómica y controlada.
* Reducir lógica repetitiva de consultas y actualizaciones desde la aplicación Java.
* Resguardar reglas de integridad y validación a nivel de base de datos.

### Estructura sugerida para documentar tus SPs

| Procedimiento Almacenado | Propósito principal | Requerimiento funcional asociado |
| :--- | :--- | :--- |
| `sp_registrar_matricula` | Registra la matrícula validando cupos, prerrequisitos o estado | Gestión de matrícula |
| `sp_registrar_calificacion` | Guarda o actualiza notas y recalcula promedios | Evaluación y registro académico |
| `sp_consultar_historial` | Obtiene el rendimiento y cursos por ciclo del estudiante | Consulta académica |

---

## Requerimientos Funcionales Complejos

Describe aquí los flujos más exigentes que resolvió tu sistema:

1. **Proceso de Matrícula:** Validación de disponibilidad, carga académica, cruce de horarios o estados del alumno y registro transaccional.
2. **Gestión Académica (Carreras, Ciclos, Cursos y Secciones):** Relación entre planes de estudio, asignaturas, docentes y grupos.
3. **Evaluaciones y Actas / Promedios:** Registro de calificaciones y cálculo consistente de resultados académicos.
4. **Reportes y Consultas Consolidadas:** Extracción de información cruzada para seguimiento estudiantil o administrativo.

---

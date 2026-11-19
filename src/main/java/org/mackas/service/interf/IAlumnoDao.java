package org.mackas.service.interf;

import java.sql.SQLException;
import java.util.List;
import org.mackas.model.Alumno;


public interface IAlumnoDao
        {
    List<Alumno> findByIdSeccion(int idSeccion);
    Alumno findByIdUser(int idUser) throws SQLException;
}

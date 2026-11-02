package org.mackas.service.interf;

import java.util.List;
import org.mackas.model.Alumno;


public interface IAlumnoDao
        {
    List<Alumno> findByIdSeccion(int idSeccion);
    Alumno findByIdUser(int idUser);
}

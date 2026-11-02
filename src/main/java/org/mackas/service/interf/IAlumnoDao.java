package org.mackas.service.interf;

import java.util.List;
import org.mackas.model.Alumno;
import org.mackas.util.CrudRepository;

public interface IAlumnoDao
        extends CrudRepository<Alumno,Integer> {
    List<Alumno> findByIdSeccion(int idSeccion);
    Alumno findByIdUser(int idUser);
}

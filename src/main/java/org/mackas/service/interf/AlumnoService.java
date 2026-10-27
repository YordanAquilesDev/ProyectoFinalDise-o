package org.mackas.service.interf;

import java.util.List;
import org.mackas.model.Alumno;
import org.mackas.util.CrudRepository;

public interface AlumnoService
        extends CrudRepository<Alumno,Integer> {
    List<Alumno> findByIdSeccion(int idSeccion);
}

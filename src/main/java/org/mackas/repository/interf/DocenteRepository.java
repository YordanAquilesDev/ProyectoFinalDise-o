package org.mackas.repository.interf;

import org.mackas.model.Docente;
import org.mackas.util.CrudRepository;

public interface DocenteRepository  extends CrudRepository<Docente,Integer> {
    Docente findById(String codigo);
}

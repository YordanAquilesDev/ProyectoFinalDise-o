package org.mackas.service.interf;

import org.mackas.model.Alumno;
import org.mackas.model.Docente;


public interface IDocenteDao
       
{
    Docente findByIdUser(int idUsuario);

}

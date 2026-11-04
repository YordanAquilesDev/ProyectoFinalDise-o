package org.mackas.service.factory;

import java.sql.Connection;

import org.mackas.repository.AlumnoRepositoryImpl;
import org.mackas.repository.UserRepositoryImpl;
import org.mackas.service.impl.UserServiceImpl;
import org.mackas.service.interf.IAlumnoDao;
import org.mackas.service.interf.IDocenteDao;
import org.mackas.util.singlenton.ConexionMySQL;

public class ServiceFactory {
    private IAlumnoDao alumnoService;
    private Connection mysql= ConexionMySQL.getInstance().getConexion();
    private IDocenteDao docenteService;
    
    public static UserServiceImpl UserServiceFactory(){
        return new UserServiceImpl( new UserRepositoryImpl(mysql,alumnoService,docenteService));

    }

    public static IAlumnoDao AlumnoServiceImpl(){
        return new AlumnoRepositoryImpl();
    }

    
}

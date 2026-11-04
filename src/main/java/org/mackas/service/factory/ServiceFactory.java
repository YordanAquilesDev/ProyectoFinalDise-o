package org.mackas.service.factory;

import java.sql.Connection;

import org.mackas.repository.*;
import org.mackas.service.impl.*;
import org.mackas.service.interf.*;
import org.mackas.util.singlenton.ConexionMySQL;

public class ServiceFactory {

    private static Connection mysql = ConexionMySQL.getInstance().getConexion();
    private static IDocenteDao docenteService;

    public static IUsuarioDao UserServiceFactory() {
        return new UserServiceImpl(new UserRepositoryImpl(mysql, AlumnoServiceFactory(), DocenteServiceFactory()));

    }

    public static IAlumnoDao AlumnoServiceFactory() {
        return new AlumnoServiceImpl(new AlumnoRepositoryImpl(mysql)); /// ;
    }

    public static ICalificacionDao CalificacionServiceFactory() {
        return new CalificacionServiceImpl(new CalificacionRepositoryImpl(mysql));
    }

    public static ICarreraDao CarreaServiceFactory() {
        return new CarreraServiceImpl(new CarreraRepositoryImpl(mysql));
    }

    public static IMatriculaDao MatriculaServiceFactory() {
        return new MatriculaServiceImpl(new MatriculaRepositoryImpl(mysql));
    }

    public static ISeccionDao SeccionServiceFactory() {
        return new SeccionServiceImpl(new SeccionRepositoryImpl(mysql));
    }

    public static IPensionDao PensionServiceFactory() {
        return new PensionServiceImpl(new PensionRepositoryImpl(mysql));
    }

    public static ICursoDao CursoServiceFactory() {
        return new CursoServiceImpl(new CursoRepositoryImpl(mysql));
    }


    public static IHorarioDao HorarioServiceFactory() {
        return new HorarioServiceImpl(new HorarioRepositoryImpl(mysql));
    }

    public static IPeriodoAcademicoDao PeriodoAcademicoServiceFactory() {
        return new PeriodoAcademicoServiceImpl(new PeriodoAcademicoRepositoryImpl(mysql));
    }

    public static IDocenteDao DocenteServiceFactory() {
  return new DocenteServiceImpl(new DocenteRepositoryImpl(mysql));
    }
}
package org.mackas;

import org.mackas.service.factory.ServiceFactory;
import org.mackas.service.impl.UserServiceImpl;
import org.mackas.Login;
import org.mackas.service.impl.MatriculaServiceImpl;
import org.mackas.service.interf.IMatriculaDao;
import org.mackas.service.interf.IUsuarioDao;

public class Main {
    public static void main(String[] args){
        // iniciar las configuraciones del principio ICP
        // inyectamos en servicio de Usuario y el de Matricula
        IUsuarioDao usuarioService= ServiceFactory.UserServiceFactory();
        IMatriculaDao matriculaService=ServiceFactory.MatriculaServiceFactory();
        Login login=new Login( usuarioService,matriculaService);
        login.setVisible(true);
    }
}

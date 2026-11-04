package org.mackas;

import org.mackas.service.impl.UserServiceImpl;
import org.mackas.Login;
import org.mackas.service.impl.MatriculaServiceImpl;

public class Main {
    public static void main(String[] args){
        // iniciar las configuraciones del principio ICP
        // inyectamos en servicio de Usuario y el de Matricula
        Login login=new Login( new UserServiceImpl(), new MatriculaServiceImpl());
        login.setVisible(true);
    }
}

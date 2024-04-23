package etc;

import DAO.PersonaDAO;
import Objects.Persona;

import java.sql.*;

public class SQLInsertionThread extends Thread{

    private PersonaDAO personaDAO = PersonaDAO.getInstance();
    private Persona persona;

    public SQLInsertionThread(Persona persona) {
        this.persona = persona;
    }




    @Override
    public void run() {
        super.run();

        MySQL mysql = MySQL.getInstance();

        mysql.conectar();

        personaDAO.insert(persona);



    }
}

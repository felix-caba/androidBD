package DAO;

import Objects.Persona;
import etc.MySQL;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class PersonaDAO implements DAO {

    private static final String sqlINSERT="INSERT INTO persona (persona) VALUES (? , ? , ? , ? , ?)";

    // Singleton
    private static PersonaDAO instance = null;

    Connection connection = null;


    private PersonaDAO() {

    }

    public static PersonaDAO getInstance() {

        if (instance == null) {

            instance = new PersonaDAO();

        }

        return instance;

    }




    @Override
    public void insert(Persona persona) {

        // Insertar persona en la base de datos

        String nombre = persona.getNombre();

        String fechaNacimiento = persona.getFechaNacimiento();

        String domicilio = persona.getDomicilio();

        String movil = persona.getMovil();

        String email = persona.getEmail();

        String sql;

        MySQL.conectar(MySQL.USER, MySQL.PASS, "vmapp");

        try {

            PreparedStatement pstmt = MySQL.getConex().prepareStatement(sqlINSERT);


        } catch (Exception e) {

            e.printStackTrace();

        }



        MySQL.cierra_conexion();


    }

    @Override
    public void update(Persona persona) {




    }

    @Override
    public void delete(Persona persona) {





    }

}

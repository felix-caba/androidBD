package DAO;

import Objects.Persona;
import android.os.StrictMode;
import etc.Genero;
import etc.MySQL;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class PersonaDAO implements DAO {




//private static final String sqlINSERT="INSERT INTO persona VALUES (, ? , ? , ? , ? , ?, ?)";

    private static final String sqlINSERT = "insert into persona (idPersona, nombre, domicilio, movil, "
            + "email, fechaNacimiento, genero) values (?,?,?,?,?,?,?)";


    // Singleton
    private static PersonaDAO instance = null;



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

        Genero genero = persona.getGenero();



        MySQL mysql = MySQL.getInstance();



        try {


            System.out.println("Pre conexion");


            // wait until connection is made

            System.out.println("LA CONEXION ES " + mysql.getConex());


            PreparedStatement pstmt = mysql.getConex().prepareStatement(sqlINSERT);

            pstmt.setInt(1, 5);
            pstmt.setString(2, nombre);
            pstmt.setString(3, domicilio);
            pstmt.setString(4, movil);
            pstmt.setString(5, email);
            pstmt.setString(6, fechaNacimiento);
            pstmt.setString(7 , genero.toString());

            int resultado = pstmt.executeUpdate();

            if (resultado > 0) {
                System.out.println("INSERTAO");
            } else {
                System.out.println("NO INSERTAO");
            }


        } catch (Exception e) {

            System.out.println("Error en la inserción de datos");

            e.printStackTrace();

        }




    }

    @Override
    public void update(Persona persona) {




    }

    @Override
    public void delete(Persona persona) {





    }

}

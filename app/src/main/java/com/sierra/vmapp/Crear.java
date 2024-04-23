package com.sierra.vmapp;

import DAO.PersonaDAO;
import Objects.Persona;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import etc.Genero;
import etc.MySQL;
import etc.SQLInsertionThread;

import java.sql.SQLOutput;

public class Crear extends AppCompatActivity implements View.OnClickListener{

    private Button buttonCrear;
    private EditText editTextNombre;
    private EditText editTextFechaNacimiento;
    private EditText editTextDomicilio;
    private EditText editTextMovil;
    private EditText editTextEmail;
    private Spinner spinnerCrear;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);






        System.out.println("Thread id: " + Thread.currentThread().getId());
        System.out.println("Thread name: " + Thread.currentThread().getName());


        editTextNombre = findViewById(R.id.editTextPersona);
        editTextFechaNacimiento = findViewById(R.id.editTextDate);
        editTextDomicilio = findViewById(R.id.editTextDomicilio);
        editTextMovil = findViewById(R.id.editTextMovil);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);

        spinnerCrear = findViewById(R.id.spinner_crear);

        buttonCrear = findViewById(R.id.button_crear_persona);
        buttonCrear.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.button_crear_persona) {


            String nombreStr = editTextNombre.getText().toString();
            String fechaNacimientoStr = editTextFechaNacimiento.getText().toString();
            String domicilioStr = editTextDomicilio.getText().toString();
            String movilStr = editTextMovil.getText().toString();
            String emailStr = editTextEmail.getText().toString();
            Genero genero = spinnerCrear.getSelectedItem().toString().equals("Hombre") ? Genero.HOMBRE : Genero.MUJER;



            System.out.println("DEBUG" + nombreStr + " " + fechaNacimientoStr + " " + domicilioStr + " " + movilStr + " " + emailStr + " " + genero);

            Persona RetrievedFields = new Persona(nombreStr, fechaNacimientoStr, domicilioStr, movilStr, emailStr, genero);

            SQLInsertionThread sqlInsertionThread = new SQLInsertionThread(RetrievedFields);
            sqlInsertionThread.start();






        }
    }

}
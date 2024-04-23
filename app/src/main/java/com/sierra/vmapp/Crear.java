package com.sierra.vmapp;

import DAO.PersonaDAO;
import Objects.Persona;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Crear extends AppCompatActivity implements View.OnClickListener{

    EditText editTextNombre = (EditText)findViewById(R.id.editTextPersona);
    EditText editTextFechaNacimiento = (EditText)findViewById(R.id.editTextDate);
    EditText editTextDomicilio = (EditText)findViewById(R.id.editTextDomicilio);
    EditText editTextMovil = (EditText)findViewById(R.id.editTextMovil);
    EditText editTextEmail = (EditText)findViewById(R.id.editTextTextEmailAddress);

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);






    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.button_crear_persona) {


            String nombreStr = editTextNombre.getText().toString();
            String fechaNacimientoStr = editTextFechaNacimiento.getText().toString();
            String domicilioStr = editTextDomicilio.getText().toString();
            String movilStr = editTextMovil.getText().toString();
            String emailStr = editTextEmail.getText().toString();

            PersonaDAO personaDAO = PersonaDAO.getInstance();

            personaDAO.insert(new Persona(nombreStr, fechaNacimientoStr, domicilioStr, movilStr, emailStr));




        }
    }

}
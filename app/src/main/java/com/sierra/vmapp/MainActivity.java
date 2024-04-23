package com.sierra.vmapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonCrear;
    private Button buttonModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonCrear = findViewById(R.id.button_crear);
        buttonCrear.setOnClickListener(this);

        buttonModificar = findViewById(R.id.button_modificar);
        buttonModificar.setOnClickListener(this);




    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.button_crear) {

            Intent intentCrear = new Intent(this, Crear.class);

            startActivity(intentCrear);
        } else if (id == R.id.button_modificar) {

            Intent intentModificar = new Intent(this, Modificar.class);
            startActivity(intentModificar);
        }
    }


}
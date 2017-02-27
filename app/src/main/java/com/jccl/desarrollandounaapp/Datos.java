package com.jccl.desarrollandounaapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Datos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String fecha = getResources().getString(R.string.FechaNac) + " " + parametros.getString(getResources().getString(R.string.pfecha));
        String telefono = getResources().getString(R.string.Telefono) + " " + parametros.getString(getResources().getString(R.string.ptelefono));
        String email = getResources().getString(R.string.Email) + " " + parametros.getString(getResources().getString(R.string.pemail));
        String descripcion = getResources().getString(R.string.Descripcion) + " " + parametros.getString(getResources().getString(R.string.pdescripcion));

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvFecha = (TextView) findViewById(R.id.tvFecha);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        Button button= (Button) findViewById(R.id.btnEditarDatos);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Datos.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}

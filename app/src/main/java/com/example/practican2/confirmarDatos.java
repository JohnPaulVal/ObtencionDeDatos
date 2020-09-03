package com.example.practican2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmarDatos extends AppCompatActivity {

    TextView tvNombre;
    TextView tvFecha;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDesc;
    Button editar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos2);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("Nombre");
        String fecha = parametros.getString("Fecha");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String desc = parametros.getString("Descripcion");


        tvNombre = (TextView) findViewById(R.id.txtVerNombre);
        tvFecha = (TextView) findViewById(R.id.txtVerFecha);
        tvTelefono = (TextView) findViewById(R.id.txtVerTel);
        tvEmail = (TextView) findViewById(R.id.txtVerEmail);
        tvDesc = (TextView) findViewById(R.id.txtVerDesc);
        editar=(Button)findViewById(R.id.btnEditar);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDesc.setText(desc);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });



    }
}

package com.example.practican2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //////fecha
    EditText etBirthday;
    Calendar myCalendar = Calendar.getInstance();

    //////fecha

    ///datos usuario
    EditText nombre;
    EditText telefono;
    EditText email;
    EditText desc;
    Button siguente;

    ArrayList<Datos> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos =new ArrayList<Datos>();

        nombre=(EditText)findViewById(R.id.txtNombre);
        telefono=(EditText)findViewById(R.id.txtTelefono);
        email=(EditText)findViewById(R.id.txtEmail);
        desc=(EditText)findViewById(R.id.txtDesc);
        etBirthday = findViewById(R.id.etFecha);
        etBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        datos.add(new Datos(nombre+"",etBirthday+"",telefono+"",email+"",desc+""));



        siguente=findViewById(R.id.btnSiguiente);
        siguente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,confirmarDatos.class);

                String sNombre=nombre.getText().toString();
                String sFecha=etBirthday.getText().toString();
                String sTelefono=telefono.getText().toString();
                String sEmail=email.getText().toString();
                String sDescripcion=desc.getText().toString();

                intent.putExtra("Nombre",sNombre);
                intent.putExtra("Fecha",sFecha);
                intent.putExtra("Telefono",sTelefono);
                intent.putExtra("Email",sEmail);
                intent.putExtra("Descripcion",sDescripcion);
                //intent.
                startActivity(intent);
                //finish();
            }
        });



    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }

    };

    private void actualizarInput() {
        String formatoDeFecha = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.ROOT);

        etBirthday.setText(sdf.format(myCalendar.getTime()));
    }



}

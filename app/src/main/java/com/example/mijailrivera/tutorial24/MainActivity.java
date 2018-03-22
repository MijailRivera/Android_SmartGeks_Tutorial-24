package com.example.mijailrivera.tutorial24;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etId, etNombres, etTelefono;
    Button btnGuardar, btnBuscar, btnActualizar, btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);

        final AyudaBD ayudaBD = new AyudaBD(getApplicationContext());

        final Context context = this;

        btnGuardar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Log.d("STATE", "cLICK GUARDAR");
                etId = (EditText) findViewById(R.id.etId);
                etNombres = (EditText) findViewById(R.id.etNombres);
                etTelefono = (EditText) findViewById(R.id.etTelefono);

                SQLiteDatabase db = ayudaBD.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(AyudaBD.DatosTabla.COLUMNA_ID, etId.getText().toString());
                valores.put(AyudaBD.DatosTabla.COLUMNA_NOMBRES, etNombres.getText().toString());
                valores.put(AyudaBD.DatosTabla.COLUMNA_TELEFONO, etTelefono.getText().toString());

                Long IdGuardado = db.insert(AyudaBD.DatosTabla.NOMBRE_TABLA, AyudaBD.DatosTabla.COLUMNA_ID, valores);

                Toast.makeText(getApplicationContext(), "id Guardado " + IdGuardado, Toast.LENGTH_LONG).show();
                etNombres.setText(""+IdGuardado);



            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
    }
}

package com.example.a03_enviarydevolverinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a03_enviarydevolverinfo.modelos.Persona;

public class MainActivity4 extends AppCompatActivity {

    private EditText txtnombre;
    private EditText txtedad;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txtedad = findViewById(R.id.txtEdadMain4);
        txtnombre = findViewById(R.id.txtNombreMain4);
        btnCancelar = findViewById(R.id.btnCancelarMain4);
        btnCrear = findViewById(R.id.btnCrearMain4);


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtnombre.getText().toString();
                String edad = txtedad.getText().toString();

                if(!nombre.isEmpty() && edad.isEmpty()){
                    Persona p = new Persona(nombre, Integer.parseInt(edad));
                    Bundle bundle = new Bundle();
                    bundle.
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}
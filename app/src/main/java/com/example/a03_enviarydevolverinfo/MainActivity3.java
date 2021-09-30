package com.example.a03_enviarydevolverinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    private Button btnguardar;
    private Button btncancelar;
    private EditText txtfrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtfrase = findViewById(R.id.txtfraseactivity3);
        btncancelar = findViewById(R.id.btncancelaractivity3);
        btnguardar = findViewById(R.id.btnguardaractivity3);


        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtfrase.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity3.this, "Introduce texto", Toast.LENGTH_SHORT).show();
                }else{
                    Bundle bundle = new Bundle();
                    bundle.putString("FRASE", txtfrase.getText().toString());
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });








    }
}
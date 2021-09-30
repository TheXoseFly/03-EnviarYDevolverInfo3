package com.example.a03_enviarydevolverinfo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int ACTIVITY3 = 44;
    //1. Atributos para las vistas
    private Button btnActivity2;
    private Button btnActivity3;
    private Button btnActivity3New;

    private ActivityResultLauncher<Intent> ventana4Launcher;

    private int numero = 100;
    private ArrayList<String> frasesMotivadoras; //Inicializar cuando lo necesites


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActivity2 = findViewById(R.id.btnActivity2Main);
        btnActivity3 = findViewById(R.id.btnactivity3Main);
        btnActivity3New = findViewById(R.id.btnActivity3NewMain);

        frasesMotivadoras = new ArrayList<>();


        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivityForResult(intent, ACTIVITY3);
            }
        });


        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity2 = new Intent(MainActivity.this, MainActivity2.class);
                activity2.putExtra("TEXTO", "Esto es un texto de PUTEXTRA");
                Bundle mochila = new Bundle();
                mochila.putString("CADENA", "Esto es un String");
                mochila.putFloat("FLOAT", 12.3f);
                activity2.putExtras(mochila);

                startActivity(activity2);
            }
        });

        ventana4Launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    String frase = result.getData().getExtras().getString("FRASE");
                    frasesMotivadoras.add(frase);
                    Toast.makeText(MainActivity.this, "Cantidad de frases: " + frasesMotivadoras.size(), Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnActivity3New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ventana4Launcher.launch(new Intent(MainActivity.this, MainActivity3.class));
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY3) {
            if (resultCode == RESULT_OK) {
                if (data != null && data.getExtras() != null) {
                    String frase = data.getExtras().getString("FRASE");
                    frasesMotivadoras.add(frase);
                    Toast.makeText(MainActivity.this, "Cantidad de frases: " + frasesMotivadoras.size(), Toast.LENGTH_SHORT).show();
                }

            }
        }
    }
}

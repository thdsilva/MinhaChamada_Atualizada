package com.example.minhachamada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;



public class MainActivity extends AppCompatActivity {
    ListView lvAlunos;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lvAlunos = findViewById(R.id.lvAlunos);
        this.btnCadastrar = findViewById(R.id.btnCadastrar);

        String[] nomes = new String[]{
                "Pedro",
                "Cremona",
                "Timap",
                "Goham",
                "Takashiro",
                "Takasho",
                "Sasuke",
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        nomes);
        this.lvAlunos.setAdapter(adapter);
    }

    public void abrir(View view){
        Intent it = new Intent(this, AddActivity.class);
        startActivity(it);
    }
}

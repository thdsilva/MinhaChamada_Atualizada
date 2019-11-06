package com.example.minhachamada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lvAlunos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lvAlunos = findViewById(R.id.lvAlunos);
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
}

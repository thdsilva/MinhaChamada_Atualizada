package com.example.minhachamada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddActivity extends AppCompatActivity {

    ImageButton imgContato;
    EditText ediName;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        this.imgContato = findViewById(R.id.imgContato);
        this.ediName = findViewById(R.id.ediName);
        this.btnCadastrar = findViewById(R.id.btnCadastrar);


    }
}

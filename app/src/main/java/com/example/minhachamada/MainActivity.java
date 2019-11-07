package com.example.minhachamada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.minhachamada.adpters.AlunoAdapter;
import com.example.minhachamada.controllers.AlunoBancoController;
import com.example.minhachamada.entities.Aluno;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView lvAlunos;
    Button btnCadastrar;
    ArrayList<Aluno> listaDeAlunos;

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
    public void atualizarLista(){
        AlunoAdapter adapter = new AlunoAdapter(this, listaDeAlunos);
        lvAlunos.setAdapter(adapter);
        Cursor cursor = new AlunoBancoController(this).getAll();
        listaDeAlunos.clear();
        while (cursor.moveToNext()){
            Aluno aluno = new Aluno(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("foto")));
            listaDeAlunos.add(aluno);
        }
        lvAlunos.deferNotifyDataSetChanged();
    }
}


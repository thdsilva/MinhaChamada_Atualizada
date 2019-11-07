package com.example.minhachamada;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
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

    public final static int PEDIDO_CAPTURAR_IMAGEM=1;
    public void tirarFoto(View view){

        Intent takePictureIntent =
                new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager())
            != null){
            startActivityForResult(takePictureIntent,PEDIDO_CAPTURAR_IMAGEM);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgContato.setImageBitmap(imageBitmap);
        }
    }
}

package com.example.minhachamada.adpters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import com.example.minhachamada.R;
import com.example.minhachamada.entities.Aluno;

public class AlunoAdapter extends BaseAdapter {
    ArrayList<Aluno> alunos;
    LayoutInflater myInflater;
    public AlunoAdapter(Context context, ArrayList<Aluno> alunos) {
        this.alunos = alunos;
        myInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return this.alunos.size();
    }
    @Override
    public Aluno getItem(int position) {
        return this.alunos.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno aluno = this.alunos.get(position);
        convertView = myInflater.inflate(R.layout.aluno_item, null);
        ((TextView) convertView.findViewById(R.id.nomealuno)).setText(aluno.getNome());
        File imgFile = new File(aluno.getFoto());
        if (imgFile.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ((ImageView) convertView.findViewById(R.id.fotoaluno)).setImageBitmap(bitmap);
        }
        return convertView;
    }
}

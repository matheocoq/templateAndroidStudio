package com.example.applicationserie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ajoutSerie extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_serie);

    }

    public void ajoutClick(View view) {
        EditText Titre=findViewById(R.id.txtTitre);
        EditText PremireDiffusion=findViewById(R.id.txtPMD);
        EditText Duree=findViewById(R.id.txtDuree);
        EditText Description=findViewById(R.id.txtDescription);
        EditText Image=findViewById(R.id.txtImage);
        String T = Titre.getText().toString();
        String Pe = PremireDiffusion.getText().toString();
        String Du = Duree.getText().toString();
        String D = Description.getText().toString();
        String Po = Image.getText().toString();
        Serie serie= new Serie(0,T,Pe,Du,D,Po);
        SerieSqlHelper listeSerieSql=new SerieSqlHelper(ajoutSerie.this);
        listeSerieSql.addSerie(serie);
        startActivity(new Intent(ajoutSerie.this,MainActivity.class));
    }
}
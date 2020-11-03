package com.example.applicationserie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailSerie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_serie);
        Intent intent =getIntent();
        long position = intent.getLongExtra("pos",0);

        //JSONHelper jsonSerie = new JSONHelper(DetailSerie.this);
        //Serie laSerie = jsonSerie.getSerie(position);

        SerieSqlHelper dbHelper = new SerieSqlHelper(DetailSerie.this);
        Serie laSerie = dbHelper.getSerie(position);

        TextView titre = findViewById(R.id.titre);
        titre.setText(laSerie.getTitre());
        TextView resume = findViewById(R.id.resume);
        resume.setText(laSerie.getResume());
        resume.setMovementMethod(new ScrollingMovementMethod());

        TextView diffduree = findViewById(R.id.diffduree);
        diffduree.setText("1ere diffusion : "+laSerie.getPremiereDiffusion()+" duree : "+laSerie.getDuree());

        ImageView image = findViewById(R.id.imageView);
        Picasso.get().load(laSerie.getImage()).into(image);
    }

    public void SuppClick(View view) {
        Intent intent =getIntent();
        long position = intent.getLongExtra("pos",0);
        SerieSqlHelper dbHelper = new SerieSqlHelper(DetailSerie.this);
        Serie laSerie = dbHelper.getSerie(position);



    }
}
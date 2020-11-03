package com.example.applicationserie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AffListeSerie extends AppCompatActivity {

    ArrayList<Serie> lesSeries =new ArrayList<Serie>();
    ListView listView;
    SerieAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_liste_serie);

       //JSONHelper listSerieJSON =new JSONHelper(AffListeSerie.this);
        //lesSeries=listSerieJSON.getLesSeries();

        SerieSqlHelper listeSerieSql=new SerieSqlHelper(AffListeSerie.this);
        lesSeries=listeSerieSql.getLesSeries();

        listView=findViewById(R.id.lsdView);
        mAdapter =new SerieAdapter(AffListeSerie.this,lesSeries);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView.getItemAtPosition(position);
                Serie serie=(Serie)listItem;

                Intent detailSerieActivity = new Intent(AffListeSerie.this, DetailSerie.class);
                detailSerieActivity.putExtra("pos", serie.getId());
                startActivity(detailSerieActivity);

            }
        });

    }
}
package com.example.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {

    private RecyclerView listaMascotasFav;
    ArrayList<Mascotas> mascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mascotasFav = new ArrayList<Mascotas>();

        Bundle parametros = getIntent().getExtras();

        String mascota;
        String[] values;

        for (int i = 1; 1 <= 5; i++){
            mascota = parametros.getString(String.valueOf(i));
            values = mascota.split(";");
            mascotasFav.add(new Mascotas(values[0], Integer.valueOf(values[1]), Integer.valueOf(values[3])));
        }

        listaMascotasFav = findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llmFav = new LinearLayoutManager(this);
        llmFav.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFav.setLayoutManager(llmFav);
        inicilizarAdapterFav();
    }

    public void inicilizarAdapterFav() {
        MascotaAdapter adapter = new MascotaAdapter(mascotasFav, this);
        listaMascotasFav.setAdapter(adapter);
    }
}

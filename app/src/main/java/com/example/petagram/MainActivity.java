package com.example.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<Mascotas> mascotas;
    private ImageButton estrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaMascotas.setLayoutManager(llm);
        incializarListaMascotas();
        inicilizarAdapter();

        estrella = findViewById(R.id.ivEstrella);

        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguiente();
            }
        });

    }

    public void incializarListaMascotas(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("Catty", 0, R.drawable.catty));
        mascotas.add(new Mascotas("Ronny", 0, R.drawable.ronny));
        mascotas.add(new Mascotas("Mike", 0, R.drawable.mike));
        mascotas.add(new Mascotas("Jhon", 0, R.drawable.jhon));
        mascotas.add(new Mascotas("scientist", 0, R.drawable.scientist));
        mascotas.add(new Mascotas("Blanqui", 0, R.drawable.blanqui));
        mascotas.add(new Mascotas("Cazador", 0, R.drawable.cazador));
        mascotas.add(new Mascotas("Negri", 0, R.drawable.negri));
        mascotas.add(new Mascotas("Chichi", 0, R.drawable.chichi));
        mascotas.add(new Mascotas("Rey", 0, R.drawable.rey));
    }

    public void inicilizarAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(mascotas, this);
        listaMascotas.setAdapter(adapter);
    }

    public void siguiente(){
        Intent intent = new Intent(this, Favoritas.class);
        startActivity(intent);
    }
}


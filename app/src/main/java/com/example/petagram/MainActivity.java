package com.example.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<Mascotas> mascotas;

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
    }

    public void incializarListaMascotas(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("Catty", 0, R.drawable.catty));
        mascotas.add(new Mascotas("Ronny", 0, R.drawable.ronny));
        mascotas.add(new Mascotas("Mike", 0, R.drawable.mike));
        mascotas.add(new Mascotas("Jhon", 0, R.drawable.jhon));
    }

    public void inicilizarAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(mascotas, this);
        listaMascotas.setAdapter(adapter);
    }
}


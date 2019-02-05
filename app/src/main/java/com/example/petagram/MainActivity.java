package com.example.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
        ArrayList<Mascotas> favoritas = new ArrayList<Mascotas>();

        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        for(int i = 0; i < mascotas.size(); i++){
            if (mascotas.get(i).getRating() != 0) {
                favoritas.add(mascotas.get(i));
                posiciones.add(i);
                if (favoritas.size() == 5)
                    break;
            }
        }

        if (favoritas.size() < 5){
            for(int i = 0; i < mascotas.size(); i++){
                if (posiciones.contains(i)){
                    continue;
                }
                favoritas.add(mascotas.get(i));
                posiciones.add(i);
                if (favoritas.size() == 5)
                    break;
            }
        }

        Intent intent = new Intent(MainActivity.this, Favoritas.class);
        intent.putExtra("0", favoritas.get(0).getNombre() + ";" + String.valueOf(favoritas.get(0).getRating())
                + ";" + String.valueOf(favoritas.get(0).getFoto()));
        intent.putExtra("1", favoritas.get(1).getNombre() + ";" + String.valueOf(favoritas.get(1).getRating())
                + ";" + String.valueOf(favoritas.get(1).getFoto()));
        intent.putExtra("2", favoritas.get(2).getNombre() + ";" + String.valueOf(favoritas.get(2).getRating())
                + ";" + String.valueOf(favoritas.get(2).getFoto()));
        intent.putExtra("3", favoritas.get(3).getNombre() + ";" + String.valueOf(favoritas.get(3).getRating())
                + ";" + String.valueOf(favoritas.get(3).getFoto()));
        intent.putExtra("4", favoritas.get(4).getNombre() + ";" + String.valueOf(favoritas.get(4).getRating())
                + ";" + String.valueOf(favoritas.get(4).getFoto()));
        startActivity(intent);
    }

    /*public static void quicksort(int A[], int izq, int der) {

        int pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq; // i realiza la búsqueda de izquierda a derecha
        int j=der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i<j){            // mientras no se crucen las búsquedas
            while(A[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
            while(A[j]>pivote) j--;         // busca elemento menor que pivote
            if (i<j) {                      // si no se han cruzado
                aux= A[i];                  // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }
        A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
        if(izq<j-1)
            quicksort(A,izq,j-1); // ordenamos subarray izquierdo
        if(j+1 <der)
            quicksort(A,j+1,der); // ordenamos subarray derecho
    }*/
}


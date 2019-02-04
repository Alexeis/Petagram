package com.example.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    // Inflar el layout y lo pasará al viewholder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    // Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder MascotaViewHolder, final int position) {
        final Mascotas mascota = mascotas.get(position);
        MascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        MascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        MascotaViewHolder.tvNumeroCV.setText(String.valueOf(mascota.getRating()));

        MascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        MascotaViewHolder.btnHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascota.setRating(Integer.valueOf((String) MascotaViewHolder.tvNumeroCV.getText()) + 1);
                MascotaViewHolder.tvNumeroCV.setText(String.valueOf(mascota.getRating()));
            }
        });
    }

    @Override
    public int getItemCount() { // Cantidad de elementos que tiene la lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvNumeroCV;
        private ImageButton btnHueso;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto      = itemView.findViewById(R.id.imgFoto);
            tvNombreCV   = itemView.findViewById(R.id.tvNombreCV);
            btnHueso     = itemView.findViewById(R.id.btnHueso);
            tvNumeroCV   = itemView.findViewById(R.id.tvNumeroCV);
        }
    }
}




























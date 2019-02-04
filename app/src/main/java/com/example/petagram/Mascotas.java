package com.example.petagram;

public class Mascotas {
    private String nombre;
    private int rating;
    private int foto;

    public Mascotas(String nombre, int rating, int foto) {
        this.nombre = nombre;
        this.rating = rating;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

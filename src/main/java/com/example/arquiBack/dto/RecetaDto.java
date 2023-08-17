package com.example.arquiBack.dto;

import com.example.arquiBack.entity.Receta;

public class RecetaDto {
    private int idReceta;
    private String titulo;
    private String ingrediente;

    public RecetaDto(){
    }

    public RecetaDto(int idReceta, String titulo, String ingrediente) {
        this.idReceta = idReceta;
        this.titulo = titulo;
        this.ingrediente = ingrediente;
    }

    public RecetaDto(Receta receta){
        this.idReceta = receta.getIdReceta();
        this.titulo = receta.getTitulo();
        this.ingrediente = receta.getIngredienteIdIngrediente().getNombre();
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public String toString() {
        return "RecetaDto{" +
                "idReceta=" + idReceta +
                ", titulo='" + titulo + '\'' +
                ", ingrediente='" + ingrediente + '\'' +
                '}';
    }
}

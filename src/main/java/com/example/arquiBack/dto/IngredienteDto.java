package com.example.arquiBack.dto;

import com.example.arquiBack.entity.Ingrediente;

public class IngredienteDto {
    private int idIngrediente;
    private String nombre;
    public IngredienteDto(){
    }
    public IngredienteDto(int idIngrediente, String nombre) {
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
    }
    public IngredienteDto(Ingrediente ingrediente){
        this.idIngrediente = ingrediente.getIdIngrediente();
        this.nombre = ingrediente.getNombre();
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "IngredienteDto{" +
                "idIngrediente=" + idIngrediente +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

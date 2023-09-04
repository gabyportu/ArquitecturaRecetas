package com.example.arquiBack.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ingrediente")
@NamedQueries({
        @NamedQuery(name = "ingrediente.findAll", query = "SELECT i from Ingrediente i"),
})
public class Ingrediente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingrediente")
    private Integer idIngrediente;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    public Ingrediente(){
    }
    public Ingrediente(Integer idIngrediente){
        this.idIngrediente = idIngrediente;
    }
    public Ingrediente(Integer idIngrediente, String nombre){
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
    }

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
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
        return "com.example.arquiBack.entity.Ingrediente[ idIngrediente" + idIngrediente + " ]";
    }
}

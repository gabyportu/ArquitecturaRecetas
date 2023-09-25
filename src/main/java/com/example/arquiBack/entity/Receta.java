package com.example.arquiBack.entity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "receta")
@NamedQueries({
        @NamedQuery(name = "Receta.findAll", query = "SELECT r FROM Receta r"),
})
public class Receta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_receta")
    private Integer idReceta;

    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;

    @JoinColumn(name = "ingrediente_id_ingrediente", referencedColumnName = "id_ingrediente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ingrediente ingredienteIdIngrediente;

    public Receta(){
    }
    public Receta(Integer idReceta){
        this.idReceta = idReceta;
    }

    public Receta(Integer idReceta, String titulo, Ingrediente ingredienteIdIngrediente) {
        this.idReceta = idReceta;
        this.titulo = titulo;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Ingrediente getIngredienteIdIngrediente() {
        return ingredienteIdIngrediente;
    }

    public void setIngredienteIdIngrediente() {
        this.ingredienteIdIngrediente = ingredienteIdIngrediente;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "idReceta=" + idReceta +
                ", titulo='" + titulo + '\'' +
                ", ingredienteIdIngrediente=" + ingredienteIdIngrediente +
                '}';
    }
}

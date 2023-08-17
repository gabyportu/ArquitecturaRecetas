package com.example.arquiBack.repository;

import com.example.arquiBack.entity.Ingrediente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer>{
    Ingrediente findById(int id);
}

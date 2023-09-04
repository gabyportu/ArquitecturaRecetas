package com.example.arquiBack.dao;

import com.example.arquiBack.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredienteDao {
    private IngredienteRepository ingredienteRepository;

    public IngredienteDao(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }
}

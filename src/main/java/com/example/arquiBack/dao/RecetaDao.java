package com.example.arquiBack.dao;

import com.example.arquiBack.repository.RecetaRepository;
import org.springframework.stereotype.Service;

@Service
public class RecetaDao {
    private RecetaRepository recetaRepository;

    public RecetaDao(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }
}

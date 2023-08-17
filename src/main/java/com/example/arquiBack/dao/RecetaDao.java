package com.example.arquiBack.dao;

import com.example.arquiBack.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecetaDao {
    @Autowired
    private RecetaRepository recetaRepository;
}

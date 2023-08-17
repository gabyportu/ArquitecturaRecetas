package com.example.arquiBack.repository;

import com.example.arquiBack.entity.Receta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
    @Override
    Page<Receta> findAll(Pageable pageable);
}

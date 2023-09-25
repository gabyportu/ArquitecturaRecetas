package com.example.arquiBack.bl;

import com.example.arquiBack.dao.*;
import com.example.arquiBack.dto.IngredienteDto;
import com.example.arquiBack.dto.RecetaDto;
import com.example.arquiBack.entity.Ingrediente;
import com.example.arquiBack.entity.Receta;
import com.example.arquiBack.repository.IngredienteRepository;
import com.example.arquiBack.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // Importar LoggerFactory
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecetaBl {
    private RecetaRepository recetaRepository;
    private IngredienteRepository ingredienteRepository;

    private final Logger logger = LoggerFactory.getLogger(RecetaBl.class); // Crear un logger

    public RecetaBl(RecetaRepository recetaRepository, IngredienteRepository ingredienteRepository) {
        this.recetaRepository = recetaRepository;
        this.ingredienteRepository = ingredienteRepository;
    }

    public RecetaDto guardarReceta(RecetaDto recetaDto) {
        List<IngredienteDto> receta = recetaDto.getMissedIngredients();
        Receta rece = new Receta();
        rece.setIdReceta(recetaDto.getId());
        rece.setTitulo(recetaDto.getTitle());
        List<Receta> listaReceta = new ArrayList<Receta>();
        listaReceta.add(rece);
        for (int i = 0; i < receta.size(); i++) {
            Ingrediente ingre = new Ingrediente();
            ingre.setNombre(receta.get(i).getName());
            //ingre.setRecetaList(listaReceta);
            ingre.setIdIngrediente(receta.get(i).getId());
            ingredienteRepository.save(ingre);
        }
        recetaRepository.save(rece);

        // Registrar un mensaje informativo
        logger.info("Receta guardada con éxito.");

        return recetaDto;
    }

    public RecetaDto addReceta(RecetaDto recetaDto) {
        Receta receta = new Receta();
        receta.setTitulo(recetaDto.getTitle());

        List<Ingrediente> ingredientes = new ArrayList<>();
        for (IngredienteDto ingredienteDto : recetaDto.getMissedIngredients()) {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setNombre(ingredienteDto.getName());
            ingredientes.add(ingrediente);
        }
        receta.setIngredienteIdIngrediente();
        recetaRepository.save(receta);

        // Registrar un mensaje informativo
        logger.info("Receta agregada con éxito.");

        return recetaDto;
    }

    public RecetaDto eliminarReceta(int idReceta){
        Optional<Receta> recetaOptional = recetaRepository.findById(idReceta);
        if(recetaOptional.isPresent()){
            Receta recetaEliminar = recetaOptional.get();
            recetaRepository.delete(recetaEliminar);
            RecetaDto recetaEliminada = new RecetaDto();
            recetaEliminada.setId(recetaEliminar.getIdReceta());
            recetaEliminada.setTitle(recetaEliminar.getTitulo());

            // Registrar un mensaje informativo
            logger.info("Receta eliminada con éxito.");

            return recetaEliminada;
        } else {
            // Registrar un mensaje de advertencia
            logger.warn("Intento de eliminar una receta inexistente.");
            return null;
        }
    }

    public Page<Receta> obtenerRecetasPaginadas(Pageable pageable) {
        return recetaRepository.findAll(pageable);
    }
}

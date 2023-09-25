package com.example.arquiBack.bl;

import com.example.arquiBack.dao.*;
import com.example.arquiBack.dto.IngredienteDto;
import com.example.arquiBack.dto.RecetaDto;
import com.example.arquiBack.repository.IngredienteRepository;
import com.example.arquiBack.repository.RecetaRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.arquiBack.entity.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetaBl {
    private RecetaRepository recetaRepository;
    private IngredienteRepository ingredienteRepository;

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
            return recetaEliminada;
        }else{
            return null;
        }
    }
}




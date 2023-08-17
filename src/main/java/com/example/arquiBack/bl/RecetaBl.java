package com.example.arquiBack.bl;

import com.example.arquiBack.dao.*;
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

@Service
public class RecetaBl {
    private static final Logger logger = LoggerFactory.getLogger(RecetaBl.class);

    @Autowired
    private RecetaRepository recetaRepository;

    @Value("${recetaApi.url}")
    private String apiUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private RecetaDao recetaDao;
    public Receta fetchAndSaveReceta(){
        logger.debug("Obteniendo receta desde URL: {}", apiUrl);
        ResponseEntity<Receta> responce = restTemplate.getForEntity(apiUrl, Receta.class);
        if(responce.getStatusCode() == HttpStatus.OK){
            Receta receta = responce.getBody();
            logger.debug("Recetas recibidas: {}", receta);

            recetaRepository.save(receta);
            logger.info("Receta guardada en la base de datos.");
            return receta;
        }else{
            logger.warn("Fallo para recuperar la receta desde la API. Respuesta: {}",responce.getStatusCodeValue());
            throw new RuntimeException("Error al consumir la API");
        }
    }
    public Page<Receta> findAllDogs(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return recetaRepository.findAll(pageable);
    }
}

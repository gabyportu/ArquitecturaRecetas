package com.example.arquiBack.api;

import com.example.arquiBack.bl.RecetaBl;
import com.example.arquiBack.dto.ResponseDto;
import com.example.arquiBack.entity.Receta;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

@RestController
@RequestMapping("/api/receta")
public class RecetaApi {
    private static final Logger logger = LoggerFactory.getLogger(RecetaApi.class);
    @Autowired
    private RecetaBl recetaBl;
    @GetMapping("/fetch")
    public ResponseEntity<ResponseDto<Receta>> fetchAndSaveReceta(){
        try {
            logger.info("Proceso de obtener la receta mediante un endpoint iniciando /fetch.");
            Receta receta = recetaBl.fetchAndSaveReceta();
            return new ResponseEntity<>(new ResponseDto<>(200, receta, "Receta Guardada"), HttpStatus.OK);
        }catch (RuntimeException e){
            logger.error("Error con el proceso /fetch: ", e.getMessage());
            return new ResponseEntity<>(new ResponseDto<>(500, null,"Error interno del servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

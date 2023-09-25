package com.example.arquiBack.bl;

import com.example.arquiBack.dto.RecetaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecetaFacade {
    private final RecetaBl recetaBl;

    @Autowired
    public RecetaFacade(RecetaBl recetaBl) {
        this.recetaBl = recetaBl;
    }

    public RecetaDto guardarReceta(RecetaDto recetaDto) {
        // Aquí puedes realizar cualquier lógica adicional o validaciones antes de llamar a RecetaBl
        try {
            return recetaBl.guardarReceta(recetaDto);
        } catch (Exception ex) {
            // Puedes manejar excepciones aquí si es necesario
            throw ex; // o devuelve un objeto de error personalizado
        }
    }

    public RecetaDto addReceta(RecetaDto recetaDto) {
        // Puedes realizar lógica adicional aquí antes de llamar a RecetaBl
        try {
            return recetaBl.addReceta(recetaDto);
        } catch (Exception ex) {
            // Puedes manejar excepciones aquí si es necesario
            throw ex; // o devuelve un objeto de error personalizado
        }
    }

    public RecetaDto eliminarReceta(int idReceta) {
        // Puedes realizar lógica adicional aquí antes de llamar a RecetaBl
        try {
            return recetaBl.eliminarReceta(idReceta);
        } catch (Exception ex) {
            // Puedes manejar excepciones aquí si es necesario
            throw ex; // o devuelve un objeto de error personalizado
        }
    }
}

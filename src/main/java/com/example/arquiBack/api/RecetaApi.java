package com.example.arquiBack.api;

import com.example.arquiBack.bl.RecetaBl;
import com.example.arquiBack.dto.RecetaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper; // Importa la clase ObjectMapper
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/api/v1/receta")
public class RecetaApi {
    private final RecetaBl receta;

    public RecetaApi(RecetaBl receta) {
        this.receta = receta;
    }

    @GetMapping("/getRecipes")
    public ResponseEntity<?> getRecipesByIngredients() {
        ResponseEntity<RecetaDto[]> responseEntity;
        try {
            String apiKey = "4af2d874ab8543c3a1c89f6da9f433a3"; // Reemplaza con tu clave de API
            String apiUrl = "https://api.spoonacular.com/recipes/findByIngredients?ingredients=apples,+flour,+sugar&number=2&apiKey=" + apiKey;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                connection.disconnect();

                // Convierte el JSON en un array de objetos RecetaDto utilizando Jackson
                ObjectMapper objectMapper = new ObjectMapper();
                RecetaDto[] recetas = objectMapper.readValue(response.toString(), RecetaDto[].class);
                RecetaDto recetaDto = receta.guardarReceta(recetas[0]);

                return ResponseEntity.ok(recetas);

            } else {
                // Manejo de errores aquí
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error al obtener datos de la API de Spoonacular. Código de respuesta: " + responseCode);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al realizar la solicitud a la API de Spoonacular.");
        }
    }
}
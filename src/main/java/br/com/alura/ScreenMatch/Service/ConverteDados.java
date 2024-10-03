package br.com.alura.ScreenMatch.Service;

import br.com.alura.ScreenMatch.Model.DadosSerie;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements ConverterDados {

    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

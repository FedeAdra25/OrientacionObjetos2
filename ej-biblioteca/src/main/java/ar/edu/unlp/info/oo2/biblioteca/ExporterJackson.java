package ar.edu.unlp.info.oo2.biblioteca;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class ExporterJackson extends VoorheesExporter{

    @Override
    public String exportar(List<Socio> socios) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(socios);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

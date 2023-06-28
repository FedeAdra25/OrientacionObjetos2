package ar.edu.unlp.info.oo2.biblioteca;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {
    private Biblioteca biblioteca = new Biblioteca();

    final String resultado = "[\r\n" +
            "\t{\r\n" +
            "\t\t\"nombre\": \"Arya Stark\",\r\n" +
            "\t\t\"email\": \"needle@stark.com\",\r\n" +
            "\t\t\"legajo\": \"5234-5\"\r\n" +
            "\t},\r\n" +
            "\t{\r\n" +
            "\t\t\"nombre\": \"Tyron Lannister\",\r\n" +
            "\t\t\"email\": \"tyron@thelannisters.com\",\r\n" +
            "\t\t\"legajo\": \"2345-2\"\r\n" +
            "\t}\r\n" +
            "]";

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
        biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com",  "2345-2"));
//        biblioteca.setExporter(new Exporter());
    }

    @Test
    void exportarSociosJSONSimple() throws ParseException {
        biblioteca.setExporter(new Exporter());
        JSONParser jsonParser = new JSONParser();
        assertEquals(jsonParser.parse(resultado),jsonParser.parse(biblioteca.exportarSocios()));
    }

    @Test
    void exportarSociosVoorheesExporter() {
        biblioteca.setExporter(new VoorheesExporter());
        assertEquals(resultado,biblioteca.exportarSocios());
    }
    @Test
    void exportarSociosJackson() throws ParseException {
        biblioteca.setExporter(new ExporterJackson());
        JSONParser jsonParser = new JSONParser();
        assertEquals(jsonParser.parse(resultado), jsonParser.parse(biblioteca.exportarSocios()));
    }
}

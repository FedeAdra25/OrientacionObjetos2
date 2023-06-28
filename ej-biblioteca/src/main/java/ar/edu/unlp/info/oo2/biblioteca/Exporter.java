package ar.edu.unlp.info.oo2.biblioteca;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.List;

public class Exporter extends VoorheesExporter{

    @Override
    public String exportar(List<Socio> socios) {
        JSONArray arraySocios = new JSONArray();
        for(Socio socio:socios){
            JSONObject socioJson = new JSONObject();
            socioJson.put("nombre",socio.getNombre());
            socioJson.put("email",socio.getEmail());
            socioJson.put("legajo",socio.getLegajo());
            arraySocios.add(socioJson);
        }
        return arraySocios.toJSONString();
    }
}

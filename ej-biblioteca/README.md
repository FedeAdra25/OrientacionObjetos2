# Ejercicio Biblioteca

```
1 Analice la implementación de la clase Biblioteca, Socio y VoorheesExporter que se provee con el material adicional de esta práctica (Archivo biblioteca.zip).
2 Documente la implementación mediante un diagrama de clases UML.
3 Programe los Test de Unidad para la implementación propuesta.
```

## UMLs
```
@startuml

class Biblioteca{
+agregarSocio(socio: Socio):void
+exportarSocios():String
}

class Socio{
- nombre: String
- legajo: String
- email: String
}

class VoorheesExporter{
- exportar(socio: Socio): String
+ exportar(socios: Socio[*]): String
}

class Exporter extends VoorheesExporter{
}
class ExporterJackson extends VoorheesExporter{
}

class JSONSimple{
}



Biblioteca -right-> VoorheesExporter: "exporter"
Biblioteca --> "socios *" Socio
Exporter -->"uses" JSONSimple
ExporterJackson -->"uses" ObjectMapper


@enduml
```
## Tests


## Resolución con adapter usando JSON.simple


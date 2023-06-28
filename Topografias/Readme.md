# Ejercicio Topografías

## Resumen

Se resuelve haciendo un composite. Tengo que poder comparar topografias (equals) y su composición en % de agua o tierra

## Nota

Debería tener un "TopografiaType" para evitar los ".isInstance()". De esta manera además podría mover a la clase abstracta la lógica del equals. En todas las subclases (excepto Mixta que necesita iterar)


## UML
```
@startuml

abstract class Topografia{
- porcentajeTierra:Integer
+ calcularProporcionTierra():float
+ calcularProporcionAgua():float
+ equals(topografia2:Topografia):boolean
  }

class Tierra extends Topografia{
+ calcularProporcionTierra():float
+ calcularProporcionAgua():float
+ equals(topografia2:Topografia):boolean
  }
  class Agua extends Topografia{
+ calcularProporcionTierra():float
+ calcularProporcionAgua():float
+ equals(topografia2:Topografia):boolean
  }

class Mixta extends Topografia{
+ calcularProporcionTierra():float
+ calcularProporcionAgua():float
+ equals(topografia2:Topografia):boolean
  }

Mixta "topografias[4]" -> Topografia

@enduml
```
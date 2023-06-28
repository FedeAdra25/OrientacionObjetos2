package topografias;
//Ejercicio B: Agregar pantano
public class Pantano extends Topografia{
    @Override
    public Float calcularPorcionTierra() {
        return 0.7f;
    }

    @Override
    public Float calcularPorcionAgua() {
        return 0.3f;
    }

    @Override
    public boolean equals(Topografia topografia) {
        return this.getClass().isInstance(topografia) && super.equals(topografia);
    }
}

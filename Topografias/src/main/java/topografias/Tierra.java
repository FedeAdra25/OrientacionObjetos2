package topografias;

public class Tierra extends Topografia {
    @Override
    public Float calcularPorcionTierra() {
        return 1.0f;
    }

    @Override
    public Float calcularPorcionAgua() {
        return 0.0f;
    }

    @Override
    public boolean equals(Topografia topografia) {
        return this.getClass().isInstance(topografia) && super.equals(topografia);
    }
}

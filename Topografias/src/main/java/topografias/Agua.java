package topografias;

public class Agua extends Topografia {
    @Override
    public Float calcularPorcionTierra() {
        return 0.0f;
    }

    @Override
    public Float calcularPorcionAgua() {
        return 1.0f;
    }

    @Override
    public boolean equals(Topografia topografia) {
        return this.getClass().isInstance(topografia) && super.equals(topografia);
    }
}

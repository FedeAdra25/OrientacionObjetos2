package topografias;

import java.util.Arrays;

public class Mixta extends Topografia {
    private Topografia[] topografias;

    public Mixta(Topografia[] topografias) {
        if(topografias.length!=4){
            throw new IllegalArgumentException("Cannot instantiate topografia with size != 4");
        }
        this.topografias = topografias;
    }

    public Topografia[] getTopografias() {
        return topografias;
    }

    @Override
    public Float calcularPorcionTierra() {
        return Arrays.stream(topografias).map(Topografia::calcularPorcionTierra)
                .reduce(Float::sum)
                .map(result -> result/4)
                .orElseThrow();
    }

    @Override
    public Float calcularPorcionAgua() {
        return 1-this.calcularPorcionTierra();
    }

    @Override
    public boolean equals(Topografia topografia) {
        if (!this.getClass().isInstance(topografia)){
            return false;
        }

        return Arrays.equals(topografias,((Mixta) topografia).getTopografias());
    }
}

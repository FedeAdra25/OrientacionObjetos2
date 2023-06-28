package topografias;

public abstract class Topografia {
    public abstract Float calcularPorcionTierra();
    public abstract Float calcularPorcionAgua();
    public boolean equals(Topografia topografia){
        return this.calcularPorcionAgua().equals(topografia.calcularPorcionAgua()) &&
                this.calcularPorcionTierra().equals(topografia.calcularPorcionTierra());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this){
            return true;
        }
        if(!this.getClass().isInstance(obj)){
            return false;
        }
        return this.equals((Topografia) obj);
    }
}

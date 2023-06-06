package classes.Grafos.utils;

public class CostoTodosMinimos extends Costo {
    private int numCaminosMinimos;

    public CostoTodosMinimos() {
        super();
        this.numCaminosMinimos = 0;
    }

    public int getNumCaminosMinimos() {
        return numCaminosMinimos;
    }

    public void setNumCaminosMinimos(int numCaminosMinimos) {
        this.numCaminosMinimos = numCaminosMinimos;
    }
}

package back;

public class Sendero implements Comparable<Sendero> {
    private Estacion origen;
    private Estacion destino;
    private int impacto = (int) (Math.random() * 10) + 1;

    public Sendero(Estacion origen, Estacion destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Estacion getOrigen() {
        return origen;
    }

    public Estacion getDestino() {
        return destino;
    }

    public int getImpactoAmbiental() {
        return impacto;
    }

    @Override
    public int compareTo(Sendero otro) {
        return Integer.compare(this.impacto, otro.impacto);
    }

    @Override
    public String toString() {
        return origen + " - " + destino + " (Impacto: " + impacto + ")";
    }
}


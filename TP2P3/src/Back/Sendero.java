package Back;

public class Sendero implements Comparable<Sendero> {
    private Estacion origen;
    private Estacion destino;
    private int impacto;

    public Sendero(Estacion origen, Estacion destino, int impacto) {
        this.origen = origen;
        this.destino = destino;
        this.impacto = impacto;
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


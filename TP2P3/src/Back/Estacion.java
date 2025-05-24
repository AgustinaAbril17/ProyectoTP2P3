package Back;

public class Estacion {
    private String nombre;
    private int x, y; // Coordenadas para el mapa (opcional, útil para visualización)
    public int indice;

    public Estacion(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return nombre;
    }
    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}

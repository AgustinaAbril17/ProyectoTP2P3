package back;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Estacion> estaciones;
    private List<Sendero> senderos;

    public Grafo() {
        estaciones = new ArrayList<>();
        senderos = new ArrayList<>();
    }

    public void agregarEstacion(Estacion estacion) {
        estaciones.add(estacion);
    }

    public void agregarSendero(Sendero sendero) {
        senderos.add(sendero);
    }

    public List<Estacion> getEstaciones() {
        return estaciones;
    }

    public List<Sendero> getSenderos() {
        return senderos;
    }
}

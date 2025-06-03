package back;

import java.util.*;

public class Kruskal {
    public List<Sendero> calcularAGM(List<Estacion> estaciones, List<Sendero> senderos) {
        Collections.sort(senderos);  // Ordenar los senderos por su impacto (peso)

        UnionFind unionFind = new UnionFind(estaciones.size());
        List<Sendero> resultado = new ArrayList<>();
        int impactoTotal = 0;  // Variable para acumular el impacto total

        for (Sendero sendero : senderos) {
            int origen = sendero.getOrigen().getIndice();
            int destino = sendero.getDestino().getIndice();

            // Verificar si los dos nodos no están en el mismo conjunto (sin ciclo)
            if (unionFind.find(origen) != unionFind.find(destino)) {
                unionFind.union(origen, destino);
                resultado.add(sendero);
                impactoTotal += sendero.getImpactoAmbiental();  // Sumar el impacto del sendero
            }
        }

        // Devolver el listado de senderos seleccionados para el AGM y el impacto total
        return resultado;
    }
}

// Clase para almacenar el resultado del AGM con el impacto total
/*
public class ResultAGM {
    private List<Sendero> senderos;
    private int impactoTotal;

    public ResultAGM(List<Sendero> senderos, int impactoTotal) {
        this.senderos = senderos;
        this.impactoTotal = impactoTotal;
    }

    public List<Sendero> getSenderos() {
        return senderos;
    }

    public int getImpactoTotal() {
        return impactoTotal;
    }
}
*/
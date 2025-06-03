package recursos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

//esto iria en la clase estacion
public class prueba {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = prueba.class.getResourceAsStream("coordenadas.txt");
        if (inputStream == null) throw new RuntimeException("Archivo no encontrado.");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                double x = Double.parseDouble(partes[0].trim());
                double y = Double.parseDouble(partes[1].trim());
                System.out.println("Coordenada: (" + x + ", " + y + ")");
            }
        }
        reader.close();
    }
}
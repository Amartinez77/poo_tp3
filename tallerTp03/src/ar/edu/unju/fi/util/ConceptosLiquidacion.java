package ar.edu.unju.fi.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que proporciona conceptos de liquidación para empleados, incluyendo
 * información sobre sueldos básicos, adicionales por antigüedad, adicionales por hijos,
 * y otros datos relacionados leídos desde archivos.
 */
public class ConceptosLiquidacion {

    // Sueldo básico para todos los empleados
    public static final double SUELDO_BASICO = 150000;

    // Adicional por antigüedad en años
    public static final double ADICIONAL_ANTIGUEDAD = 7000;

    // Adicional por cada hijo
    public static final double ADICIONAL_HIJO = 8000;

    // Ruta del archivo que contiene las categorías y sus valores
    private static final String RUTA_CATEGORIAS = "C:/Users/Ariel/Documents/categorias.txt";

    // Ruta del archivo que contiene el adicional fijo para los profesionales
    private static final String RUTA_ADICIONAL_PROFESIONAL = "C:/Users/Ariel/Documents/adicionalProfesional.txt";

    /**
     * Lee las categorías desde un archivo y las carga en un mapa.
     * 
     * @return Un mapa donde la clave es el número de categoría y el valor es el monto asociado.
     */
    public  static Map<Integer, Double> cargarCategorias() {
        Map<Integer, Double> categorias = new HashMap<>();
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_CATEGORIAS))) {
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] partes = linea.split(":");
                    int categoria = Integer.parseInt(partes[0].trim());
                    double valor = Double.parseDouble(partes[1].trim());
                    categorias.put(categoria, valor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return categorias;
    }

    /**
     * Obtiene el valor asociado a una categoría específica.
     * 
     * @param categoria El número de la categoría cuya valor se desea obtener.
     * @return El valor asociado a la categoría, o 0.0 si la categoría no existe.
     */
    public static double obtenerCategoria(int categoria) {
        Map<Integer, Double> categorias = cargarCategorias();
        return categorias.getOrDefault(categoria, 0.0);
    }

    /**
     * Lee el adicional fijo para los profesionales desde un archivo.
     * 
     * @return El valor del adicional para profesionales, o 0.0 si ocurre un error al leer el archivo.
     */
    public double obtenerAdicionalProfesional() {
        double adicional = 0.0;
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ADICIONAL_PROFESIONAL))) {
            String linea = br.readLine();
            if (linea != null) {
                adicional = Double.parseDouble(linea.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adicional;
    }
}
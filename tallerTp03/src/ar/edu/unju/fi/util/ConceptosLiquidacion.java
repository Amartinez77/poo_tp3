package ar.edu.unju.fi.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConceptosLiquidacion {

    public static final double SUELDO_BASICO = 150000;
    public static final double ADICIONAL_ANTIGUEDAD = 7000;
    public static final double ADICIONAL_HIJO = 8000;
    private static final String RUTA_CATEGORIAS = "C:/Users/Ariel/Documents/categorias.txt";
    private static final String RUTA_ADICIONAL_PROFESIONAL = "C:/Users/Ariel/Documents/adicionalProfesional.txt";

    // Método para leer las categorías desde un archivo
    public Map<Integer, Double> cargarCategorias() {
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
    
    // Método para obtener el valor de una categoría específica
    public double obtenerCategoria(int categoria) {
        Map<Integer, Double> categorias = cargarCategorias();
        return categorias.getOrDefault(categoria, 0.0);
    }

  

    // Método para leer el adicional fijo para los profesionales desde un archivo
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

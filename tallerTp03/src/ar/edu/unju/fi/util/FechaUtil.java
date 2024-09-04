package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Clase utilitaria para operaciones relacionadas con fechas.
 * 
 * Proporciona métodos para manejar fechas y cálculos relacionados con la edad.
 */
public class FechaUtil {

    /**
     * Calcula la edad en años a partir de una fecha de nacimiento.
     * 
     * @param fechaNacimientoStr La fecha de nacimiento en formato "dd-MM-yyyy".
     * @return La edad en años calculada desde la fecha de nacimiento hasta la fecha actual.
     */
    public int calcularEdad(String fechaNacimientoStr) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
                
        LocalDate ahora = LocalDate.now();
                
        return Period.between(fechaNacimiento, ahora).getYears();
    }

}
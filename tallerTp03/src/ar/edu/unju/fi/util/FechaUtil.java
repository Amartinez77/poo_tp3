package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class FechaUtil {
	
	public int calcularEdad(String fechaNacimientoStr) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
	    LocalDate ahora = LocalDate.now();
	    return Period.between(fechaNacimiento, ahora).getYears();
	}

}

package ar.edu.unju.fi.manager;

import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.dominio.Administrativo;
import ar.edu.unju.fi.dominio.Empleado;
import ar.edu.unju.fi.dominio.Profesional;
import ar.edu.unju.fi.util.ConceptosLiquidacion;
import ar.edu.unju.fi.util.FechaUtil;
import ar.edu.unju.fi.util.Totales;

import java.util.ArrayList;

public class EmpleadoManager {
	
    private List<Empleado> empleados = new ArrayList<>();

    
    
    /**
     * Agrega un empleado a la lista de empleados y calcula su sueldo.
     * 
     * @param empleado El empleado a agregar.
     */
    public void agregarEmpleado(Empleado empleado) {
        empleado.calcularSueldo();  // Calcula el sueldo al agregar
        empleados.add(empleado);
    }

    /**
     * Obtiene la lista de empleados.
     * 
     * @return La lista de empleados.
     */
    public List<Empleado> obtenerEmpleados() {
        return empleados;
    }

    /**
     * Muestra la información de todos los empleados en la lista.
     */
    public void mostrarEmpleados() {
        empleados.forEach(empleado -> {
            System.out.println("ID: " + empleado.getId());
            System.out.println("Legajo: " + empleado.getLegajo());
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Cantidad de hijos: " + empleado.getHijos());
            System.out.println("Fecha de Nacimiento: " + empleado.getFechaNacimiento());
            System.out.println("Antigüedad: " + empleado.getAntiguedad());
            System.out.println("Sueldo Neto: " + empleado.getSueldoNeto());
            System.out.println("-----------------------------------");
        });
    }
    
    /**
     * Precarga una lista de empleados administrativos y profesionales con datos predefinidos.
     * 
     * @return La lista de empleados precargados.
     */
    public List<Empleado> precargarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();

        // Crear empleados administrativos
        empleados.add(new Administrativo("A001", 123, "Juan Pérez", 2, "01-01-1980", 5, 3));
        empleados.add(new Administrativo("A002", 124, "Ana Gómez", 1, "15-05-1985", 3, 7));
        empleados.add(new Administrativo("A003", 125, "Ariel Martinez", 2, "10-03-2000", 3, 7));        
        empleados.add(new Administrativo("A004", 126, "Claudia Iriarte", 3, "01-01-1991", 12, 15));
        empleados.add(new Administrativo("A005", 127, "Ramiro Calizaya", 0, "15-07-1996", 9, 13));
        empleados.add(new Administrativo("A006", 128, "Claudio Martinich", 0, "10-03-2002", 1, 1));
        empleados.add(new Administrativo("A007", 129, "Laura Martinez", 0, "10-03-2003", 1, 1));        
        empleados.add(new Administrativo("A008", 130, "Carlos Gómez", 2, "15-05-1980", 15, 2));
        empleados.add(new Administrativo("A009", 131, "Ana Pérez", 1, "23-08-1985", 12, 3));
        empleados.add(new Administrativo("A010", 132, "Luis Rodríguez", 3, "30-11-1990", 10, 1));
        empleados.add(new Administrativo("A011", 133, "María Fernández", 0, "05-02-1995", 5, 4));
        empleados.add(new Administrativo("A012", 105, "Fernando Álvarez", 2, "12-01-1982", 20, 3));
        empleados.add(new Administrativo("A013", 106, "Claudia Silva", 1, "22-10-1989", 15, 2));
        empleados.add(new Administrativo("A014", 107, "Ricardo Díaz", 0, "17-03-1993", 10, 4));
        empleados.add(new Administrativo("A015", 108, "Verónica Castillo", 3, "05-06-1995", 8, 1));
        

        // Crear empleados profesionales
        empleados.add(new Profesional("P001", 125, "Luis Fernández", 0, "11-11-1978", 10));
        empleados.add(new Profesional("P002", 126, "María Rodríguez", 2, "23-09-1982", 8));
        empleados.add(new Profesional("P003", 127, "Lucas Martinez", 1, "22-07-1989", 1));
        empleados.add(new Profesional("P004", 201, "Marta Suárez", 1, "12-07-1978", 20));
        empleados.add(new Profesional("P005", 202, "Jorge López", 0, "18-09-1982", 18));
        empleados.add(new Profesional("P006", 203, "Sofía García", 2, "25-12-1987", 14));
        empleados.add(new Profesional("P007", 204, "Diego Torres", 0, "14-04-1992", 2));
        empleados.add(new Profesional("P008", 205, "Paula Moreno", 1, "30-07-1975", 25));
        empleados.add(new Profesional("P009", 206, "Gonzalo Núñez", 0, "19-02-1983", 1));
        empleados.add(new Profesional("P010", 207, "Lorena Vargas", 2, "04-09-1988", 2));
        empleados.add(new Profesional("P011", 208, "Adrián Soto", 1, "11-12-1991", 10));
        empleados.add(new Profesional("P012", 209, "Victoria Ríos", 0, "27-04-1994", 2));
        empleados.add(new Profesional("P013", 307, "Mauricio Villagra", 2, "04-09-1988", 2));
        empleados.add(new Profesional("P014", 308, "Soledad Fuentes", 2, "11-12-1991", 10));
        empleados.add(new Profesional("P015", 309, "Valeria Valente", 0, "27-04-1950", 2));
        

        return empleados;
    }
    
    /**
     * Inicializa la lista de empleados con datos precargados.
     */
    public void inicializarEmpleados() {
        List<Empleado> empleadosPrecargados = precargarEmpleados();
        empleadosPrecargados.forEach(this::agregarEmpleado);
    }
    
    /**
     * Muestra los empleados que tienen una antigüedad mayor a la ingresada por el usuario.
     * Calcula y muestra los totales acumulados de los sueldos netos y otros conceptos.
     * 
     * @param scanner El objeto Scanner para la entrada de datos del usuario.
     */
    public void mostrarEmpleadoPorAntiguedad(Scanner scanner) {
        int antiguedad;
        System.out.println("Ingrese antigüedad en años para listar empleados:");
        antiguedad = scanner.nextInt();
        
        Totales totales = new Totales();
        
        empleados.stream()
                .filter(empleado -> empleado.getAntiguedad() > antiguedad)
                .forEach(empleado -> {
                    double[] datos = empleado.calcularSueldo();
                    System.out.println(empleado);
                    totales.setRemunerativos(totales.getRemunerativos() + datos[0]);
                    totales.setSalarioFamiliar(totales.getSalarioFamiliar() + datos[1]);
                    totales.setDescuentos(totales.getDescuentos() + datos[2]);
                    totales.setSueldoNeto(totales.getSueldoNeto() + datos[3]);
                });
        
        System.out.println("Totales acumulados:");
        System.out.println(totales);
    }
    
    /**
     * Muestra los empleados cuya edad es mayor o igual a la ingresada por el usuario.
     * 
     * @param scanner El objeto Scanner para la entrada de datos del usuario.
     */
    public void mostrarPorEdad(Scanner scanner) {
        System.out.println("Ingrese una edad en años para mostrar empleados:");
        int edad = scanner.nextInt();
        
        FechaUtil fecha = new FechaUtil();
        
        empleados.stream()
                .filter(empleado -> fecha.calcularEdad(empleado.getFechaNacimiento()) >= edad)
                .forEach(empleado -> System.out.println(empleado));
    }
    
    /**
     * Calcula el importe neto acumulado de los empleados cuya edad es mayor o igual
     * a la ingresada por el usuario.
     * 
     * @param scanner El objeto Scanner para la entrada de datos del usuario.
     */
   /* public void calcularImporteNetoPorEdad(Scanner scanner) {
        System.out.println("Ingrese una edad mínima para calcular el importe neto acumulado:");
        int edadMinima = scanner.nextInt();

        FechaUtil fechaUtil = new FechaUtil();

        double totalImporteNeto = empleados.stream()
            .filter(empleado -> fechaUtil.calcularEdad(empleado.getFechaNacimiento()) >= edadMinima)
            .mapToDouble(Empleado::getSueldoNeto) // Acumular el sueldo neto
            .sum();

        System.out.println("El importe neto acumulado de los empleados con edad mayor o igual a " 
                           + edadMinima + " años es: " + totalImporteNeto);
    }
    
    /**
     * Muestra el sueldo neto de los empleados con antigüedad menor o igual a 2 años,
     * aplicando un incremento temporal del 10% al sueldo básico.
     */
    
    public void calcularImporteNetoPorEdad(Scanner scanner) {
        System.out.println("Ingrese una edad mínima para calcular el importe neto acumulado:");
        int edadMinima = scanner.nextInt();

        FechaUtil fechaUtil = new FechaUtil();

        double totalImporteNeto = empleados.stream()
            .filter(empleado -> fechaUtil.calcularEdad(empleado.getFechaNacimiento()) >= edadMinima)
            .mapToDouble(empleado -> {
                if (empleado.getSueldoNeto() == 0) {
                    empleado.calcularSueldo();
                }
                return empleado.getSueldoNeto();
            })
            .sum();

        System.out.println("El importe neto acumulado de los empleados con edad mayor o igual a " 
                           + edadMinima + " años es: " + totalImporteNeto);
    }
    
    
    public void mostrarIncrementoTemporal() {
        System.out.println("Aplicando incremento temporal del 10% al sueldo básico de empleados con antigüedad <= 2 años...");

        ConceptosLiquidacion conceptos = new ConceptosLiquidacion();
        double incremento = conceptos.SUELDO_BASICO * 0.10;

        empleados.stream()
                .filter(empleado -> empleado.getAntiguedad() <= 2)
                .forEach(empleado -> {
                    // Cálculo temporal del sueldo neto con el incremento
                    double[] sueldos = empleado.calcularSueldo();

                    // Aplicamos el incremento al valor de remunerativos bonificables
                    double remunerativosBonificablesConIncremento = sueldos[0] + incremento; 
                    double sueldoNetoConIncremento = remunerativosBonificablesConIncremento + sueldos[1] - sueldos[2]; // Recalculamos el sueldo neto

                    System.out.println("Empleado: " + empleado.getNombre());
                    System.out.println("Sueldo Neto Original: " + sueldos[3]);
                    System.out.println("Sueldo Neto con Incremento: " + sueldoNetoConIncremento);
                    System.out.println("-----------------------------------");
                });
    }
}
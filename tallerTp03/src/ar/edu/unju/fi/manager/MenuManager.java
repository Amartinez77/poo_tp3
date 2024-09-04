package ar.edu.unju.fi.manager;

import java.util.Scanner;

import ar.edu.unju.fi.dominio.Administrativo;
import ar.edu.unju.fi.dominio.Empleado;
import ar.edu.unju.fi.dominio.Profesional;

public class MenuManager {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Muestra el menú de opciones disponibles para el usuario.
     */
    public void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Precargar empleados (20 Empleados)");
        System.out.println("3. Mostrar empleados con antigüedad mayor a X años");
        System.out.println("4. Mostrar empleados cuya edad sea mayor o igual a un valor");
        System.out.println("5. Calcular importe neto acumulado para empleados mayores o iguales a una edad");
        System.out.println("6. Incrementar salario básico para empleados con antigüedad <= 2 años");
        System.out.println("9. Mostrar empleados * todos (test)");
        System.out.println("7. Salir");
    }

    /**
     * Maneja la selección de opciones del menú y ejecuta la acción correspondiente.
     * 
     * @param empleadoManager El objeto EmpleadoManager que maneja la lista de empleados.
     */
    public void manejarOpciones(EmpleadoManager empleadoManager) {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            try {
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        cargarEmpleado(empleadoManager);
                        break;
                        
                    case 2:
                        empleadoManager.inicializarEmpleados();
                        break;
                        
                    case 3:
                        empleadoManager.mostrarEmpleadoPorAntiguedad(scanner);
                        break;
                        
                    case 4:
                        empleadoManager.mostrarPorEdad(scanner);
                        break;
                        
                    case 5:
                        empleadoManager.calcularImporteNetoPorEdad(scanner);
                        break;
                        
                    case 6:
                        empleadoManager.mostrarIncrementoTemporal();
                        break;
                        
                    case 9:
                        empleadoManager.mostrarEmpleados();
                        break;
                        
                    case 7:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                        
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: debe ingresar un número.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }

    /**
     * Solicita al usuario los datos necesarios para crear un empleado y lo agrega
     * a la lista de empleados del EmpleadoManager.
     * 
     * @param empleadoManager El objeto EmpleadoManager que maneja la lista de empleados.
     */
    private void cargarEmpleado(EmpleadoManager empleadoManager) {
        System.out.print("Ingrese ID: ");
        String id = scanner.next();
        System.out.print("Ingrese Legajo: ");
        int legajo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese cantidad de Hijos: ");
        int hijos = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese Fecha de Nacimiento (dd-MM-yyyy): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Ingrese Antigüedad en años: ");
        int antiguedad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tipo de empleado (1. Profesional, 2. Administrativo): ");
        int tipoEmpleado = scanner.nextInt();
        scanner.nextLine();

        Empleado empleado;
        if (tipoEmpleado == 1) {
            empleado = new Profesional(id, legajo, nombre, hijos, fechaNacimiento, antiguedad);
        } else {
            System.out.print("Ingrese Categoría (1-20): ");
            int categoria = scanner.nextInt();
            empleado = new Administrativo(id, legajo, nombre, hijos, fechaNacimiento, antiguedad, categoria);
        }

        empleadoManager.agregarEmpleado(empleado);
    }
}
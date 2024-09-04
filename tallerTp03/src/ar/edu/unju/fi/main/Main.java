package ar.edu.unju.fi.main;

import ar.edu.unju.fi.manager.EmpleadoManager;
import ar.edu.unju.fi.manager.MenuManager;

/**
 * Clase principal que inicia la aplicación.
 * 
 * La clase Main contiene el método main que es el punto de entrada de la aplicación.
 * Aquí se inicializan los manejadores de empleados y del menú, y se llama al método para manejar las opciones del menú.
 */
public class Main {
    
    /**
     * Método principal que se ejecuta al iniciar la aplicación.
     * 
     * @param args Argumentos de línea de comandos, no se utilizan en esta aplicación.
     */
    public static void main(String[] args) {
        
        // Crear una instancia de EmpleadoManager para gestionar la lista de empleados.
        EmpleadoManager empleadoManager = new EmpleadoManager();
        
        // Crear una instancia de MenuManager para manejar la interacción con el usuario.
        MenuManager menuManager = new MenuManager();
        
        // Llamar al método para manejar las opciones del menú, pasando el empleadoManager como argumento.
        menuManager.manejarOpciones(empleadoManager);
    }
}
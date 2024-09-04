package ar.unju.edu.fi.main;



import ar.unju.edu.fi.manager.EmpleadoManager;
import ar.unju.edu.fi.manager.MenuManager;

public class Main {
	
	

	public static void main(String[] args) {
		
		EmpleadoManager empleadoManager = new EmpleadoManager();
        MenuManager menuManager = new MenuManager();
        menuManager.manejarOpciones(empleadoManager);
    }
}
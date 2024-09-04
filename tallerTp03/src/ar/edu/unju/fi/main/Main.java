package ar.edu.unju.fi.main;



import ar.edu.unju.fi.manager.EmpleadoManager;
import ar.edu.unju.fi.manager.MenuManager;

public class Main {
	
	

	public static void main(String[] args) {
		
		EmpleadoManager empleadoManager = new EmpleadoManager();
        MenuManager menuManager = new MenuManager();
        menuManager.manejarOpciones(empleadoManager);
    }
}
package ar.edu.unju.fi.dominio;

import ar.edu.unju.fi.util.ConceptosLiquidacion;

public class Profesional extends Empleado {

    private double adicionalTitulo;
    
    

    public Profesional(String id, Integer legajo, String nombre, Integer hijos, String fechaNacimiento, Integer antiguedad) {
        super(id, legajo, nombre, hijos, fechaNacimiento, antiguedad);
        
        ConceptosLiquidacion cl = new ConceptosLiquidacion();
        this.adicionalTitulo = cl.obtenerAdicionalProfesional();
    }
    
    

	@Override
	public String toString() {
		return "** Profesional"+ "\n" +
				"adicional por Titulo = " + adicionalTitulo + 
				" ID = " + getId() + "  Legajo = "+ getLegajo() + "\n" + 
				"Nombre = " + getNombre() + "\n" +
				"Hijos = " + getHijos() + "\n" +
				"Fecha de Nacimiento = " + getFechaNacimiento() + "\n" + 
				"Antiguedad = " + getAntiguedad() + "años" +"\n" +
				"Sueldo Neto = " + getSueldoNeto() + "\n" ; 
	}



	@Override
    public double[] calcularSueldo() {
    	
    	
    	
        ConceptosLiquidacion cl = new ConceptosLiquidacion();
        
        double sueldoBasico = ConceptosLiquidacion.SUELDO_BASICO;
        double adicionalAntiguedad = this.getAntiguedad()*cl.ADICIONAL_ANTIGUEDAD;
        double salarioFamiliar = getHijos() * ConceptosLiquidacion.ADICIONAL_HIJO;

        double remunerativosBonificables = sueldoBasico + adicionalAntiguedad + adicionalTitulo;
        double descuentos = remunerativosBonificables*0.15;
        
        double sueldoNeto = remunerativosBonificables + salarioFamiliar - descuentos;
        setSueldoNeto(sueldoNeto);
        
        return new double[] {remunerativosBonificables, salarioFamiliar, descuentos, sueldoNeto};
        
    }

    
}
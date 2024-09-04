package ar.edu.unju.fi.dominio;

import java.time.LocalDate;

import ar.edu.unju.fi.util.ConceptosLiquidacion;

public class Administrativo extends Empleado {

	private int categoria;



	public Administrativo(String id, Integer legajo, String nombre, Integer hijos, String fechaNacimiento2,
			Integer antiguedad, int categoria) {
		super(id, legajo, nombre, hijos, fechaNacimiento2, antiguedad);
		
		this.categoria = categoria;
		
	}
	
	
	




	@Override
	public String toString() {
		return "* Administrativo "+ "\n" + "categoria = " + categoria +	" ID = " + getId() + "  Legajo = " + getLegajo()	+"\n"+
				"Nombre = " + getNombre() + "\n" +
				"Hijos = " + getHijos() + "\n" +
				"Fecha de Nacimiento = " + getFechaNacimiento() + "\n" +
				"Antiguedad = " + getAntiguedad() + " años" + "\n" +
				"Sueldo Neto = " + getSueldoNeto() + "\n";
	}







	@Override
	public double[] calcularSueldo() {
		
		
		
		ConceptosLiquidacion conceptos = new ConceptosLiquidacion();
		
		// calculo de remunerativos
		double sueldoBasico = conceptos.SUELDO_BASICO;
		double adicionalAntiguedad = this.getAntiguedad()*conceptos.ADICIONAL_ANTIGUEDAD;
		double adicionalCategoria = conceptos.obtenerCategoria(this.categoria);
		double remunerativosBonificables = sueldoBasico + adicionalAntiguedad + adicionalCategoria;
		
		//salario familiar
		
		double salarioFamiliar = this.getHijos()*conceptos.ADICIONAL_HIJO;
		
		//descuentos
		
		double descuentos = remunerativosBonificables*0.15;
		
		// sueldo neto
		
		double sueldoNeto = remunerativosBonificables + salarioFamiliar - descuentos;
		
		setSueldoNeto(sueldoNeto);
		
		return new double[] {remunerativosBonificables, salarioFamiliar, descuentos, sueldoNeto};
		
	}
	
	public int getCategoria() {
		
		return categoria;
		
	}
	
	public void setCategoria(int categoria) {
		
		this.categoria = categoria;
		
	}
	
	

}

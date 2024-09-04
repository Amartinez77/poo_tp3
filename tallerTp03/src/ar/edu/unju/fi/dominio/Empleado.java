package ar.edu.unju.fi.dominio;

import java.time.LocalDate;

public abstract class Empleado {

	private String id;
    private Integer legajo;
    private String nombre;
    private Integer hijos;
    private String fechaNacimiento;
    private Integer antiguedad;
    
    private double sueldoNeto; // para guardar el sueldo ya calculado de cada empleado

    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getHijos() {
		return hijos;
	}

	public void setHijos(Integer hijos) {
		this.hijos = hijos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	
	
	
	public Empleado(String id, Integer legajo, String nombre, Integer hijos, String fechaNacimiento2,
			Integer antiguedad) {
		super();
		this.id = id;
		this.legajo = legajo;
		this.nombre = nombre;
		this.hijos = hijos;
		this.fechaNacimiento = fechaNacimiento2;
		this.antiguedad = antiguedad;
	}

	public abstract double[] calcularSueldo();
	
	public double sueldoNeto() {
		return sueldoNeto;
	}
	
	protected void setSueldoNeto(double sueldoNeto) {
		
		this.sueldoNeto = sueldoNeto;
		
	}
	
	public double getSueldoNeto() {
		return sueldoNeto;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id +
				", legajo=" + legajo +
				", nombre=" + nombre +
				", hijos=" + hijos	+
				", fechaNacimiento=" +	fechaNacimiento +
				", antiguedad=" + antiguedad +
				", sueldoNeto=" + sueldoNeto
				+ "]";
	}
	
	
	
	
}

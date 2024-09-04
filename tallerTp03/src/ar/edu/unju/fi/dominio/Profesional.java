package ar.edu.unju.fi.dominio;

import ar.edu.unju.fi.util.ConceptosLiquidacion;

/**
 * Representa un empleado profesional con un adicional por título.
 * Hereda de la clase {@link Empleado} e incluye la lógica para calcular su sueldo
 * tomando en cuenta un adicional por título específico.
 */
public class Profesional extends Empleado {

    private double adicionalTitulo;

    /**
     * Constructor para crear un empleado profesional.
     * 
     * @param id             
     * @param legajo         
     * @param nombre         
     * @param hijos          
     * @param fechaNacimiento  dd-MM-yyyy.
     * @param antiguedad    
     */
    public Profesional(String id, Integer legajo, String nombre, Integer hijos, String fechaNacimiento, Integer antiguedad) {
        super(id, legajo, nombre, hijos, fechaNacimiento, antiguedad);
        
        ConceptosLiquidacion cl = new ConceptosLiquidacion();
        this.adicionalTitulo = cl.obtenerAdicionalProfesional();
    }

    /**
     * Devuelve una representación en cadena de caracteres del empleado profesional.
     * 
     * @return Cadena con la información del empleado profesional.
     */
    @Override
    public String toString() {
        return "** Profesional" + "\n" +
                "Adicional por Titulo = " + adicionalTitulo + "\n" + 
                "ID = " + getId() + "  Legajo = " + getLegajo() + "\n" + 
                "Nombre = " + getNombre() + "\n" +
                "Hijos = " + getHijos() + "\n" +
                "Fecha de Nacimiento = " + getFechaNacimiento() + "\n" + 
                "Antigüedad = " + getAntiguedad() + " años" + "\n" +
                "Sueldo Neto = " + getSueldoNeto() + "\n"; 
    }

    /**
     * Calcula el sueldo del empleado profesional considerando el sueldo básico,
     * adicionales por antigüedad y título, así como descuentos y salario familiar.
     * 
     * @return Un array con los valores: remunerativos bonificables, salario familiar,
     *         descuentos y sueldo neto.
     */
    @Override
    public double[] calcularSueldo() {
        //ConceptosLiquidacion cl = new ConceptosLiquidacion();
        
        double sueldoBasico = ConceptosLiquidacion.SUELDO_BASICO;
        double adicionalAntiguedad = this.getAntiguedad() * ConceptosLiquidacion.ADICIONAL_ANTIGUEDAD;
        double salarioFamiliar = getHijos() * ConceptosLiquidacion.ADICIONAL_HIJO;

        double remunerativosBonificables = sueldoBasico + adicionalAntiguedad + adicionalTitulo;
        double descuentos = remunerativosBonificables * 0.15;
        
        double sueldoNeto = remunerativosBonificables + salarioFamiliar - descuentos;
        setSueldoNeto(sueldoNeto);
        
        return new double[] {remunerativosBonificables, salarioFamiliar, descuentos, sueldoNeto};
    }
}
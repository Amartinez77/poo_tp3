package ar.edu.unju.fi.dominio;

import ar.edu.unju.fi.util.ConceptosLiquidacion;

/**
 * Clase que representa a un empleado administrativo, extendiendo la clase base Empleado.
 * Esta clase maneja la información específica para un empleado administrativo, incluyendo
 * la categoría y el cálculo del sueldo neto basado en la categoría y antigüedad.
 */
public class Administrativo extends Empleado {

    private int categoria; // Categoría del empleado administrativo

    /**
     * Constructor de la clase Administrativo.
     * 
     * @param id                
     * @param legajo            
     * @param nombre            
     * @param hijos             
     * @param fechaNacimiento2  dd-MM-yyyy.
     * @param antiguedad        
     * @param categoria         
     */
    public Administrativo(String id, Integer legajo, String nombre, Integer hijos, String fechaNacimiento2,
                          Integer antiguedad, int categoria) {
        super(id, legajo, nombre, hijos, fechaNacimiento2, antiguedad);
        this.categoria = categoria;
    }

    /**
     * Método que devuelve una representación en formato de cadena de texto del empleado administrativo.
     * 
     * @return Una cadena con la información del empleado administrativo.
     */
    @Override
    public String toString() {
        return "* Administrativo " + "\n" +
               "categoria = " + categoria + " ID = " + getId() + "  Legajo = " + getLegajo() + "\n" +
               "Nombre = " + getNombre() + "\n" +
               "Hijos = " + getHijos() + "\n" +
               "Fecha de Nacimiento = " + getFechaNacimiento() + "\n" +
               "Antiguedad = " + getAntiguedad() + " años" + "\n" +
               "Sueldo Neto = " + getSueldoNeto() + "\n";
    }

    /**
     * Método para calcular el sueldo neto del empleado administrativo.
     * Calcula el sueldo basándose en el sueldo básico, el adicional por antigüedad,
     * el adicional por categoría, el salario familiar y los descuentos aplicables.
     * 
     * @return Un arreglo con los valores calculados: remunerativos bonificables,
     *         salario familiar, descuentos y sueldo neto.
     */
    @Override
    public double[] calcularSueldo() {
        double sueldoBasico = ConceptosLiquidacion.SUELDO_BASICO;
        double adicionalAntiguedad = this.getAntiguedad() * ConceptosLiquidacion.ADICIONAL_ANTIGUEDAD;
        double adicionalCategoria = ConceptosLiquidacion.obtenerCategoria(this.categoria);
        double remunerativosBonificables = sueldoBasico + adicionalAntiguedad + adicionalCategoria;
        
        double salarioFamiliar = this.getHijos() * ConceptosLiquidacion.ADICIONAL_HIJO;
        double descuentos = remunerativosBonificables * 0.15;
        double sueldoNeto = remunerativosBonificables + salarioFamiliar - descuentos;
        
        setSueldoNeto(sueldoNeto);
        
        return new double[] {remunerativosBonificables, salarioFamiliar, descuentos, sueldoNeto};
    }

    /**
     * Obtiene la categoría del empleado administrativo.
     * 
     * @return La categoría del empleado administrativo.
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del empleado administrativo.
     * 
     * @param categoria La nueva categoría del empleado administrativo.
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}

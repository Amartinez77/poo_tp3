package ar.edu.unju.fi.util;

/**
 * Clase que representa los totales de cálculo de sueldo para un empleado.
 * 
 * Esta clase almacena y proporciona métodos para acceder a los totales de remunerativos, salario familiar, descuentos y sueldo neto.
 */
public class Totales {

    private double remunerativos;
    private double salarioFamiliar;
    private double descuentos;
    private double sueldoNeto;


    public double getRemunerativos() {
        return remunerativos;
    }


    public void setRemunerativos(double remunerativos) {
        this.remunerativos = remunerativos;
    }


    public double getSalarioFamiliar() {
        return salarioFamiliar;
    }


    public void setSalarioFamiliar(double salarioFamiliar) {
        this.salarioFamiliar = salarioFamiliar;
    }


    public double getDescuentos() {
        return descuentos;
    }


    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }


    public double getSueldoNeto() {
        return sueldoNeto;
    }


    public void setSueldoNeto(double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    @Override
    public String toString() {
        return "Remunerativos Bonificables: " + remunerativos +
               ", Salario Familiar: " + salarioFamiliar +
               ", Descuentos: " + descuentos +
               ", Sueldo Neto: " + sueldoNeto;
    }

}

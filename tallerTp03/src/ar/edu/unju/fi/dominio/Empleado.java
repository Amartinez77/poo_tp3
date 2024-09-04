package ar.edu.unju.fi.dominio;



/**
 * Clase abstracta que representa a un empleado con atributos comunes y métodos para
 * calcular su sueldo neto.
 */
public abstract class Empleado {

    private String id;
    private Integer legajo;
    private String nombre;
    private Integer hijos;
    private String fechaNacimiento;
    private Integer antiguedad;
    private double sueldoNeto; 

    /**
     * Constructor para crear un empleado con los datos básicos.
     * 
     * @param id             
     * @param legajo          
     * @param nombre          
     * @param hijos           
     * @param fechaNacimiento  dd-MM-yyyy.
     * @param antiguedad      
     */
    public Empleado(String id, Integer legajo, String nombre, Integer hijos, String fechaNacimiento, Integer antiguedad) {
        this.id = id;
        this.legajo = legajo;
        this.nombre = nombre;
        this.hijos = hijos;
        this.fechaNacimiento = fechaNacimiento;
        this.antiguedad = antiguedad;
    }

    // Getters y setters para los atributos

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

    /**
     * Método abstracto que debe ser implementado por las subclases para calcular el sueldo.
     * 
     * @return Un array con los valores calculados: remunerativos bonificables, salario familiar,
     *         descuentos y sueldo neto.
     */
    public abstract double[] calcularSueldo();

    /**
     * Devuelve el sueldo neto del empleado.
     * 
     * @return Sueldo neto calculado.
     */
    public double getSueldoNeto() {
        return sueldoNeto;
    }

    /**
     * Establece el sueldo neto del empleado.
     * 
     * @param sueldoNeto .
     */
    protected void setSueldoNeto(double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    /**
     * Devuelve una representación en cadena de caracteres del empleado.
     * 
     * @return Cadena con la información del empleado.
     */
    @Override
    public String toString() {
        return "Empleado [id=" + id +
                ", legajo=" + legajo +
                ", nombre=" + nombre +
                ", hijos=" + hijos +
                ", fechaNacimiento=" + fechaNacimiento +
                ", antiguedad=" + antiguedad +
                ", sueldoNeto=" + sueldoNeto + "]";
    }
}
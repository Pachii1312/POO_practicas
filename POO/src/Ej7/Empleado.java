package Ej7;

import java.sql.Date;

public class Empleado {
    private int id;
    private String nombre;
    private Date fechaNacimiento;
    protected float sueldoBase;
    
    public Empleado() {
	// Constructor por defecto
    }
    
    public Empleado(int id, String nombre, Date fechaNacimiento, float sueldo_base) {
	this.id = id;
	this.nombre = nombre;
	this.fechaNacimiento = fechaNacimiento;
	this.sueldoBase = sueldo_base;
    }
    
    public int getId() {
	return id;
    }
    
    public void setId(int id) {
	this.id = id;
	
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(float sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
    
    public String toString() {
	return "Empleado ~~ " + "\n" +
		 " Id: " + id + "\n " +
		 " Nombre: " + nombre + "\n " +
		 " Fecha de Nacimiento: " + fechaNacimiento + "\n " +
		 " Sueldo Base: " + sueldoBase + "\n";
    }
}

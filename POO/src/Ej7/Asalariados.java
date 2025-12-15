package Ej7;

import java.sql.Date;

public class Asalariados  extends Empleado {
    private float sueldoFinal;
    private int horasExtra;
    
    public Asalariados() {
	// Constructor por defecto
    }

    public Asalariados(int id, String nombre, Date fechaNacimiento, float sueldoBase) {
	super(id, nombre, fechaNacimiento, sueldoBase);
	this.sueldoFinal = sueldoBase;
	this.horasExtra = 0;
    }

    public float getSueldoFinal() {
	return sueldoFinal;
    }

    public void setSueldoFinal(float precioHorasExtra) {
	// variables
	float sueldoF = sueldoBase + (horasExtra * precioHorasExtra);
	this.sueldoFinal = sueldoF;
    }
    
    public int getHorasExtra() {
	return horasExtra;
    }
    
    public void setHorasExtra(int horasExtra) {
	this.horasExtra = horasExtra;
    }
    
    @Override
    public String toString() {
	return "Asalariado ~~ " + "\n" +
	       super.toString() + "\n" +
	       " Salario Mensual: " + sueldoFinal + "\n" +
	       " Horas Extra: " + horasExtra + "\n";
    }

}

package Ej7;

import java.sql.Date;

public class ConsultoresExternos extends Empleado {
    private float sueldoFinal;
    private int horasTrabajadas;

    public ConsultoresExternos() {
	// Constructor por defecto
    }

    public ConsultoresExternos(int id, String nombre, Date fechaNacimiento, float sueldoBase) {
	super(id, nombre, fechaNacimiento, sueldoBase);
	this.sueldoFinal = sueldoBase;
	this.horasTrabajadas = 0;
    }

    public float getSueldoFinal() {
	return sueldoFinal;
    }

    public void setSueldoFinal(float sueldoFinal) {
	this.sueldoFinal = sueldoFinal;
    }
    
    public void calcularSueldoFinal(float precioHoraTrabajo) {
	this.sueldoFinal = horasTrabajadas * precioHoraTrabajo;
    }

    public int getHorasTrabajadas() {
	return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
	this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public String toString() {
	return "Consultor Externo ~~ " + "\n" +
	       super.toString() + "\n" +
	       " Salario Mensual: " + sueldoFinal + "\n" +
	       " Horas Trabajadas: " + horasTrabajadas + "\n";
    }

}

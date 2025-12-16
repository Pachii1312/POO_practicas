package Ej8;

public class Habitacion {
    private int numHabitacion;
    private int numOcupantes;
    private int precioPersona;
    
    public Habitacion () {
	// constructor por defecto
    }
    
    public Habitacion (int numHabitacion, int numOcupantes, int precioPersona) {
	this.numHabitacion = numHabitacion;
	this.numOcupantes = numOcupantes;
	this.precioPersona = precioPersona;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public int getNumOcupantes() {
        return numOcupantes;
    }

    public void setNumOcupantes(int numOcupantes) {
        this.numOcupantes = numOcupantes;
    }

    public int getPrecioPersona() {
        return precioPersona;
    }

    public void setPrecioPersona(int precioPersona) {
        this.precioPersona = precioPersona;
    }
    
    public int calcularPrecioHabitacion() {
	return numOcupantes * precioPersona;
    }

    @Override
    public String toString() {
	return "Habitacion ~~" + 
		" Nº Habitacion: " + numHabitacion +
		" Nº Ocupantes: " + numOcupantes +
		" Precio x Persona: " + precioPersona + "\n";
    }
    
    
}

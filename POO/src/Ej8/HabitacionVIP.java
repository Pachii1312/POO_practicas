package Ej8;

public class HabitacionVIP extends Habitacion {
    private int suplementoVIP;

    public HabitacionVIP() {
	// constructor por defecto
    }

    public HabitacionVIP(int numHabitacion, int numOcupantes, int precioPersona, int suplementoVIP) {
	super(numHabitacion, numOcupantes, precioPersona);
	this.suplementoVIP = suplementoVIP;
    }

    public int getSuplementoVIP() {
	return suplementoVIP;
    }

    public void setSuplementoVIP(int suplementoVIP) {
	this.suplementoVIP = suplementoVIP;
    }

    @Override
    public int calcularPrecioHabitacion() {
	return super.calcularPrecioHabitacion() + suplementoVIP;
    }

    @Override
    public String toString() {
	return super.toString() +
	       " Suplemento VIP: " + suplementoVIP + "\n";
    }

}

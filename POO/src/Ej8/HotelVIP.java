package Ej8;

import java.util.ArrayList;

public class HotelVIP {
    private String nombreHotel;
    protected ArrayList<HabitacionVIP> habitacionesVIP;
    
    public HotelVIP() {
	habitacionesVIP = new ArrayList<>();
    }
    
    public HotelVIP(String nombreHotel) {
	this.nombreHotel = nombreHotel;
	this.habitacionesVIP = new ArrayList<>();
    }
    
    public String getNombreHotel() {
   	return nombreHotel;
       }

       public void setNombreHotel(String nombreHotel) {
   	this.nombreHotel = nombreHotel;
       }

       public ArrayList<HabitacionVIP> getHabitacionesVIP() {
   	return habitacionesVIP;
       }

       public void setHabitacionesVIP(ArrayList<HabitacionVIP> habitacionesVIP) {
   	this.habitacionesVIP = habitacionesVIP;
       }
       
      public void aniadirHabitacion(HabitacionVIP habitacion) {
	  habitacionesVIP.add(habitacion);
      }
      
      @Override
      public String toString() {
	  String texto = "HotelVIP ~~\n" ;
      	  texto += " Nombre del Hotel: " + nombreHotel + "\n";
      	  texto += " Habitaciones VIP ----\n";
      	  for(HabitacionVIP h : habitacionesVIP) {
      	      texto += "º  " + h + "\n";
      	  }
      	  return texto;
      }
}


package Ej8;

import java.io.*;
import java.util.*;

public class Aplicacion {
    public static void main(String[] args) {
	// leer y cargar fichero
	File file = new File("C:\\Users\\Franco\\Documents\\Ficheros\\habitaciones.txt");
	ArrayList<Habitacion> habList = new ArrayList<>();

	try {
	    Scanner scFile = new Scanner(file);
	    String linea = "";
	    linea = scFile.nextLine().trim(); // leemos la cabecera
	    
	    while (scFile.hasNextLine()) {
		Habitacion habitaciones = new Habitacion();
		linea = scFile.nextLine().trim();
		
		if (linea.isEmpty()) {
		        continue;
		    }
		
		String[] partes = linea.split(":");
		habitaciones.setNumHabitacion(Integer.parseInt(partes[0].trim()));
		habitaciones.setNumOcupantes(Integer.parseInt(partes[1].trim()));
		habitaciones.setPrecioPersona(Integer.parseInt(partes[2].trim()));
		habList.add(habitaciones);
	    }
	    System.out.println("Datos cargados correctamente.");
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    System.out.println("No se ha encontrado el fichero.");
	}

	// mostrar habitaciones cargadas
	System.out.println("Habitaciones ----\n");
	for (Habitacion h : habList) {
	    System.out.println(h);
	}
	System.out.println("Precio de las habitaciones");
	for (Habitacion h : habList) {
	    System.out.println("Habitacion " + h.getNumHabitacion() + ": " + h.calcularPrecioHabitacion() + "€\n");
	}

	// creacion de ArrayList de HabitacionVIP y carga de datos
	ArrayList<HabitacionVIP> habVIPList = new ArrayList<>();
	habVIPList.add(new HabitacionVIP(201, 2, 100, 50));
	habVIPList.add(new HabitacionVIP(202, 3, 120, 70));
	habVIPList.add(new HabitacionVIP(203, 1, 150, 80));

	// mostramos los datos
	System.out.println("Habitaciones VIP ----\n");
	for (HabitacionVIP hv : habVIPList) {
	    System.out.println(hv);
	}
	System.out.println("Precio de las habitaciones VIP");
	for (HabitacionVIP hv : habVIPList) {
	    System.out
		    .println("Habitacion VIP " + hv.getNumHabitacion() + ": " + hv.calcularPrecioHabitacion() + "€\n");
	}

	HotelVIP hotel = new HotelVIP();
	HotelVIP hotel2 = new HotelVIP();

	hotel.setNombreHotel("Hotel 1");
	hotel2.setNombreHotel("Hotel 2");

	// añadimos habitaciones VIP a los hoteles
	hotel.aniadirHabitacion(habVIPList.get(0));
	hotel.aniadirHabitacion(habVIPList.get(1));
	hotel2.aniadirHabitacion(habVIPList.get(2));

	// mostramos los datos de los hoteles
	System.out.println("Hoteles VIP ----\n");
	System.out.println(hotel.toString());
	System.out.println(hotel2.toString());

	// menu
	Scanner sc = new Scanner(System.in);
	int option;
	do {
	    System.out.println("------MENU------");
	    System.out.println("1. Modificar datos");
	    System.out.println("2. Guardar datos");
	    System.out.println("3. Salir");
	    option = sc.nextInt();
	    sc.nextLine();

	    switch (option) {
	    case 1:
		modificarDatos(habList, sc);
		break;
	    case 2:
		guardarDatos(habList);
		break;
	    case 3:
		System.out.println("Saliendo...");
		break;
	    default:
		System.out.println("Esa opcion no existe\n");
	    }
	} while (option != 3);
    }
    // Methods
    public static void modificarDatos(ArrayList<Habitacion> habList, Scanner sc) {
	// variables
	int numHab;
	int nuevosOcupantes;
	int pos = -1;
	boolean existe = false;
	// verificamos que existe y modificamos sus datos
	while (!existe) {
	    System.out.println("Introduce el numero de habitacion a modificar:");
	    numHab = sc.nextInt();
	    sc.nextLine();
	    for (int i = 0; i < habList.size(); i++) {
		if(habList.get(i).getNumHabitacion() == numHab) {
		    existe = true;
		    pos = i;
		}
	    }
	    if(!existe) {
		System.out.println("La habitacion no existe.");
	    }
	}
	
	do {
	    System.out.println("Introduce el nuevo numero de ocupantes: (1 - 4)");
	    nuevosOcupantes = sc.nextInt();
	    sc.nextLine();
	    if(nuevosOcupantes >= 1 && nuevosOcupantes <= 4) {
		habList.get(pos).setNumOcupantes(nuevosOcupantes);
		System.out.println("Numero de ocupantes modificado correctamente.");
	    } else {
		System.out.println("El numero de ocupantes debe estar entre 1 y 4.");
		}
	} while(nuevosOcupantes < 1 || nuevosOcupantes > 4);
	
	// calculamos el nuevo precio
	habList.get(pos).calcularPrecioHabitacion();
	
	// mostramos los datos de la habitacion modificada
	System.out.println("Datos de la habitacion modificada:");
	System.out.println(habList.get(pos).toString());
    }
    
    public static void guardarDatos(ArrayList<Habitacion> habList) {
	// guardamos los datos en el fichero
	File file = new File("C:\\Users\\Franco\\Documents\\Ficheros\\habitaciones_prueba.txt");
	try {
	    FileWriter fw = new FileWriter(file);
	    PrintWriter pw = new PrintWriter(fw);
	    
	    pw.println("numeroHabitacion:numeroOcupantes:precioPersona");
	    for(Habitacion h : habList) {
		pw.println(h.getNumHabitacion() + ":" + h.getNumOcupantes() + ":" + h.getPrecioPersona());
	    }
	    pw.close();
	    System.out.println("Datos guardados correctamente.");
	} catch (IOException e) {
	    System.out.println("Error al guardar los datos: " + e.getMessage());
	}
    }
}

package Ej1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AuricularAPP {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner (System.in);
		
		ArrayList<Auricular> auricularList = new ArrayList<Auricular>();
		int opcion = 100;
		boolean continuar = true;
		
		File file = new File("C:\\Users\\Franco\\Documents\\Ficheros\\auriculares.txt");
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = "";
		String[] campos;
		linea = br.readLine();
				
		while (linea != null) {
			Auricular Auricular = new Auricular();
			campos = linea.split(";");
			Auricular.setModelo(campos[0]);
			Auricular.setMarca(campos[1]);
			Auricular.setPrecio(Double.parseDouble(campos[2]));
			Auricular.setStock(Integer.parseInt(campos[3]));
			auricularList.add(Auricular);
			linea = br.readLine();
		}
		
		br.close();
		fr.close();
		
		do {
			
			System.out.println("Menu");
			System.out.println("1. Visualizar los elementos");
			System.out.println("2. Subir el precio");
			System.out.println("3. Añadir elementos");
			System.out.println("4. Guardar elementos");
			System.out.println("5. Salir");
			System.out.println("Elige una opcion.");
			opcion = sc.nextInt();
			
			switch (opcion) {
			
			case 1:
				visualizarElementos (auricularList);
				break;
				
			case 2:
				subirPrecio (auricularList);
				break;
				
			case 3:
				anadirElementos (sc, auricularList);
				break;
				
			case 4:
				guardarElementos (auricularList);
				break;
				
			case 5:
				System.out.println("Has salido del menu.");
				break;
				
			default:
				
			}
			
		} while (opcion != 5);
	}	
	
		private static void visualizarElementos (ArrayList<Auricular> auricularList) {
			for (int i = 0; i < auricularList.size(); i++) {
			      System.out.println(auricularList.get(i).toString());
			    }
		}
		
		private static void subirPrecio (ArrayList<Auricular> auricularList) {
			Scanner sc = new Scanner (System.in);
			
			String datoEntrada = "";
			boolean encontrado = false;
			
			System.out.println("Dime el nombre del auricular al que deseas incrementarle 10 euros el precio");
			datoEntrada = sc.nextLine();
			
			for (int i = 0; i < auricularList.size(); i++) {
			     if (auricularList.get(i).getModelo().equalsIgnoreCase(datoEntrada)) {
			    	 auricularList.get(i).setPrecio(auricularList.get(i).getPrecio() + 10);
			    	 System.out.println("El precio se ha modificado correctamente");
			    	 encontrado = true;
			     }
			}
			
			if (encontrado == false) {
				System.out.println("Ese auricular no está en la lista.");
			}
		}
		
		private static void anadirElementos (Scanner sc, ArrayList<Auricular> auricularList) {
			String datoEntrada = "";
			sc.nextLine();
			Auricular auricularAux = new Auricular();
			
			System.out.println("Introduce el modelo del nuevo auricular: ");
			datoEntrada = sc.nextLine();
			auricularAux.setModelo(datoEntrada);
			
			System.out.println("Introduce la marca del nuevo auricular: ");
			datoEntrada = sc.nextLine();
			auricularAux.setMarca(datoEntrada);
			
			System.out.println("Introduce el precio del nuevo auricular: ");
			datoEntrada = sc.nextLine();
			auricularAux.setPrecio(Double.parseDouble(datoEntrada));
			
			System.out.println("Introduce el stock del nuevo auricular: ");
			datoEntrada = sc.nextLine();
			auricularAux.setStock(Integer.parseInt(datoEntrada));
			auricularList.add(auricularAux);
			System.out.println("Se ha añadido el auricular correctamente.");
			System.out.println(auricularAux.toString());
		}
		
		private static void guardarElementos (ArrayList<Auricular> auricularList) throws IOException {
			
			File file;
			file = new File("C:\\Users\\Franco\\Documents\\Ficheros\\auriculares.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int i = 0; i < auricularList.size(); i++) {
			     bw.write(auricularList.get(i).getModelo() + ";" + auricularList.get(i).getMarca() + ";" + 
			    		 auricularList.get(i).getPrecio() + ";" + auricularList.get(i).getStock() + "\n");
			    }
			System.out.println("Los datos han sido guardados.");
			
			bw.flush();
			bw.close();
		
	}

}

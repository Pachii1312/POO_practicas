package Ej2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class AnimalesAPP {

	public static void main(String[] args) throws FileNotFoundException {
		// CREACION Y LECTURA DEL FICHERO
		File file = new File("C:\\Users\\Franco\\Documents\\Ficheros\\info.txt");
		try (Scanner scFile = new Scanner(file)) {
			ArrayList<Animales> animalesList = new ArrayList<Animales>();

			while (scFile.hasNext()) {
				Animales animales = new Animales();
				String linea = scFile.nextLine();
				String[] campos = linea.split("::");
				animales.setNombre(campos[0]);
				animales.setEspecie(campos[1]);
				animales.setEdad(Integer.parseInt(campos[2]));
				String[] habitats = { campos[3], campos[4], campos[5] };
				animales.setHabitat(habitats);
				animalesList.add(animales);
			}
			System.out.println("Datos cargados");
			for (Animales a : animalesList) {
				System.out.println(a);
			}

			// VARIABLES
			Scanner sc = new Scanner(System.in);
			int option;

			// MENU
			do {
				System.out.println("------MENU-----");
				System.out.println("1. Visualizar datos de 2 animales ");
				System.out.println("2. Visualizar el animal mas longevo");
				System.out.println("3. Visualizar los habitats del animal elegido");
				System.out.println("4. Salir");
				option = Integer.parseInt(sc.nextLine());

				switch (option) {
				case 1:
					visualizarDatos(animalesList);
					break;
				case 2:
					visualizarMasLongevo(animalesList);
					break;
				case 3:
					visualizarHabitats(animalesList, sc);
					break;
				case 4:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Introduce una opcion valida");
				}

			} while (option != 4);
		} catch (NumberFormatException e) {
			System.out.println("Introduce un caracter valido");
			e.printStackTrace();
		}
	}

	// METODOS
	// Option 1
	public static void visualizarDatos(ArrayList<Animales> animalesList) {
		// VISUALIZAR DATOS
		for (int i = 0; i < 2; i++) {
			System.out.println(animalesList.get(i).toString());
		}
	}

	// Option 2
	public static void visualizarMasLongevo(ArrayList<Animales> animalesList) {
		// VISUALIZAR EL MAS LONGEVO
		// variables
		int masLongevo = 0;
		int pos = -1;

		for (int i = 0; i < animalesList.size(); i++) {
			if (animalesList.get(i).getEdad() > masLongevo) {
				masLongevo = animalesList.get(i).getEdad();
				pos = i;
			}
		}

		System.out.println("El animal mas longevo es: " + animalesList.get(pos).getNombre() + " y su edad es de: "
				+ animalesList.get(pos).getEdad() + "\n");
	}

	// Option 3
	public static void visualizarHabitats(ArrayList<Animales> animalesList, Scanner sc) {
		// variables
		String animal;
		boolean existe = false;

		// VERIFICAMOS QUE EL ANIMAL EXISTA Y MOSTRAMOS SUS HABITATS
		while (!existe) {
			System.out.println("Introduce el animal");
			animal = sc.nextLine();

			for (int i = 0; i < animalesList.size(); i++) {
				if (animalesList.get(i).getNombre().equalsIgnoreCase(animal)) {
					existe = true;
					System.out.println("Animal: " + animalesList.get(i).getNombre());
					System.out.println("Habitats: " + Arrays.toString(animalesList.get(i).getHabitat()));
				}
			}
			if (!existe) {
				System.out.println("Ese animal no existe");
			}
		}
	}

}

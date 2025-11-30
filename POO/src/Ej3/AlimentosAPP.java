package Ej3;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class AlimentosAPP {

	public static void main(String[] args) throws FileNotFoundException {
		// leer fichero y cargar datos
		File file = new File("C:\\Users\\Franco\\Documents\\Ficheros\\alimentos.txt");
		Scanner scFile = new Scanner(file);
		ArrayList<Alimentos> alimentosList = new ArrayList<Alimentos>();

		while (scFile.hasNext()) {
			Alimentos alimentos = new Alimentos();
			String linea = scFile.nextLine();
			linea = linea.replace(",", ".");
			String[] campos = linea.split(";");

			alimentos.setAlimento(campos[0]);
			alimentos.setEstado(campos[1]);
			alimentos.setCalorias(Double.parseDouble(campos[2]));
			alimentos.setGrasas(Double.parseDouble(campos[3]));
			alimentos.setProteinas(Double.parseDouble(campos[4]));
			alimentos.setCarbohidratos(Double.parseDouble(campos[5]));
			alimentos.setTipo(campos[6]);

			alimentosList.add(alimentos);
		}

		System.out.println("Datos cargados\n");

		// mostrar alimentos sin repetir
//		String ultimo = "";
//		System.out.println("Alimentos: \n");
//		for(int i = 0; i < alimentosList.size(); i++) {
//			String actual = alimentosList.get(i).getAlimento();
//			if(!actual.equalsIgnoreCase(ultimo)) {
//				System.out.println(actual);
//				ultimo = actual;
//			}
//		}

		// variable para el menu
		int option;
		Scanner sc = new Scanner(System.in);

		// menu
		do {
			System.out.println("------MENU------");
			System.out.println("1. Visualizar datos nutricionales");
			System.out.println("2. Visualizar alimentos personalizado");
			System.out.println("3. Calcular calorias");
			System.out.println("4. Guardar datos");
			System.out.println("5. Salir");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				visualizarDatos(alimentosList, sc);
				break;
			case 2:
				visualizarDatosPersonalizado(alimentosList, sc);
				break;
			case 3:
				calcularCalorias(alimentosList, sc);
				break;
			case 4:
			default:
				System.out.println("Esa opcion no existe\n");
			}
		} while (option != 4);

	}

	// Methods

	// Option 1
	public static void visualizarDatos(ArrayList<Alimentos> alimentosList, Scanner sc) {
		// variables
		String alimento;
		boolean existe = false;
		// verificamos que existe y mostramos sus datos nutricionales
		while (!existe) {
			System.out.println("Introduce un alimento");
			alimento = sc.nextLine();

			for (int i = 0; i < alimentosList.size(); i++) {
				if (alimentosList.get(i).getAlimento().equalsIgnoreCase(alimento)) {
					existe = true;
					System.out.println("Alimento: " + alimentosList.get(i).getAlimento());
					System.out.println("Estado: " + alimentosList.get(i).getEstado());
					System.out.println("Grasas: " + alimentosList.get(i).getGrasas());
					System.out.println("Proteinas: " + alimentosList.get(i).getProteinas());
					System.out.println("Carbohidratos: " + alimentosList.get(i).getCarbohidratos());
					System.out.println("Tipo: " + alimentosList.get(i).getTipo() + "\n");
				}
			}
			if (!existe) {
				System.out.println("Ese alimento no existe");
			}
		}
	}

	// Option 2
	public static void visualizarDatosPersonalizado(ArrayList<Alimentos> alimentosList, Scanner sc) {
		// variables
		int num1;
		int num2;

		System.out.println("Introduce la posicion del alimento que quieras ver");
		num1 = sc.nextInt();

		System.out.println("Introduce el numero de registros que quieres ver");
		num2 = sc.nextInt();

		for (int i = num1; i < num2 + num1; i++) {
			System.out.println("Alimento: " + alimentosList.get(i).getAlimento());
			System.out.println("Estado: " + alimentosList.get(i).getEstado());
			System.out.println("Grasas: " + alimentosList.get(i).getGrasas());
			System.out.println("Proteinas: " + alimentosList.get(i).getProteinas());
			System.out.println("Carbohidratos: " + alimentosList.get(i).getCarbohidratos());
			System.out.println("Tipo: " + alimentosList.get(i).getTipo() + "\n");
		}
	}

	// Option 3
	public static void calcularCalorias(ArrayList<Alimentos> alimentosList, Scanner sc) {
		boolean existe = false;
		String alimento = "";
		String estados = "";

		// verificar el alimento
		while (!existe) {
			System.out.println("Introduce un alimento");
			alimento = sc.nextLine();

			for (int i = 0; i < alimentosList.size(); i++) {
				if (alimentosList.get(i).getAlimento().equalsIgnoreCase(alimento)) {
					existe = true;
					estados += alimentosList.get(i).getEstado() + " ";
				}
			}

			if (!existe) {
				System.out.println("Ese alimento no existe");
			} else {
				System.out.println("Estados disponibles: [ " + estados + "]");
			}
		}

		// verificar el estado
		String estado;
		boolean estadoValido = false;

		do {
			System.out.println("Introduce el estado:");
			estado = sc.nextLine();

			if (estados.toLowerCase().contains(estado.toLowerCase())) {
				estadoValido = true;
			} else {
				System.out.println("Estado no disponible");
			}
		} while (!estadoValido);

		System.out.println("Introduce el peso (en gramos):");
		double peso = sc.nextDouble();

		double calTotal = 0;

		// calcular el total de las calorias
		for (int i = 0; i < alimentosList.size(); i++) {
			if (alimentosList.get(i).getAlimento().equalsIgnoreCase(alimento)
					&& alimentosList.get(i).getEstado().equalsIgnoreCase(estado)) {

				calTotal = (alimentosList.get(i).getCalorias() * peso) / 100;
				System.out.println("El total de calorías es: " + calTotal);
			}
		}

	}

}

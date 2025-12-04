package Ej5;

import java.util.Scanner;

public class CuentaAPP {
	public static void main(String[] args) {
		int option;
		Scanner sc = new Scanner(System.in);
		CuentaPlazo cuentaP = null;

		// menu
		do {
			System.out.println("----MENU----");
			System.out.println("1. Crear Cuenta");
			System.out.println("2. Ingreso de Dinero");
			System.out.println("3. Retiro de Dinero");
			System.out.println("4. Visualizar saldo");
			System.out.println("5. Salir");
			option = Integer.parseInt(sc.nextLine());

			switch (option) {
			case 1:
				cuentaP = crearCuenta();
				break;
			case 2:
				ingresarDinero(sc,cuentaP);
				break;
			case 3:
				retirarDinero(sc,cuentaP);
				break;
			case 4:
				mostrarSaldo(cuentaP);
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Esa opcion es invalida");
			}
		} while (option != 5);
	}
	
	// methods
	// Option 1
	public static CuentaPlazo crearCuenta() {
		CuentaPlazo cuentaP = new CuentaPlazo(null);
		System.out.println("Tu IBAN: " + cuentaP.getIban());
		System.out.println("Fecha de creacion: " + cuentaP.getFecha_creacion());
		System.out.println("\n Cuenta creada con exito ");
		return cuentaP;
	}
	
	// Option 2
	public static void ingresarDinero(Scanner sc, CuentaPlazo cuentaP) {
		float saldoIN;
		
		System.out.println("Cuanto dinero vas a ingresar?");
		saldoIN = Float.parseFloat(sc.nextLine());
		cuentaP.ingresarDinero(saldoIN);
		System.out.println("Dinero ingresado con exito");
		
	}
	
	// Option 3
	public static void retirarDinero(Scanner sc, CuentaPlazo cuentaP) {
		float saldoRE;
		boolean suficiente = false;
		
		do {
			suficiente = false;
		System.out.println("Cuanto dinero vas a retirar?");
		saldoRE = Float.parseFloat(sc.nextLine());
		
		if(cuentaP.sacarDinero(saldoRE)) {
			System.out.println("Dinero retirado");
			suficiente = true;
		}
		else {
			System.out.println("Saldo insuficiente");
		}
		} while (!suficiente);
		
	}
	
	// Option 4
	public static void mostrarSaldo(CuentaPlazo cuentaP) {
		System.out.println("Saldo disponible: " + cuentaP.getsaldo());
	}

}

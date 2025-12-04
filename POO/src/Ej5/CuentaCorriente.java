package Ej5;

import java.security.SecureRandom;

public class CuentaCorriente {
	public String iban;
	private float saldo;
	private int ingresoCuenta;
	private float porcentajeComision;

	public CuentaCorriente() {
		
	}
	
	public CuentaCorriente(String iban, float porcentajeComision) {
		this.iban = generarIBAN();
		this.saldo = 0;
		this.porcentajeComision = porcentajeComision;
		this.ingresoCuenta = 0;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getPorcentajeComision() {
		return porcentajeComision;
	}
	
	public void setPorcentajeComision(float porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}

	public float getsaldo() {
		return (saldo);
	}

	public void setsaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getIngresoCuenta() {
		return ingresoCuenta;
	}

	public void setIngresoCuenta(int ingresoCuenta) {
		this.ingresoCuenta = ingresoCuenta;
	}

	public void ingresarDinero(float cantidad) {
		// SE DEFINE UNA VARIABLE BONUS
		float bonus = 0;
		// EN CADA INGRESO SE ACTIVA UN CONTADOR
		if (++ingresoCuenta == 3) {
			// SI EL CONTADOR LLEGA A 3
			ingresoCuenta = 0;
			bonus = 0.7f;
		}
		// SE VA A AGREGAR EL VALOR DEL BONUS AL SALDO
		saldo += cantidad + bonus;
	}

	public boolean sacarDinero(float cantidad) {
		// SE CALCULA EL PORCENTAJE DE COMISION Y SE ASIGNA EL VALOR A LA VARIABLE (COMISION)
		float comision = porcentajeComision * cantidad;
		// VERRIFICA SI LA CANTIDAD A RETIRAR MAS LA COMISION CUBREN EL SALDO
		if (cantidad + comision <= saldo) {
			// SI ALCANZA, DESCUENTA DEL SALDO TOTAL Y VUELVE A 0 EL CONTADOR DE INGRESOS
			saldo -= cantidad + comision; // resta (importe+comision)
			ingresoCuenta = 0;
			// DEVUELVE TRUE
			return true;
		} else
			// SI NO ALCANZA, DEVUELVE FALSE
			return false;
	}
	
	public static String generarIBAN() {
	    SecureRandom sr = new SecureRandom();
	    String iban = "ES";

	    for (int i = 0; i < 22; i++) {
	        int numero = sr.nextInt(10); 
	        iban += numero;              
	    }

	    return iban;
	}
}

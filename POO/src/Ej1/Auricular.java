package Ej1;

public class Auricular {
	
	private String modelo;
	private String marca;
	private double precio;
	private int stock;
	
	//Constructor
	
	public Auricular () {
		
	}

	public Auricular (String modelo, String marca, double precio, int stock) {
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.stock = stock;
	}
	
	
	//Getters y Setters
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toString() {
		return "Auricular: su modelo es " + modelo + ", su marca es " + marca + ", su precio es " + precio + " y su stock es " + stock;
		
		
	}
	
}

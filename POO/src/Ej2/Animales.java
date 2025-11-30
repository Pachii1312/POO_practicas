package Ej2;

import java.util.Arrays;

public class Animales {
	private String nombre;
	private String especie;
	private int edad;
	private String[] habitat;
	
	public Animales () {
		// constructor vacio
	}
	
	public Animales (String nombre, String especie, int edad, String[] habitat) {
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
		this.habitat = habitat;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String[] getHabitat() {
		return habitat;
	}

	public void setHabitat(String[] habitat) {
		this.habitat = habitat;
	}

	@Override
	public String toString() {
	    return "Animales:\n" +
	           "  Nombre: " + nombre + "\n" +
	           "  Especie: " + especie + "\n" +
	           "  Edad: " + edad + "\n" +
	           "  Hábitat: " + Arrays.toString(habitat) + "\n";
	}
}

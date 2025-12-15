package Ej7;

import java.util.ArrayList;

public class GestionEmpresa {
    public static void main(String[] args) {
	// arrayList de la clases
	ArrayList<ConsultoresExternos> consulExter = new ArrayList<>();
	ArrayList<Asalariados> asalariados = new ArrayList<>();
	
	// agregar empleados de prueba
	consulExter.add(new ConsultoresExternos(1, "Juan Perez", java.sql.Date.valueOf("1980-05-15"), 2000));
	consulExter.add(new ConsultoresExternos(2, "Maria Lopez", java.sql.Date.valueOf("1985-11-30"), 2200));
	asalariados.add(new Asalariados(1, "Ana Gomez", java.sql.Date.valueOf("1990-08-22"), 2500));
	asalariados.add(new Asalariados(2, "Luis Martinez", java.sql.Date.valueOf("1975-03-10"), 2700));
	
	// agregar horas trabajadas y extras
	consulExter.get(0).setHorasTrabajadas(160);
	consulExter.get(1).setHorasTrabajadas(150);
	consulExter.get(0).calcularSueldoFinal(100); // precio por hora trabajo
	consulExter.get(1).calcularSueldoFinal(100);
	asalariados.get(0).setHorasExtra(10);
	asalariados.get(1).setHorasExtra(5);
	asalariados.get(0).setSueldoFinal(40); // precio por hora extra
	asalariados.get(1).setSueldoFinal(40);
	
	
	// calculamos sueldos finales
	System.out.println(consulExter.get(0).toString());
	System.out.println(consulExter.get(1).toString());
	System.out.println(asalariados.get(0).toString());
	System.out.println(asalariados.get(1).toString());
	System.out.println("Sueldos finales calculados.\n");
	
	// con un for-each, recorremos los arrayLists y calculamos el gasto total en sueldos
	float gastoTotal = 0;
	for (ConsultoresExternos ce : consulExter) {
	    gastoTotal += ce.getSueldoFinal();
	}
	for (Asalariados a : asalariados) {
	    gastoTotal += a.getSueldoFinal();
	}
	
	System.out.println("Gasto total en sueldos: " + gastoTotal);
	
	// variable para calcular el gasto total
//	ArrayList<Empleado> Empleados = new ArrayList<>();
//	Empleados.addAll(consulExter);
//	Empleados.addAll(asalariados);
//	float gastoTotal2 = 0;
//	
//	for (Empleado e : Empleados) {
//	    gastoTotal2 += e.getSueldoFinal();
//	}
//	
//	System.out.println("Gasto total en sueldos (método alternativo): " + gastoTotal2);
    }
}

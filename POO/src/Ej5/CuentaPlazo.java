package Ej5;

import java.time.LocalDate;

public final class CuentaPlazo extends CuentaCorriente {
	private LocalDate fecha_creacion;
	
	public CuentaPlazo(LocalDate fecha_creacion) {
		super(generarIBAN(),0);
		this.fecha_creacion = LocalDate.now();
	}

	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	public boolean sacarDinero(float cantidad) {
		// VERRIFICA SI LA CANTIDAD A RETIRAR MAS LA COMISION CUBREN EL SALDO
		if (cantidad <= getSaldo()) {
			setSaldo(getSaldo() - cantidad);
			// DEVUELVE TRUE
			return true;
		} else
			// SI NO ALCANZA, DEVUELVE FALSE
			return false;
	}
}



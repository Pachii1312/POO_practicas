package Ej4;

public class Usuarios {
	private int id;
	private String nombre;
	private String apellidos;
	private String nombreUsuario;
	private String contrasenia;
	private boolean activo;
	
	public Usuarios() {
		// constructor vacio
	}
	
	public Usuarios(int id, String nombre, String apellidos, String nombreUsuario, String contrasenia, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.activo = activo;
	}
	
	public Usuarios(int id, String nombre, String apellidos) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombre;
		this.contrasenia = "1234";
		this.activo = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String getEstado() {
		return activo ? "Activo" : "Inactivo";
	}

	@Override
	public String toString() {
		return "Usuarios:\n" +
				"  Id: " + id + "\n" +
				"  Nombre: " + nombre + "\n" +
				"  Apellidos: " + apellidos + "\n" +
				"  NombreUsuario: " + nombreUsuario + "\n" +
				"  Contrasenia: " + contrasenia + "\n" +
				"  Activo: " + getEstado() + "\n";
	}
	
	public String toStringPersonalizado() {
		return "Usuario ~~" + nombreUsuario + "~~" + "\n" +
				"  Id: " + id + "\n" +
				"  Nombre: " + nombre + "\n" +
				"  Apellidos: " + apellidos + "\n" +
				"  NombreUsuario: " + nombreUsuario + "\n" +
				"  Contrasenia: " + contrasenia + "\n" +
				"  Activo: " + getEstado() + "\n";
	}
	
	
}

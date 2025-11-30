package Ej4;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class GestionUsuarios {

	public static void main(String[] args) {
		ArrayList<Usuarios> usuariosList = new ArrayList<Usuarios>();
		File file = new File("C:\\Users\\Franco\\Documents\\Ficheros\\usuarios.txt");

		// READING AND LOADING DATA FROM A FILE
		try {

			Scanner scFile = new Scanner(file);

			while (scFile.hasNext()) {
				Usuarios usuario = new Usuarios();
				String linea = scFile.nextLine();
				String[] campos = linea.split(":");

				usuario.setId(Integer.parseInt(campos[0]));
				usuario.setNombre(campos[1]);
				usuario.setApellidos(campos[2]);
				usuario.setContrasenia(campos[3]);
				if (campos[4].equalsIgnoreCase("0")) {
					usuario.setActivo(false);
				} else if (campos[4].equalsIgnoreCase("1")) {
					usuario.setActivo(true);
				}

				if (campos.length == 5) {
					usuario.setNombreUsuario(campos[1]);
				} else {
					usuario.setNombreUsuario(campos[5]);
				}
				usuariosList.add(usuario);
			}
		} catch (IOException e) {
			System.out.println("Error al leer archivo");
			e.printStackTrace();
		}
		// -------------------------------------------------------------

		// global use variables
		String option;
		Scanner sc = new Scanner(System.in);

		// MENU ------------------
		do {
			System.out.println("-----MENU-----");
			System.out.println("1. Mostrar usuario");
			System.out.println("2. Mostrar todos los usuarios");
			System.out.println("3. Eliminar usuario");
			System.out.println("4. Crear un usuario nuevo");
			System.out.println("5. Crear un usuario por defecto");
			System.out.println("6. Editar datos");
			System.out.println("7. Guardar datos");
			System.out.println("8. Salir");
			System.out.println("\n Seleccione una opcion: ");
			option = sc.nextLine();

			switch (option) {
			case "1":
				mostrarUsuario(usuariosList, sc);
				break;
			case "2":
				mostrarTodosLosUsuarios(usuariosList, sc);
				break;
			case "3":
				eliminarUsuario(usuariosList, sc);
				break;
			case "4":
				crearUsuario(usuariosList, sc);
				break;
			case "5":
				crearUsuarioPorDefecto(usuariosList, sc);
				break;
			case "6":
				editarDatos(usuariosList, sc);
				break;
			case "7":
				guardarDatos(usuariosList, file);
				break;
			case "8":
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Esa opcion no es valida\n");
			}

		} while (!option.equals("8"));
	}// end of main

	// METHODS
	// Option 1
	// METHODS --------------------

	// Option 1
	public static void mostrarUsuario(ArrayList<Usuarios> usuariosList, Scanner sc) {
		// variables
		String usuario;
		boolean existe = false;

		do {
			System.out.println("Ingrese el usuario que quiera ver sus datos");
			usuario = sc.nextLine();

			for (int i = 0; i < usuariosList.size(); i++) {
				if (usuariosList.get(i).getNombreUsuario().equalsIgnoreCase(usuario)) {
					existe = true;
					System.out.println(usuariosList.get(i).toStringPersonalizado());
				}
			}

			if (!existe) {
				System.out.println("Ingrese un usuario valido\n");
			}
		} while (!existe);

	}

	// Option 2
	// Option 2
	public static void mostrarTodosLosUsuarios(ArrayList<Usuarios> usuariosList, Scanner sc) {
		for (int i = 0; i < usuariosList.size(); i++) {
			System.out.println(usuariosList.get(i).toString());
		}
	}

	// Option 3
	// Option 3
	public static void eliminarUsuario(ArrayList<Usuarios> usuariosList, Scanner sc) {
		// variables
		String usuario;
		boolean existe = false;

		do {
			existe = false;
			System.out.println("Que usuario quieres eliminar?");
			usuario = sc.nextLine();

			for (int i = 0; i < usuariosList.size(); i++) {
				if (usuariosList.get(i).getNombreUsuario().equalsIgnoreCase(usuario)) {
					existe = true;
					usuariosList.remove(i);
					System.out.println("Usuario eliminado con exito.\n");
					break;
				}
			}
			if (!existe) {
				System.out.println("Ese usuario no esta registrado\n");
			}
		} while (!existe);
	}

	// Option 4
	// Option 4
	public static void crearUsuario(ArrayList<Usuarios> usuariosList, Scanner sc) {
		// variables
		String newId;
		int maxId = 0;
		String newName;
		String newLastName;
		String newPassword;
		String newUserName;
		boolean existe = false;
		Usuarios usuario = new Usuarios();

		// ID
		System.out.println("Ingrese nuevo ID o use uno default (presione D): ");
		newId = sc.nextLine();

		if (newId.equalsIgnoreCase("d")) {
			for (int i = 0; i < usuariosList.size(); i++) {
				if (usuariosList.get(i).getId() > maxId) {
					maxId = usuariosList.get(i).getId();
				}
			}
			usuario.setId(maxId + 1);
		} else {
			usuario.setId(Integer.parseInt(newId));
		}

		// NOMBRE
		System.out.println("Ingrese su nombre: ");
		usuario.setNombre(newName = sc.nextLine());

		// APELLIDOS
		System.out.println("Ingrese su(s) apellido(s): ");
		usuario.setApellidos(newLastName = sc.nextLine());

		// NOMBRE DE USUARIO
		do {
			existe = false;
			System.out.println("Ingrese su nombre de usuario: ");
			newUserName = sc.nextLine();

			for (int i = 0; i < usuariosList.size(); i++) {
				if (usuariosList.get(i).getNombreUsuario().equals(newUserName)) {
					existe = true;
				}
			}

			if (existe) {
				System.out.println("Ese usuario ya existe. Ingrese otro");
				
			} else {
				usuario.setNombreUsuario(newUserName);
			}
		} while (existe);

		// CONTRASEÑA
		do {
			System.out.println("Ingrese su contrasenia (minimo 4 caracteres): ");
			newPassword = sc.nextLine();

			if (newPassword.length() < 4) {
				System.out.println("Tiene que tener minimo 4 caracteres");
			} else {
				usuario.setContrasenia(newPassword);
			}
		} while (newPassword.length() < 4);

		// ESTADO ACTIVO POR DEFECTO
		usuario.setActivo(true);

		// GUARDAR USUARIO NUEVO
		usuariosList.add(usuario);
		System.out.println("Usuario creado con exito\n");
	}

	// Option 5
	public static void crearUsuarioPorDefecto(ArrayList<Usuarios> usuariosList, Scanner sc) {
		// variables
		String id;
		int newID;
		int maxId = 0;
		String newName;
		String newLastName;

		// ID
		System.out.println("Ingrese nuevo ID o use uno default (presione D): ");
		id = sc.nextLine();

		if (id.equalsIgnoreCase("d")) {
			for (int i = 0; i < usuariosList.size(); i++) {
				if (usuariosList.get(i).getId() > maxId) {
					maxId = usuariosList.get(i).getId();
				}
			}
			newID = maxId + 1;
		} else {
			newID = Integer.parseInt(id);
		}

		// NOMBRE
		System.out.println("Ingrese su nombre: ");
		newName = sc.nextLine();

		// APELLIDOS
		System.out.println("Ingrese su(s) apellidos(s): ");
		newLastName = sc.nextLine();

		// LLAMAMOS AL CONSTRUCTOR Y GUARDAMOS EL NUEVO USUARIO
		Usuarios usuario = new Usuarios(newID, newName, newLastName);
		usuariosList.add(usuario);
		System.out.println("Usuario creado con exito.\n");
	}

	// Option 6
	public static void editarDatos(ArrayList<Usuarios> usuariosList, Scanner sc) {
		// variables
		String user;
		String newUser;
		String newPassword;
		boolean existe = false;
		int pos = -1;

		do {
			existe = false;
			System.out.println("Que usuario quieres modificar?");
			user = sc.nextLine();

			for (int i = 0; i < usuariosList.size(); i++) {
				if (usuariosList.get(i).getNombreUsuario().equalsIgnoreCase(user)) {
					existe = true;
					pos = i;
					break;
				}
			}
			if (!existe) {
				System.out.println("Ingrese un usuario valido\n");
			}
		} while (!existe);

		System.out.println(
				"Ingrese el nuevo nombre de usuario: (anterior - " + usuariosList.get(pos).getNombreUsuario() + " )");
		newUser = sc.nextLine();
		usuariosList.get(pos).setNombreUsuario(newUser);

		do {
			System.out.println(
					"Ingrese la nueva contrasenia : (anterior - " + usuariosList.get(pos).getContrasenia() + " )");
			newPassword = sc.nextLine();
			if (newPassword.length() < 4) {
				System.out.println("Tiene que tener minimo 4 caracteres\n");
			} else {
				usuariosList.get(pos).setContrasenia(newPassword);
			}
		} while (newPassword.length() < 4);

		System.out.println("Usuario modificado correctamente.\n");
	}

	// Option 7
	// Option 7
	public static void guardarDatos(ArrayList<Usuarios> usuariosList, File file) {
		try {
			FileWriter fw = new FileWriter("C:\\Users\\Franco\\Documents\\Ficheros\\usuariosPrueba.txt");
			PrintWriter pw = new PrintWriter(fw);

			for (int i = 0; i < usuariosList.size(); i++) {
				pw.println(usuariosList.get(i).getId() + ":" + usuariosList.get(i).getNombre() + ":"
						+ usuariosList.get(i).getApellidos() + ":" + usuariosList.get(i).getContrasenia() + ":"
						+ (usuariosList.get(i).isActivo() ? "1" : "0") + ":" + usuariosList.get(i).getNombreUsuario());
			}
			pw.close();
			fw.close();
			System.out.println("Datos cargados correctamente.");
		} catch (IOException e) {
			System.out.println("Error al cargar los datos");
			e.printStackTrace();
		}
	}
}// end of class

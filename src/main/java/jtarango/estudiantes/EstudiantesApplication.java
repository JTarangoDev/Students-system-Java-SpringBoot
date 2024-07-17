package jtarango.estudiantes;

import jtarango.estudiantes.modelo.Estudiante;
import jtarango.estudiantes.servicio.EstudianteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;

	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicación");
		// Levantar la fabrica de Spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicación finalizada ");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Ejecutando método run de Spring" + nl);

		var salir = false;
		var consola = new Scanner(System.in);

		while (!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}
	}

	private void mostrarMenu(){
		logger.info(nl);
		logger.info("""
                *** Sistema de Estudiantes ***
                
                Elige una opción a realizar:
                
                1. Listar Estudiante
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                """);
		logger.info(nl);
	}

	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opcion) {
			case 1 ->{ //Listar estudiantes
				logger.info("Listado de Estudiantes..." + nl);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));
				logger.info(nl);
			}

			case 2 ->{//Buscar Estudiante
				logger.info("Introduce el id de estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if (estudiante != null){
					logger.info("Estudiante encontrado: " + estudiante);
				} else {
					logger.info("No se encontró estudiante: ");
				}
			}

			case 3 ->{//Agregar estudiante
				logger.info("Agregar Estudiante: ");
				logger.info("Nombre :");
				var nombre = consola.nextLine();
				logger.info("Apellido :");
				var apellido = consola.nextLine();
				logger.info("Telefono :");
				var telefono = consola.nextLine();
				logger.info("Email :");
				var email = consola.nextLine();

				// Crear estudiante sin id;
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);

				estudianteServicio.guardarEstudiante(estudiante);

				logger.info("Estudiante agregado: " + estudiante);
			}

			case 4 ->{//Modificar estudiante
				logger.info("Modificar Estudiante: " + nl);
				logger.info("id Estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());

				//Buscamos estudiante a modificar
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);

				if (estudiante != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido :");
					var apellido = consola.nextLine();
					logger.info("Telefono :");
					var telefono = consola.nextLine();
					logger.info("Email :");
					var email = consola.nextLine();

					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);

					estudianteServicio.guardarEstudiante(estudiante);

					logger.info("Estudiante modificado: " + estudiante);
					logger.info(nl);
				} else {
					logger.info("Estudiante no encontrado");
				}
			}

			case 5 ->{//Eliminar estudiante
				logger.info("Eliminar Estudiante: ");
				logger.info("id Estudiante");
				var idEstudiante = Integer.parseInt(consola.nextLine());

				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);

				if (estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);

					logger.info("Estudiante Eliminado: " + estudiante);
					logger.info(nl);
				} else {
					logger.info("Estudiante no encontrado");
				}
			}

			case 6 ->{//Salir
				logger.info("Nos vemos...");
				salir = true;
			}

			default -> logger.info("Opción no valida: " + opcion);
		}//End switch

		return salir;
	}
}

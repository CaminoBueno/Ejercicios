package fp.universidades.test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import fp.universidades.Tutoria;
import fp.universidades.TutoriaImpl;

//empezar la sesion 8 (enviar lo de lasfotos pero en asignatura con nuevoalumno y eliminaalumno junto con el test)
public class TestTutoria {
	public static void main(String[] args) {
		testConstructor(DayOfWeek.MONDAY, LocalTime.of(8, 40), LocalTime.of(9, 30));
	}

	private static void testConstructor(DayOfWeek monday, LocalTime of, LocalTime of2) {
		try {
			Tutoria t = new TutoriaImpl(DayOfWeek.MONDAY, LocalTime.of(8, 40), LocalTime.of(9, 30));
			mostrarTutoria(t);
		} catch (IllegalArgumentException e) {
			System.out.println("" + e.getMessage());
		} catch (Exception e) { // este segundo catch captura la excepcion en general
								 
			System.out.println("Se ha producido una excepcion desconocida");
			System.out.println(e.getMessage());
			// e.printStackTrace(); daría la informacion de la cadena
		}
	}

	private static void mostrarTutoria(Tutoria t) {

		System.out.println("Datos de la Tutoria \"" + t + "\"");
		System.out.println("");
		System.out.println("Día de la semana: " + t.getDiaSemana());
		System.out.println("Duración: " + t.getDuracion());
		System.out.println("Hora de comienzo: " + t.getHoraComienzo());
		System.out.println("Hora de fin: " + t.getHoraFin());
	}
}

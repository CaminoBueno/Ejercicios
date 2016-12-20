package fp.universidades.test;


import fp.universidades.Beca;
import fp.universidades.TipoBeca;
import fp.universidades.BecaImpl;
import fp.universidades.Checkers;

public class TestBeca {
	public static void main(String[] args) {
		// llamadas directamente
		testConstructor("ABB2024", 1500.0, 1, TipoBeca.MOVILIDAD);
		testConstructor("ABB2024", 1000.0, 1, TipoBeca.MOVILIDAD);
		Beca b = new BecaImpl("ABB2024", 1000.0, 1, TipoBeca.MOVILIDAD);
		testSetDuracion(b, 0);
		
	}
	/*
	 * testConstructor(1); testConstructor(2); testConstructor(3);
	 * testConstructor(4); testConstructor(5); testConstructor(6);
	 * testConstructor(7); testConstructor(8); testConstructor(9);
	 * testConstructor(10);
	 */ 

	private static void testSetDuracion(Beca b, int duracion) {
		Checkers.checkNoNull(duracion);
		Checkers.check("Duración no permitida", duracion >= 1);
	
		
	}

	//objetivo crear constructor para setduracion que lo llame y rellenar el metodo try para las propiedades
	private static void testConstructor(String nombre, double creditos, int curso, TipoBeca tipo) {
		try {
			Beca b = new BecaImpl(nombre, creditos, curso, tipo);
			mostrarBeca(b);		
		} catch (IllegalArgumentException e) {
			System.out.println("" + e.getMessage());
		} catch (Exception e) {  // este segundo catch captura la excepcion en general
			System.out.println("Se ha producido una excepcion desconocida");
			System.out.println(e.getMessage()); 
			//e.printStackTrace(); daría la informacion de la cadena
		}
	}

	private static void mostrarBeca(Beca b) {
		System.out.println("Datos de la Beca \"" + b + "\"");
		System.out.println("");
	//	System.out.println(((Asignatura) b).getCreditos());
//		System.out.println(((Asignatura) b).getCurso());
		System.out.println(b.getTipo());
		System.out.println(b.getDuracion());
	}
}
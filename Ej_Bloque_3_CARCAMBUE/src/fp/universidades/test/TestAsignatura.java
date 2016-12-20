package fp.universidades.test; 

import fp.universidades.Asignatura; 
import fp.universidades.AsignaturaImpl;
import fp.universidades.TipoAsignatura;

public class TestAsignatura {
	public static void main(String[] args) {
		//casos de test:
		testConstructor(1); 	testConstructor(2); 	testConstructor(3);
		testConstructor(4); 	testConstructor(5);		testConstructor(6);
		testConstructor(7);		testConstructor(8);		testConstructor(9);
        testConstructor(10);

	}

	// Puede haber un bloque try por cada excepcion a captar
	private static void testConstructor(String nombre, String codigo, Double creditos, TipoAsignatura tipo,
			Integer curso, Integer numeroAlumnos) {
		try {
			Asignatura a = new AsignaturaImpl(nombre, codigo, creditos, tipo, curso, numeroAlumnos);
			mostrarAsignatura(a);
		} catch (IllegalArgumentException e) {
			System.out.println("" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una excepcion desconocida");
			System.out.println(e.getMessage());
		}
	}

	private static void mostrarAsignatura(Asignatura a) {

		System.out.println("Datos de la asignatura \"" + a + "\"");
		System.out.println("");
		System.out.println(a.getNombre());
		System.out.println(a.getCodigo());
		System.out.println(a.getCreditos());
		System.out.println(a.getTipo());
		System.out.println(a.getCurso());
		System.out.println(a.getnumeroAlumnos());
	}

// el switch provoca una doble llamada, es una complejidad añadida. El proximo test(beca) será sin switch
	private static void testConstructor(Integer prueba) {
		System.out.println("constructorC1, Prueba: " + prueba);
		switch (prueba) {
		case 1:
			testConstructor("Fundamentos de Programación", "1234567", 7.5, TipoAsignatura.ANUAL, 1, null);
			break;
		case 2:
			testConstructor(null, "1234567", 7.5, TipoAsignatura.ANUAL, 1, -55);
			break;
		case 3:
			testConstructor("Fundamentos de Programación", null, 7.5, TipoAsignatura.ANUAL, 1,10);
			break;
		case 4:
			testConstructor("Fundamentos de Programación", "1234567", null, TipoAsignatura.ANUAL, 1, 0);
			break;
		case 5:
			testConstructor("Fundamentos de Programación", "1234567", 7.5, null, 1, 5);
			break;
		case 6:
			testConstructor("Fundamentos de Programación", "1234567", 7.5, TipoAsignatura.ANUAL, null, 6);
			break;
		case 7:
			testConstructor("Fundamentos de Programación", "123456", 7.5, TipoAsignatura.ANUAL, 1, 7);
			break;
		case 8:
			testConstructor("Fundamentos de Programación", "12345678", 7.5, TipoAsignatura.ANUAL, 1, 8);
			break;
		case 9:
			testConstructor("Fundamentos de Programación", "1234567A", 7.5, TipoAsignatura.ANUAL, 1, 9);
			break;
		case 10:
			testConstructor("Fundamentos de Programación", "1234567", 0., TipoAsignatura.ANUAL, 1, 10);
			break;

		}
	}

}

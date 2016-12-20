package fp.universidades;

import java.util.Set;

public class AsignaturaImpl implements Asignatura {
	private String nombre;
	private String codigo;
	private Double creditos;
	private Integer curso;
	private TipoAsignatura tipo;
	private Integer numeroAlumnos;
	private Set<Persona> Alumnos;


	// Restricciones en las propiedades:
	private static final String CREDITOS = "R1: El valor de la propiedad créditos debe ser estrictamente mayor que cero.";
	private static final String CURSO = "R2: El valor de la propiedad curso debe ser estrictamente mayor que cero.";
	private static final String CODIGO = "R3: El codigo está formado por siete caracteres, todos dígitos.";

	// Los parámetros de checkNoNull se pueden declarar más tarde las
	// excepciones con "if"
	public AsignaturaImpl(String nombre, String codigo, Double creditos, TipoAsignatura tipo, Integer curso, Integer numeroAlumnos) {
		Checkers.checkNoNull(nombre, codigo, creditos, tipo, curso, numeroAlumnos);
		Checkers.check(CREDITOS, restriccionCreditos(creditos));
		Checkers.check(CURSO, restriccionCurso(curso));
		Checkers.check(CODIGO, restriccionCodigo(codigo));
		Checkers.check(codigo, PersonaImpl.restriccionnumeroAlumnos(getnumeroAlumnos()));
		this.nombre = nombre;
		this.codigo = codigo;
		this.creditos = creditos;
		this.tipo = tipo;
		this.curso = curso;
		this.numeroAlumnos = numeroAlumnos;
		
	}
	static boolean restriccionnumeroAlumnos(int numeroAlumnos) {
		return numeroAlumnos >= 1 && numeroAlumnos <= 50;

	}
//	public AsignaturaImpl(String nombre, String codigo, Double creditos, TipoAsignatura tipo, Integer curso, Integer numeroAlumnos){
//	this(nombre, codigo, creditos, tipo, curso, numeroAlumnos, new HashSet<Persona>());
	//	}
	// if (!Character.isDigit(codigo.charAt(i))) así no tengo que poner las
	// letras
	private Boolean restriccionCodigo(String codigo) {
		Boolean a = true;
		for (int i = 0; i < codigo.length(); i++) {
			if (!Character.isDigit(codigo.charAt(i))) {
				a = false;
				break;
			}
		}
		return a && codigo.length() == 7;
	}

	public String toString() {
		return "(" + getCodigo() + ") " + getNombre();
	}

	private Boolean restriccionCurso(Integer curso) {
		return curso > 0;
	}

	private Boolean restriccionCreditos(Double creditos) {
		return creditos > 0;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public Double getCreditos() {
		return creditos;
	}

	public TipoAsignatura getTipo() {
		return tipo;
	}

	public Integer getCurso() {
		return curso;
	}

	public boolean equals(Object o) {
		Boolean res = false;

		if (o instanceof Asignatura) { // discriminador temprano de igualdad de
										// tipos(hace el "casting")
			Asignatura a = (Asignatura) o;
			res = getCodigo().equals(a.getCodigo());
		}
		return res;
	}

	public int hashCode() {
		return getCodigo().hashCode() + 31 * getNombre().hashCode(); // el 31
																		// como
																		// cualquier
																		// otro
																		// numero
																		// primo
																		// se
																		// usa
																		// para
																		// diferenciar
																		// los
																		// codigos
	}

	public int compareTo(AsignaturaImpl a) {
		return getCodigo().compareTo(a.getCodigo());
	}
	public Integer getnumeroAlumnos() {
		return Alumnos.size();
	}
	public void nuevoAlumno(Persona p) {
		if (Alumnos.size() + 1 < numeroAlumnos)
			Alumnos.add(p);
		else
			throw new IllegalArgumentException();
	}

}

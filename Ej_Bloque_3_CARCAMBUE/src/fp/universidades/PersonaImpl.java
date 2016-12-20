package fp.universidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

public class PersonaImpl implements Persona {
	private String nombre;
	private String apellidos;
	private String dni;
	private LocalDate fechaNacimiento;
	private String email;
	private Integer numeroAlumnos;
	private Set<Persona> Alumnos;

	public PersonaImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, Integer numeroAlumnos, Set<Persona> Alumnos) {
		Checkers.checkNoNull(dni, numeroAlumnos);
		Checkers.check(dni, PersonaImpl.restriccionnumeroAlumnos(getnumeroAlumnos()));
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	//	this.email = email;
		this.numeroAlumnos = numeroAlumnos;
		this.Alumnos = new HashSet<Persona>(Alumnos);
	}

	static boolean restriccionnumeroAlumnos(int numeroAlumnos) {
		return numeroAlumnos >= 1;

	}

	public PersonaImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, Integer numeroAlumnos) {
		this(dni, nombre, apellidos, fechaNacimiento, numeroAlumnos, new HashSet<Persona>());
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.email = null;
	}

	public String toString() {
		return getDNI() + " - " + getApellidos() + ", " + getNombre() + " - "
				+ getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public Integer getEdad() {
		return (int) getFechaNacimiento().until(LocalDate.now(), ChronoUnit.YEARS);
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDNI() {
		return dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDNI(String dni) {
		this.dni = dni;
	}

	public void setFechaNacimiento(LocalDate fecha) {
		this.fechaNacimiento = fecha;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void eliminaAlumno(Persona p) {
		Alumnos.remove(p);
	}

	public boolean equals(Object o) {
		Boolean res = false;

		if (o instanceof Persona) { // discriminador temprano de igualdad de
									// tipos(hace el "casting")
			Persona p = (Persona) o;
			res = getDNI().equals(p.getDNI());
		}
		return res;
	}

	public int hashCode() {
		return getDNI().hashCode() + 31 * getDNI().hashCode();
	}

	public int compareTo(PersonaImpl p) {
		return getDNI().compareTo(p.getDNI());

	}
}

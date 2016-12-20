package fp.universidades;

public interface Asignatura extends Comparable<AsignaturaImpl> {

	String getNombre();

	String getCodigo();

	Double getCreditos();

	Integer getCurso();

	TipoAsignatura getTipo();

	Integer getnumeroAlumnos();
}

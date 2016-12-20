package fp.universidades;

public interface Nota {
	Asignatura getAsignatura();

	Integer getCursoAcademico();

	Convocatoria getConvocatoria();

	Double getValor();

	Boolean getMencionHonor();

	Calificacion getCalificacion();
}

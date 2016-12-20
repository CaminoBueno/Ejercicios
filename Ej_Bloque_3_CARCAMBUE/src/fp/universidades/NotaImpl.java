package fp.universidades;

public class NotaImpl implements Nota {
	private Asignatura asignatura;
	private Integer curso;
	private Convocatoria convocatoria;
	private Double valor;
	private Boolean mencionHonor;

	public NotaImpl(Asignatura asignatura, Integer curso, Convocatoria convocatoria, Double valor,
			Boolean mencionHonor) {
		this.asignatura = asignatura;
		this.curso = curso;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencionHonor = mencionHonor;
	}

	public NotaImpl(Asignatura asignatura, Integer curso, Convocatoria convocatoria, Double valor) {
		this(asignatura, curso, convocatoria, valor, false);
	}

	public String toString() {
		String aux = "" + (getCursoAcademico() + 1);
		aux = aux.substring(aux.length() - 2);
		return getAsignatura() + ", " + getCursoAcademico() + "-" + aux + ", " + getConvocatoria() + ", " + getValor()
				+ ", " + getCalificacion();
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public Integer getCursoAcademico() {
		return curso;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public Double getValor() {
		return valor;
	}

	public Calificacion getCalificacion() {
		Calificacion res = null;
		if (getValor() < 5) {
			res = Calificacion.SUSPENSO;
		} else if (getValor() < 7) {
			res = Calificacion.APROBADO;
		} else if (getValor() < 9) {
			res = Calificacion.NOTABLE;
		} else if (!getMencionHonor()) {
			res = Calificacion.SOBRESALIENTE;
		} else {
			res = Calificacion.MATRICULA_DE_HONOR;
		}
		return res;
	}

	public Boolean getMencionHonor() {
		return mencionHonor;
	}
}

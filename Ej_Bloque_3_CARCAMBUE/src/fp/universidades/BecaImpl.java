package fp.universidades;

public class BecaImpl implements Beca {
	private static final Double CUANTIA_MINIMA = 1500.0;
	private String codigo;
	private Double cuantiaTotal;
	private Integer duracion;
	private TipoBeca tipo;
	

	private static final String CODIGO = "R1: El código está formado por tres letras y cuatro dígitos.";
	private static final String CUANTIA_TOTAL = "R2: El valor de la cuantía total debe ser mayor o igual que la cuantía mínima.";
	private static final String DURACION = "R3: El valor de la duración debe ser mayor o igual que la duración minima. ";

	public BecaImpl(String codigo, TipoBeca tipo, String nombre) {
		Checkers.checkNoNull(codigo);
		Checkers.check(CODIGO, restriccionCodigo(codigo));
		this.cuantiaTotal = CUANTIA_MINIMA;
		this.codigo = codigo;
		this.tipo = tipo;
		this.duracion = 1;
	}

	private boolean restriccionCodigo(String codigo) {
		boolean esCorrecto = codigo.length() == 7 && Character.isLetter(codigo.charAt(0))
				&& Character.isLetter(codigo.charAt(1)) && Character.isLetter(codigo.charAt(2))
				&& Character.isDigit(codigo.charAt(3)) && Character.isDigit(codigo.charAt(4))
				&& Character.isDigit(codigo.charAt(5)) && Character.isDigit(codigo.charAt(6));
		return esCorrecto;

	}

	public BecaImpl(String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo) {
		Checkers.checkNoNull(codigo, tipo, cuantiaTotal, duracion);
		Checkers.check("codigo no valido", restriccionCodigo(codigo));
		Checkers.check("cuantía no permitida", cuantiaTotal >= CUANTIA_MINIMA);
		Checkers.check("duración no permitida", duracion >= 1);
		this.cuantiaTotal = cuantiaTotal;
		this.codigo = codigo;
		this.tipo = tipo;
		this.duracion = duracion;
	}

	public String toString() {
		return "[" + getCodigo() + "," + getTipo() + "]";
	}

	public Double getCuantiaTotal() {
		return cuantiaTotal;
	}

	public String getCodigo() {
		return codigo;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public TipoBeca getTipo() {
		return tipo;
	}

	public Double getCuantiaMensual() {
		Checkers.checkNoNull(cuantiaTotal);
		Checkers.check("Cuantía no valida", cuantiaTotal <= CUANTIA_MINIMA);
		return getCuantiaTotal() / getDuracion();
	}

	public void setCuantiaTotal(Double cuantiaTotal) {
		Checkers.checkNoNull(cuantiaTotal);
		Checkers.check("Cuantía no valida", cuantiaTotal <= CUANTIA_MINIMA);
		this.cuantiaTotal = cuantiaTotal;
	}

	public void setDuracion(Integer duracion) {
		Checkers.checkNoNull(duracion);
		Checkers.check("Duración no permitida", duracion >= 1);
		this.duracion = duracion;
	}


	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Beca) {
			Beca b = (Beca) o;
			res = getCodigo().equals(b.getCodigo());
		}
		return res;
	}
	public int hashCode() {
		return getCodigo().hashCode() + 31*getnombre().hashCode(); //el 31 como cualquier otro numero primo se usa para diferenciar los codigos
	}

	public int compareTo(BecaImpl b) {
		return getCodigo().compareTo(b.getCodigo());
	}

	public String getnombre() {
		return null;
	}
}

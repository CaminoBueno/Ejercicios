package fp.universidades;

public interface Beca  extends Comparable<BecaImpl>{
	String getCodigo();

	Double getCuantiaTotal();

	Integer getDuracion();

	TipoBeca getTipo();

	Double getCuantiaMensual();

	String getnombre();

	void setCuantiaTotal(Double cuantia);

	void setDuracion(Integer duracion);
}

package fp.universidades;

public interface Espacio {
	String getNombre();

	Integer getPlanta();

	Integer getCapacidad();

	TipoEspacio getTipo();

	void setNombre(String nombre);

	void setCapacidad(Integer capacidad);

	void setTipo(TipoEspacio tipo);
}

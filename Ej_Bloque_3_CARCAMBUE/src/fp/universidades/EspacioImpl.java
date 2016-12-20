package fp.universidades;

public class EspacioImpl implements Espacio {
	private String nombre;
	private Integer planta;
	private Integer capacidad;
	private TipoEspacio tipo;

	public EspacioImpl(String nombre, Integer capacidad, Integer planta, TipoEspacio tipo) {
		this.nombre = nombre;
		this.planta = planta;
		this.capacidad = capacidad;
		this.tipo = tipo;
	}

	public String toString() {
		return getNombre() + "(planta " + getPlanta() + ")";
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getPlanta() {
		return planta;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public TipoEspacio getTipo() {
		return tipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;

	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public void setTipo(TipoEspacio tipo) {
		this.tipo = tipo;
	}

}

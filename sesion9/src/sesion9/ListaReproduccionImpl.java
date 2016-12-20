package sesion9;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;

import fp.musica.Album;
import fp.musica.Cancion;

public class ListaReproduccionImpl implements ListaReproduccion {
	private String nombre;
	private List<Cancion> canciones;

	public ListaReproduccionImpl(String nombreUsuario) {
		this.nombre = nombreUsuario;
		// TODO: Inicializar propiedad canciones (lista vacía)
		this.canciones = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cancion> getCanciones() {
		// TODO: Devolver copia de la propiedad canciones
		return new ArrayList<>(canciones);

	}

	public Integer getNumeroCanciones() {
		// TODO: Devolver número de canciones en la lista
		return canciones.size();
	}

	public void aleatoriza() {
		Collections.shuffle(canciones);
	}

	public void incorpora(Cancion c) {
		// TODO: Añade la canción a la lista
		canciones.add(c);

	}

	public void incorpora(Album a) {
		// TODO: Añade todas las canciones del álbum a la lista
		canciones.addAll(a.getCanciones());
	}

	public void incorpora(List<Cancion> canciones) {
		// TODO: Añade todas las canciones a la lista
		this.canciones.addAll(canciones);
	}

	public void eliminaPrimera(Cancion c) {
		// TODO: Elimina la primera aparición de la canción c en la lista. Si no
		// existe, no hace nada.
		// indice de c dentro de canciones

		Boolean eliminada = canciones.remove(c);
		if (!eliminada)
			throw new IllegalArgumentException("La canción que se pretende eliminar no pertence a la lista");

	}

	public void eliminaUltima(Cancion c) {
		// TODO: Elimina la última aparición de la canción c en la lista. Si no
		// existe, no hace nada.
		int index = canciones.lastIndexOf(c);// posicion de la cancion
		if (index >= 0)// si está la cancion
			canciones.remove(index);// Se eliminará
		else// si no existe la cancion
			throw new IllegalArgumentException("La canción que se pretende eliminar no pertence a la lista");

	}

	public void eliminaTrozo(int primeraPosicion, int ultimaPosicion) {
		// TODO: Elimina las canciones que van desde primeraPosicion hasta
		// ultimaPosicion, ambas incluidas.
		try {
			canciones.subList(primeraPosicion, ultimaPosicion + 1).clear();
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("La primera posición no es un valor válido.");
		}
	}

	public String toString() {
		return getNombre() + " (" + getNumeroCanciones() + " canciones)";
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof ListaReproduccion) {
			ListaReproduccion l = (ListaReproduccion) o;
			res = canciones.equals(l.getCanciones());
		}
		return res;
	}

	public int hashCode() {
		return canciones.hashCode();
	}
}

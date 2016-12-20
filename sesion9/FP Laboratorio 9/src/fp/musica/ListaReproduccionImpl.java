package fp.musica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import fp.musica.Album;
import fp.musica.Cancion;

public class ListaReproduccionImpl implements ListaReproduccion {
	private String nombre;
	Integer maxCanciones;
	private List<Cancion> canciones;
aefrqa
	public ListaReproduccionImpl(String nombreUsuario) {
		this.nombre = nombreUsuario;
		// TODO: Inicializar propiedad canciones (lista vac�a)
		String[] arraynombre Usuarios = new String[];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cancion> getCanciones() {
		// TODO: Devolver copia de la propiedad canciones
		return canciones.toString;

	}

	public Integer getNumeroCanciones() {
		// TODO: Devolver n�mero de canciones en la lista
		return canciones.size();
	}

	public void aleatoriza() {
		Collections.shuffle(canciones);
	}

	public void incorpora(Cancion c) {
		// TODO: A�ade la canci�n a la lista
		canciones.addAll(c);

	}

	public void incorpora(Album a) {
		// TODO: A�ade todas las canciones del �lbum a la lista
		canciones.addAll(a);
	}

	public void incorpora(List<Cancion> canciones) {
		// TODO: A�ade todas las canciones a la lista
		canciones.addAll(List);
	}

	public void eliminaPrimera(Cancion c) {
		// TODO: Elimina la primera aparici�n de la canci�n c en la lista. Si no
		// existe, no hace nada.

		canciones.remove(canciones.indexOf(c));// indice de c dentro de
												// canciones
	}

	public void eliminaUltima(Cancion c) {
		// TODO: Elimina la �ltima aparici�n de la canci�n c en la lista. Si no
		// existe, no hace nada.
		canciones.remove(canciones.lastIndexOf(c));
	}

	public void eliminaTrozo(int primeraPosicion, int ultimaPosicion) {
		// TODO: Elimina las canciones que van desde primeraPosicion hasta
		// ultimaPosicion, ambas incluidas.
		int i = primeraPosicion;
		
		while (primeraPosicion <= ultimaPosicion){ //bucle donde se borra desde la 1 a ultima posicion de una en una
			canciones.remove(i);
			int i++;
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

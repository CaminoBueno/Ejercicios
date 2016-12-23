package fp.musica;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fp.musica.Album;
import fp.musica.Cancion;
import fp.utiles.Checkers;
import fp.utiles.Imagenes;
//ES EL EJERCIOCIO 2 BOLETIN 5

public class ListaReproduccionImpl implements ListaReproduccion {
	private String nombre;
	private List<Cancion> canciones;

	public ListaReproduccionImpl(String nombre) {
		this.nombre = nombre;
		this.canciones = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cancion> getCanciones() {
		return new ArrayList<>(canciones);
	}

	public Integer getNumeroCanciones() {
		return canciones.size();
	}

	public void aleatoriza() {
		Collections.shuffle(canciones);
	}

	public void incorpora(Cancion c) {
		canciones.add(c);
	}

	public void incorpora(Album a) {
		canciones.addAll(a.getCanciones());
	}

	public void incorpora(List<Cancion> canciones) {
		this.canciones.addAll(canciones);
	}

	public void eliminaPrimera(Cancion c) {
		Checkers.check("La canci�n que se pretende eliminar no pertenece a la lista de reproducci�n",
				canciones.contains(c));
		canciones.remove(c);
	}

	public void eliminaUltima(Cancion c) {
		Checkers.check("La canci�n que se pretende eliminar no pertenece a la lista de reproducci�n",
				canciones.contains(c));
		canciones.remove(canciones.lastIndexOf(c));
	}

	public void eliminaTrozo(int primeraPosicion, int ultimaPosicion) {
		Checkers.check("La primera posici�n no es un valor v�lido.",
				primeraPosicion >= 0 && ultimaPosicion < getNumeroCanciones() && primeraPosicion <= ultimaPosicion);
		canciones.subList(primeraPosicion, ultimaPosicion + 1).clear();
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

	/**
	 * @param parametro?
	 *            artista Nombre del artista
	 * @return Devuelve true si todas las canciones de la lista de reproducci�n
	 *         son del artista especificado.
	 */
	public Boolean esAntologia(String artista) {
		Boolean res = true;
		for (Cancion c : canciones) {
			if (!existe(artista, c.getArtistas())) {
				res = false;
				break;
			}
		}
		return res;
	}

	private Boolean existe(String nomArtista, List<Artista> artistas) {
		Boolean res = false;
		for (Artista a : artistas) {
			if (a.getNombre().equals(nomArtista)) {
				res = true;
				break;
			}
		}
		return res;
	}

	/**
	 * @return Devuelve la duraci�n total de la lista de reproducci�n
	 */
	public Duration getDuracion() {
		Duration res = Duration.ZERO;
		for (Cancion c : canciones) {
			res = res.plus(c.getDuracion());
		}
		return res;
	}

	/**
	 * @param artista
	 *            Nombre del artista
	 * @return Devuelve true si existe alguna canci�n en la lista de
	 *         reproducci�n del artista dado como par�metro.
	 */
	public Boolean contieneArtista(String artista) {
		Boolean res = false;
		for (Cancion c : canciones) {
			if (existe(artista, c.getArtistas())) {
				res = true;
				break;
			}
		}
		return res;
	}

	/**
	 * @param artista
	 *            Nombre del artista
	 * @return Devuelve una nueva lista de reproducci�n que contenga todas las
	 *         canciones del artista dado como par�metro.
	 */
	public ListaReproduccion getSublistaArtista(String artista) {
		ListaReproduccion res= new ListaReproduccionImpl(artista);
			for (Cancion c : canciones){
				if (existe(artista, c.getArtistas())){
					res.incorpora(c);
				}
			}
		return res;
	}

	/**
	 * @return Devuelve el conjunto de artistas de la lista de reproducci�n.
	 */
	public Set<Artista> getArtistas() {
		Set<Artista> res = new HashSet<>();
		for (Cancion c : canciones) {
			res.addAll(c.getArtistas());
		}
		return res;
	}

	/**
	 * Muestra las fotos de los artistas que aparecen en la lista
	 */
	public void muestraFotosArtistas() {
		for (Artista a : getArtistas()) {
			if (!a.getURLImagenes().isEmpty()) {
				Imagenes.show(a.getNombre(), a.getURLImagenes().get(0));
			}
		}
	}

	//  para resolver en casa

	/**
	 * @param tituloCancion
	 *            Titulo de una canci�n.
	 * @return Devuelve la posici�n (�ndice) que ocupa en la lista de
	 *         reproducci�n la primera canci�n cuyo t�tulo se especifica. Si la
	 *         canci�n no est� en la lista de reproducci�n, devuelve -1.
	 * 
	 */
	public int getPosicionCancion(String tituloCancion) {
		int res = -1, i = 0;
		for (Cancion c : canciones) {
			if (c.getNombre().equals(tituloCancion)) {
				res = i;
				break;
			} else {
				i++;
			}
		}
		return res;
	}

	/**
	 * @return Devuelve la canci�n con mayor duraci�n de la lista de
	 *         reproducci�n. Si no hay ninguna canci�n en la lista, devuelve
	 *         null.
	 */
	public Cancion getCancionMasLarga() {
		Cancion res = null;
		for (Cancion c : canciones){
			if(res == null || c.getDuracion().compareTo(res.getDuracion()) > 0){
				res = c;
			}
		}
		return res;
	}

	/**
	 * @return Devuelve la canci�n con menor duraci�n de la lista de
	 *         reproducci�n. Si no hay ninguna canci�n en la lista, devuelve
	 *         null.
	 */
	public Cancion getCancionMasCorta() {
		Cancion res = null;
		for (Cancion c : canciones) {
			if (res == null || c.getDuracion().compareTo(res.getDuracion()) < 0) {
				res = c;
			}
		}
		return res;
	}

	@Override
	public Integer getCancionesPopularidad(Integer popularidad) {
		// TODO Auto-generated method stub
		return popularidad;
	}


}

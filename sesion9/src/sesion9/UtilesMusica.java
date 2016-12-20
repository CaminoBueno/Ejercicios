package sesion9;

import java.util.List;

import fp.musica.Album;
import fp.musica.Artista;
import fp.musica.Cancion;
import fp.musica.ClienteSpotify;
import fp.utiles.Musica;

public class UtilesMusica {

	// TODO: Devuelve una lista de reproducci�n con, como m�ximo, maxCanciones
	// del artista
	public static ListaReproduccion generaListaReproduccion(String artista, int maxCanciones, ClienteSpotify cliente) {
		/*
		 * Para hacer consultas a Spotify, usar los m�todos del par�metro
		 * cliente
		 */
		List<Artista> artistas = cliente.getArtistas(artista);
		ListaReproduccion lista = new ListaReproduccionImpl(artista);

		if (!artistas.isEmpty()) {
			List<Album> albumes = cliente.getAlbumesArtista(artistas.get(0).getId());
			for (Album a : albumes) {
				lista.incorpora(a);
			}
			lista.aleatoriza();
			if (lista.getNumeroCanciones() > maxCanciones) {
				lista.eliminaTrozo(maxCanciones, lista.getNumeroCanciones() - 1);

			}
		}
		return lista;
	}

	public static void reproduceListaReproduccion(ListaReproduccion lista) {
		for (Cancion c : lista.getCanciones()) {
			System.out.println("Reproduciendo " + c.getNombre() + "...");
			Musica.reproduceMP3(c.getURLPreescucha(), 5);
		}
	}
}

/*
 * El m�todo devuelve una lista de reproducci�n con, como m�ximo, maxCanciones
 * del artista especificado. Utilice el m�todo getArtistas de ClienteSpotify3
 * para obtener una lista de artistas para el nombre especificado. Despu�s
 * utilice el m�todo getAlbumesArtista de ClienteSpotify para obtener los
 * �lbumes del artista que ocupa la primera posici�n de la lista anterior. Este
 * �ltimo m�todo recibe el id del artista para el que se quieren obtener los
 * �lbumes. A�ada todas las canciones de todos los �lbumes obtenidos a una lista
 * de reproducci�n, aleatorice el orden de las canciones y finalmente recorte el
 * trozo necesario para cumplir con la especificaci�n del m�todo. c) A�ada una
 * clase TestListaReproduccion al paquete fp.musica.test. En el m�todo main de
 * dicha clase, cree dos listas de reproducci�n usando el m�todo
 * generaListaReproduccion, para los dos artistas que desee, cada una con 10
 * canciones. Cree una nueva lista de reproducci�n y a��dale las canciones de
 * las dos listas anteriores. Finalmente, aleatorice esta �ltima lista y muestre
 * las canciones que la forman por pantalla.
 */

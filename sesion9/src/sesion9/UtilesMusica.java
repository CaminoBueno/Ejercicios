package sesion9;

import java.util.List;

import fp.musica.Album;
import fp.musica.Artista;
import fp.musica.Cancion;
import fp.musica.ClienteSpotify;
import fp.utiles.Musica;

public class UtilesMusica {

	// TODO: Devuelve una lista de reproducción con, como máximo, maxCanciones
	// del artista
	public static ListaReproduccion generaListaReproduccion(String artista, int maxCanciones, ClienteSpotify cliente) {
		/*
		 * Para hacer consultas a Spotify, usar los métodos del parámetro
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
 * El método devuelve una lista de reproducción con, como máximo, maxCanciones
 * del artista especificado. Utilice el método getArtistas de ClienteSpotify3
 * para obtener una lista de artistas para el nombre especificado. Después
 * utilice el método getAlbumesArtista de ClienteSpotify para obtener los
 * álbumes del artista que ocupa la primera posición de la lista anterior. Este
 * último método recibe el id del artista para el que se quieren obtener los
 * álbumes. Añada todas las canciones de todos los álbumes obtenidos a una lista
 * de reproducción, aleatorice el orden de las canciones y finalmente recorte el
 * trozo necesario para cumplir con la especificación del método. c) Añada una
 * clase TestListaReproduccion al paquete fp.musica.test. En el método main de
 * dicha clase, cree dos listas de reproducción usando el método
 * generaListaReproduccion, para los dos artistas que desee, cada una con 10
 * canciones. Cree una nueva lista de reproducción y añádale las canciones de
 * las dos listas anteriores. Finalmente, aleatorice esta última lista y muestre
 * las canciones que la forman por pantalla.
 */

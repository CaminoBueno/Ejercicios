package sesion9;

import java.time.Duration;

import fp.musica.Cancion;
import fp.musica.ClienteSpotify;

public class TestListaReproduccion {

	public static void main(String[] args) {
		/*
		 * Instanciamos un objeto de tipo ClienteSpotify para poder hacer
		 * consultas a Spotify
		 */
		ClienteSpotify cliente = new ClienteSpotify();

		ListaReproduccion lista = UtilesMusica.generaListaReproduccion("David Guetta", 10, cliente);
		lista.setNombre("Varios: David Guetta");
		lista.getCanciones();

		ListaReproduccion lista2 = UtilesMusica.generaListaReproduccion("Portishead", 10, cliente);
		lista2.setNombre("Varios: Portishead");
        // TODO: Crear una lista combinando las dos listas anteriores,
		// aleatorizarla y mostrarla en la consola
		ListaReproduccion listaCombinada = UtilesMusica.generaListaReproduccion("David G. y Portis", 20, cliente);
		listaCombinada.setNombre("Combinada");
		listaCombinada.incorpora(lista.getCanciones());
		listaCombinada.aleatoriza();
		listaCombinada.incorpora(lista2.getCanciones());
		listaCombinada.aleatoriza();
		muestra(listaCombinada);
		UtilesMusica.reproduceListaReproduccion(listaCombinada);
		cliente.cierra();
	}

	private static void muestra(ListaReproduccion l) {
		System.out.println("Lista de reproducción: " + l);
		System.out.println("===========================================================================================");
		for (Cancion c:l.getCanciones()) {
			System.out.println(artistasSeparadosPorComas(c) + " - " + c.getNombre() + " ("
					+ duracionEnMinutosSegundos(c.getDuracion()) + ")");
		}
	}

	private static String duracionEnMinutosSegundos(Duration duracion) {
		String res = duracion.getSeconds() / 60 + ":";
		long segundos = duracion.getSeconds() % 60;
		if (segundos < 15) {
			res += "0";
		}
		return res + segundos;
	}

	private static String artistasSeparadosPorComas(Cancion c) {
		String s = c.getArtistas().get(0).getNombre();
		for (int i = 1; i < c.getArtistas().size(); i++) {
			s += ", " + c.getArtistas().get(i).getNombre();
		}
		return s;
	}

}

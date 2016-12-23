package fp.musica.test;

import java.time.Duration; 
import java.time.temporal.ChronoUnit;

import fp.musica.ListaReproduccion;
import fp.musica.ListaReproduccionImpl;
import fp.musica.UtilesMusica;
import fp.musica.Cancion;
import fp.musica.ClienteSpotify;

public class TestListaReproduccion {

	public static void main(String[] args) {
		ClienteSpotify cliente = new ClienteSpotify();
		
		ListaReproduccion lista1=UtilesMusica.generaListaDiscografia("The Weeknd", cliente);
		System.out.println("Lista 1: "+lista1);
		testTratamientosSecuenciales(lista1);	
				
		ListaReproduccion lista2=UtilesMusica.generaListaReproduccion(new String[]{"Pink Floyd","Muse","Led Zeppelin","Depeche Mode"}, 10, cliente);		
		System.out.println("\n\nLista 2: "+lista2);
		testTratamientosSecuenciales(lista2);		
		
		
		System.out.println("\n\nMostrando ambas listas de reproducción...");
		muestra(lista1);
		
		System.out.println("\n");
		muestra(lista2);
		cliente.cierra();
	}
	

	
	private static void testTratamientosSecuenciales(ListaReproduccion lista) {
		System.out.println("¿Es antología de The Weeknd?: "+lista.esAntologia("The Weeknd"));
		System.out.println("Duración de la lista: "+lista.getDuracion());
		System.out.println("¿Contiene canciones de Daft Punk?: "+lista.contieneArtista("Daft Punk"));		
		System.out.println("Artistas que aparecen en la lista: "+lista.getArtistas());
		System.out.println("Sublista con las canciones de la lista de Daft Punk: "+lista.getSublistaArtista("Daft Punk"));
		System.out.println("Mostrando fotos de los artistas de la lista...");
		lista.muestraFotosArtistas();
		System.out.println("Posicion que ocupa la canción \"False Alarm\": "+lista.getPosicionCancion("False Alarm"));
		System.out.println("Canción más larga: "+lista.getCancionMasLarga());
		System.out.println("Canción más corta: "+lista.getCancionMasCorta());
	}



	private static void muestra(ListaReproduccion l){
		System.out.println("Lista de reproducción: "+l);
		System.out.println("===========================================================================================");
		for(Cancion c:l.getCanciones()){
			System.out.println(artistasSeparadosPorComas(c) + " - " + c.getNombre()+" ("+duracionEnMinutosSegundos(c.getDuracion())+")");
		}
	}

	private static String duracionEnMinutosSegundos(Duration duracion) {
		String res = duracion.getSeconds()/60+":";
		long segundos = duracion.getSeconds()%60;
		if(segundos<10){
			res+="0";
		}		
		return res+segundos;
	}

	private static String artistasSeparadosPorComas(Cancion c) {
		String s = c.getArtistas().get(0).getNombre();
		for(int i = 1; i<c.getArtistas().size();i++){
			s+=", "+c.getArtistas().get(i).getNombre();
		}
		return s;
	}
	
}

package fp.musica;

import java.time.Duration; 
import java.util.List;
import java.util.Set;

import fp.musica.Album;
import fp.musica.Cancion;

public interface ListaReproduccion {
	String getNombre();

	void setNombre(String nombre);

	List<Cancion> getCanciones();

	Integer getNumeroCanciones();
	
	Integer getCancionesPopularidad(Integer popularidad);

	void aleatoriza();

	void incorpora(Cancion c);

	void incorpora(Album a);

	void incorpora(List<Cancion> canciones);

	void eliminaPrimera(Cancion c);

	void eliminaUltima(Cancion c);

	void eliminaTrozo(int primeraPosicion, int ultimaPosicion);

	Boolean esAntologia(String artista);

	Duration getDuracion();

	Boolean contieneArtista(String artista);

	ListaReproduccion getSublistaArtista(String artista);

	int getPosicionCancion(String tituloCancion);

	Cancion getCancionMasLarga(); 
	
	Cancion getCancionMasCorta();
	
	Set<Artista> getArtistas(); 

	void muestraFotosArtistas();
}
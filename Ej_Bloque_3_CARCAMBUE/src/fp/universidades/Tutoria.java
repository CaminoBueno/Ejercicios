package fp.universidades;

import java.time.DayOfWeek; 
import java.time.Duration;
import java.time.LocalTime;

public interface Tutoria extends Comparable<TutoriaImpl>{
	LocalTime getHoraComienzo();

	LocalTime getHoraFin();

	Duration getDuracion();

	DayOfWeek getDiaSemana();
}

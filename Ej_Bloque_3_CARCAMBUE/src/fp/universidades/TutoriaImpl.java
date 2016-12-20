package fp.universidades;

import java.time.DayOfWeek; 
import java.time.Duration;
import java.time.LocalTime;

public class TutoriaImpl implements Tutoria {
	private LocalTime horaComienzo;
	private LocalTime horaFin;
	private DayOfWeek dia;

	public TutoriaImpl(DayOfWeek dia, LocalTime horaFin, LocalTime horaInicio) {
		this.horaComienzo = horaInicio;
		this.horaFin = horaFin;
		this.dia = dia;
	}

	public TutoriaImpl(LocalTime horaInicio, Duration duracion, DayOfWeek dia) {
		this.horaComienzo = horaInicio;
		this.horaFin = horaInicio.plusMinutes(duracion.toMinutes());
		this.dia = dia;
	}

	public String toString() {
		return getDiaCharacter() + " " + getHoraComienzo() + "-" + getHoraFin();
	}

	public LocalTime getHoraComienzo() {
		
		return horaComienzo;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public Duration getDuracion() {
		return Duration.between(horaComienzo, horaFin);
	}

	public DayOfWeek getDiaSemana() {
		return dia;
	}

	private Character getDiaCharacter() {
		Character res = null;

		switch (getDiaSemana()) {
		case MONDAY:
			res = 'L';
			break;
		case TUESDAY:
			res = 'M';
			break;
		case WEDNESDAY:
			res = 'X';
			break;
		case THURSDAY:
			res = 'J';
			break;
		case FRIDAY:
			res = 'V';
			break;
		default:
			res = '?';
		}

		return res;
	}
	public boolean equals(Object o){
		Boolean res = false;
		
		if(o instanceof Tutoria){  //discriminador temprano de igualdad de tipos(hace el "casting")
		Tutoria t = (Tutoria) o;
		res = getHoraComienzo().equals(t.getHoraComienzo())
				&& getDiaSemana().equals(t.getDiaSemana());
		}
		return res;
	}
	public int hashCode() {
		return getHoraComienzo().hashCode() + 31*getDiaSemana().hashCode(); //el 31 como cualquier otro numero primo se usa para diferenciar los codigos
	}

	public int compareTo(TutoriaImpl t) {
		int res = getDiaSemana().compareTo(t.getDiaSemana());
			if (res == 0){
				res = getHoraComienzo().compareTo(t.getHoraComienzo());
			}
			return res;
	}

	
}
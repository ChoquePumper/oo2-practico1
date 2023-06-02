package oo2.practico1.ejercicio1;

import java.time.LocalDateTime;
import java.util.ArrayList;

import oo2.practico1.ejercicio1.exceptions.FueraDeTerminoException;

public class Concurso {

	private ArrayList<Participante> participantes;
	private LocalDateTime fechaDeInicioInscripcion;
	private LocalDateTime fechaDeFinInscripcion;
	// Cache
	private LocalDateTime cacheFechaLimitePrimerDia;

	public Concurso(LocalDateTime fechaDeInicio, LocalDateTime fechaDeFin) {
		this.fechaDeInicioInscripcion = fechaDeInicio;
		this.fechaDeFinInscripcion = fechaDeFin;
		this.participantes = new ArrayList<Participante>();

		this.cacheFechaLimitePrimerDia = fechaDeInicio.plusDays(1);
	}

	private void agregarParticipante(Participante participante) {
		participantes.add(participante);
	}

	public void inscribirParticipante(Participante participante, LocalDateTime fecha) throws FueraDeTerminoException {
		if (!enElPeriodoDeInscripcion(fecha))
			throw new FueraDeTerminoException();

		agregarParticipante(participante);

		if (enPrimerDia(fecha))
			participante.agregarPuntos(+10);

		// [29/03/2023] TODO: Enviar mail aquí? Sí. (si puede grabar)
	}

	boolean enPrimerDia(LocalDateTime fecha) {
		// fechaDeInicio <= fecha < cacheFechaLimitePrimerDia
		return (!fecha.isBefore(fechaDeInicioInscripcion)) && fecha.isBefore(cacheFechaLimitePrimerDia);
	}

	boolean enElPeriodoDeInscripcion(LocalDateTime fecha) {
		// fechaDeInicio <= fecha < fechaDeFin
		return (!fecha.isBefore(fechaDeInicioInscripcion)) && fecha.isBefore(fechaDeFinInscripcion);
	}
}

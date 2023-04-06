package oo2.practico1.ejercicio1;

import java.time.LocalDateTime;
import java.util.ArrayList;

import oo2.practico1.ejercicio1.exceptions.FueraDeTerminoException;

public class Concurso {

	private ArrayList<Participante> participantes;
	private LocalDateTime fechaDeInicio;
	private LocalDateTime fechaDeFin;
	// Cache
	private LocalDateTime cacheFechaLimitePrimerDia;

	public Concurso(LocalDateTime fechaDeInicio, LocalDateTime fechaDeFin) {
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFin = fechaDeFin;
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

		// [29/03/2023] Enviar mail aquí? Sí. (si puede grabar)
	}

	public boolean enPrimerDia(LocalDateTime fecha) {
		// fechaDeInicio <= fecha < cacheFechaLimitePrimerDia
		return (!fecha.isBefore(fechaDeInicio)) && fecha.isBefore(cacheFechaLimitePrimerDia);
	}

	public boolean enElPeriodoDeInscripcion(LocalDateTime fecha) {
		// fechaDeInicio <= fecha < fechaDeFin
		return (!fecha.isBefore(fechaDeInicio)) && fecha.isBefore(fechaDeFin);
	}
}

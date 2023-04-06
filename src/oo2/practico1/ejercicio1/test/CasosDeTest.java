package oo2.practico1.ejercicio1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import oo2.practico1.ejercicio1.Concurso;
import oo2.practico1.ejercicio1.Participante;
import oo2.practico1.ejercicio1.exceptions.FueraDeTerminoException;

class CasosDeTest {

	// Un participante se inscribe en un concurso
	@Test
	void inscribirEnConcurso() {
		LocalDateTime fecha_inicio = LocalDateTime.of(2023, 01, 18, 0, 0, 0);
		LocalDateTime fecha_fin = LocalDateTime.of(2023, 01, 26, 0, 0, 0);
		Concurso concurso = new Concurso(fecha_inicio, fecha_fin);

		record RecordInscribir(Participante participante, LocalDateTime fecha, boolean resultadoEsperado) {

		}
		;

		RecordInscribir pruebas[] = {
				new RecordInscribir(new Participante("Aaaaaa"), LocalDateTime.of(2023, 01, 23, 0, 0, 0), true),
				new RecordInscribir(new Participante("JustoAFuera"), LocalDateTime.of(2023, 01, 26, 0, 0, 0), false),
				new RecordInscribir(new Participante("AntesDeFin"), LocalDateTime.of(2023, 01, 25, 23, 59, 59), true),
				new RecordInscribir(new Participante("AlPrincipio"), LocalDateTime.of(2023, 01, 18, 0, 0, 0), true),
				new RecordInscribir(new Participante("MuyAntes"), LocalDateTime.of(2023, 01, 17, 23, 59, 59), false), };

		for (RecordInscribir inscripcion : pruebas) {
			assertEquals(inscribir(concurso, inscripcion.participante(), inscripcion.fecha()),
					inscripcion.resultadoEsperado());
		}
	}

	boolean inscribir(Concurso concurso, Participante participante, LocalDateTime fecha) {
		try {
			concurso.inscribirParticipante(participante, fecha);
			return true;
		} catch (FueraDeTerminoException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	// Un participante se inscribe en un concurso el primer día de abierta la
	// inscripción.
	@Test
	void primerDia() {
		LocalDateTime fecha_inicio = LocalDateTime.of(2023, 01, 18, 0, 0, 0);
		LocalDateTime fecha_fin = LocalDateTime.of(2023, 01, 26, 0, 0, 0);
		Concurso concurso = new Concurso(fecha_inicio, fecha_fin);

		record RecordPrimerDia(Participante participante, LocalDateTime fecha, int puntos) {

		}
		;
		RecordPrimerDia pruebas[] = {
				new RecordPrimerDia(new Participante("ATiempo"), LocalDateTime.of(2023, 01, 18, 12, 10, 30), 10),
				new RecordPrimerDia(new Participante("JustoAFuera"), LocalDateTime.of(2023, 01, 19, 0, 0, 0), 0),
				new RecordPrimerDia(new Participante("AntesDeFin"), LocalDateTime.of(2023, 01, 18, 23, 59, 59), 10),
				new RecordPrimerDia(new Participante("AlPrincipio"), LocalDateTime.of(2023, 01, 18, 0, 0, 0), 10) };

		for (RecordPrimerDia inscripcion : pruebas) {
			assert inscribir(concurso, inscripcion.participante(), inscripcion.fecha());
			assertEquals(inscripcion.participante().getPuntos(), inscripcion.puntos());
		}
	}

	// Un participante intenta inscribirse fuera del rango de inscripción.
	@Test
	void fueraDeRango() {

	}
}

package oo2.practico1.ejercicio1.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import oo2.practico1.ejercicio1.Concurso;

class TestFechas {

	@Test
	void enElPeriodoDeInscripcion() {
		LocalDateTime fecha_inicio = LocalDateTime.of(2023, 01, 23, 0, 0, 0);
		LocalDateTime fecha_fin = LocalDateTime.of(2023, 01, 30, 0, 0, 0);

		Concurso concurso = new Concurso(fecha_inicio, fecha_fin);
		for (int dia = 23; dia <= 29; dia++)
			assertEquals(concurso.enElPeriodoDeInscripcion(LocalDateTime.of(2023, 01, dia, 0, 0, 0)), true);
		assertEquals(concurso.enElPeriodoDeInscripcion(LocalDateTime.of(2023, 01, 30, 0, 0, 0)), false);
		assertEquals(concurso.enElPeriodoDeInscripcion(LocalDateTime.of(2023, 01, 22, 23, 59, 59)), false);
	}

	@Test
	void primerDia() {
		LocalDateTime fecha_inicio = LocalDateTime.of(2023, 01, 23, 0, 0, 0);
		LocalDateTime fecha_fin = LocalDateTime.of(2023, 01, 30, 0, 0, 0);

		LocalDateTime fecha1erDia = LocalDateTime.of(2023, 01, 23, 0, 0, 0);
		LocalDateTime otraFecha = LocalDateTime.of(2023, 01, 27, 0, 0, 0);
		LocalDateTime fechaAntes = LocalDateTime.of(2023, 01, 21, 0, 0, 0);

		Concurso concurso = new Concurso(fecha_inicio, fecha_fin);
		assertEquals(concurso.enPrimerDia(fecha1erDia), true);
		assertEquals(concurso.enPrimerDia(otraFecha), false);
		assertEquals(concurso.enPrimerDia(fechaAntes), false);
	}

}

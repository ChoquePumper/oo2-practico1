package oo2.practico1.ejercicio2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import oo2.practico1.ejercicio2.Bebida;
import oo2.practico1.ejercicio2.OpcionesPropina;
import oo2.practico1.ejercicio2.Pedido;
import oo2.practico1.ejercicio2.PlatoPrincipal;
import oo2.practico1.ejercicio2.TarjetaVisa;

class TestTarjetas {

	@Test
	void test() {
		// fail("Not yet implemented");
	}

	@Test
	void tarjetaVisa() {
		Pedido pedido = new Pedido();

		pedido.agregarAlPedido(new Bebida("Bebida AAA", 30));
		pedido.agregarAlPedido(new PlatoPrincipal("Plato AAA", 160));
		pedido.agregarAlPedido(new Bebida("Bebida BBB", 20));

		pedido.registrarTarjeta(new TarjetaVisa());

		// 30 + 20 = 50 (bebidas)
		// + 160 = 210 (plato principal)
		assertEquals(210f, pedido.calcularCostoSinDescuento());

		// bebidas * 3% = 1.5
		assertEquals(1.5f, pedido.calcularDescuento());

		// 210 - 1.5 = 208.5

		// 208.5 * 2% = 4.17
		pedido.seleccionarPropina(OpcionesPropina.opciones_posibles.PROPINA_2PC.toString());
		assertEquals(4.17f, pedido.calcularPropina());
		assertEquals(212.67f, pedido.calcularCosto());

	}

}

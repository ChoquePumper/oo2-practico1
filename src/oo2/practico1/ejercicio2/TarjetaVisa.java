package oo2.practico1.ejercicio2;

// Los pagos con tarjeta de crédito Visa tienen un descuento del 3% sobre el
// costo total de las bebidas.

public class TarjetaVisa implements TarjetaDeCredito {
	static final Porcentaje PC_DESCUENTO_POR_BEBIDA = new Porcentaje(3);

	// TODO: 3% de descuento en bebidas
	@Override
	public float calcularDescuento(ListaComidas comidas) {
		float suma_costo = 0;
		for (Comida comida : comidas.soloBebidas())
			suma_costo += comida.getCosto();
		return PC_DESCUENTO_POR_BEBIDA.calcular(suma_costo);
	}
}

package oo2.practico1.ejercicio2;

public class TarjetaVisa implements TarjetaDeCredito {
	static final float PC_DESCUENTO_POR_BEBIDA = 3;

	// TODO: 3% de descuento en bebidas
	public float calcularDescuento(ListaComidas comidas) {
		float suma_costo = 0;
		for (Comida comida : comidas.soloBebidas())
			suma_costo += comida.getCosto();
		return suma_costo * PC_DESCUENTO_POR_BEBIDA / 100;
	}
}

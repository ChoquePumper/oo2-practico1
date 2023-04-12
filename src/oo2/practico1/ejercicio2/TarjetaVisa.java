package oo2.practico1.ejercicio2;

public class TarjetaVisa implements TarjetaDeCredito {
	static final Porcentaje PC_DESCUENTO_POR_BEBIDA = new Porcentaje(3);

	// TODO: 3% de descuento en bebidas
	public float calcularDescuento(ListaComidas comidas) {
		float suma_costo = 0;
		for (Comida comida : comidas.soloBebidas())
			suma_costo += comida.getCosto();
		return PC_DESCUENTO_POR_BEBIDA.calcular(suma_costo);
	}
}

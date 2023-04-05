package oo2.practico1.ejercicio2;

public class TarjetaMastercard implements TarjetaDeCredito {
	static final float PC_DESCUENTO_POR_PLATO_PRINCIPAL = 2;

	@Override
	public float calcularDescuento(ListaComidas comidas) {
		float suma_costo = 0;
		for (Comida comida : comidas.soloPlatosPrincipales())
			suma_costo += comida.getCosto();
		return suma_costo * PC_DESCUENTO_POR_PLATO_PRINCIPAL / 100;
	}
	// TODO: 2% de descuento en Platos Principales
}

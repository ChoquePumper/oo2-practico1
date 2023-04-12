package oo2.practico1.ejercicio2;

public class TarjetaMastercard implements TarjetaDeCredito {
	static final Porcentaje PC_DESCUENTO_POR_PLATO_PRINCIPAL = new Porcentaje(2);

	@Override
	public float calcularDescuento(ListaComidas comidas) {
		float suma_costo = 0;
		for (Comida comida : comidas.soloPlatosPrincipales())
			suma_costo += comida.getCosto();
		return PC_DESCUENTO_POR_PLATO_PRINCIPAL.calcular(suma_costo);
	}
	// TODO: 2% de descuento en Platos Principales
}

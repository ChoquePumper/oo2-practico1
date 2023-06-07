package oo2.practico1.ejercicio2;

// Los pagos con tarjeta de crédito Comarca Plus tienen un descuento del 2%
// sobre el costo total (bebidas + platos principales).

public class TarjetaComarcaPlus implements TarjetaDeCredito {
	static final Porcentaje PC_DESCUENTO_DE_COSTO_TOTAL = new Porcentaje(2);

	@Override
	public float calcularDescuento(ListaComidas comidas) {
		float suma = 0;
		for (Comida comida : comidas)
			suma += comida.getCosto();
		return PC_DESCUENTO_DE_COSTO_TOTAL.calcular(suma);
	}

	// TODO: 2% del costo total (bebidas + platos principales)
}

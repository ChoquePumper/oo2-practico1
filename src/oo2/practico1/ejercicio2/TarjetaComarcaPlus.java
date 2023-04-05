package oo2.practico1.ejercicio2;

public class TarjetaComarcaPlus implements TarjetaDeCredito {

	@Override
	public float calcularDescuento(ListaComidas comidas) {
		float suma = 0;
		for (Comida comida : comidas)
			suma += comida.getCosto();
		return suma;
	}

	// TODO: 2% del costo total (bebidas + platos principales)
}

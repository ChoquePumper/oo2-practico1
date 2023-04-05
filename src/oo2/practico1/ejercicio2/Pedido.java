package oo2.practico1.ejercicio2;

import java.util.ArrayList;

public class Pedido {

	private ListaComidas lista_comidas;
	private TarjetaDeCredito tarjeta;
//	private float propina;

	public Pedido() {
		this.tarjeta = null;
		this.lista_comidas = new ListaComidas();
		// this.seleccion_propina = crearListaDePropinas();
	}

	public void agregarAlPedido(Comida comida) {
		lista_comidas.agregar(comida);
	}

	public void registrarTarjeta(TarjetaDeCredito tarjeta) {
		this.tarjeta = tarjeta;
	}

//	public void seleccionarPropina(Propina propina) {
//		Float f_propina = this.seleccion_propina.get(propina);
//		assert (f_propina == null) : null;
//
//		if (f_propina == null)
//			throw new RuntimeException("Elección de propina inválida: " + propina);
//
//		setPropina(f_propina);
//	}

	public float calcularDescuento() {
		if (tarjeta == null)
			return 0;

//		float total_bebidas = 0;
//		float total_platos_principales = 0;
//		for (Comida bebida : lista_comidas.soloBebidas())
//			total_bebidas += bebida.getCosto();
//		for (Comida plato_principal : lista_comidas.soloPlatosPrincipales())
//			total_platos_principales += plato_principal.getCosto();
//
//		return total_bebidas * tarjeta.getDescuentoPorBebida() / 100
//				+ total_platos_principales * tarjeta.getDescuentoPorPlatoPrincipal() / 100;
		float descuento_por_tarjeta = tarjeta.calcularDescuento(lista_comidas);
		return descuento_por_tarjeta;
	}

	public float calcularCosto() {
		float suma_costo = 0;
		ArrayList<Comida> lista = new ArrayList<Comida>();
		lista.addAll(lista_comidas.soloBebidas());
		lista.addAll(lista_comidas.soloPlatosPrincipales());
		for (Comida comida : lista)
			suma_costo += comida.getCosto();
		return suma_costo;
	}

	public float calcularPropina() {
		// TODO: implementar
		return 0;
	}

//	private void setPropina(float porcentaje) {
//		this.propina = porcentaje;
//	}

}

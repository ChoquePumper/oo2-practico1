package oo2.practico1.ejercicio2;

import java.util.HashMap;

public class Restaurante {
	// TODO: agregar mesas
	private HashMap<String, Mesa> mesas;

	public Restaurante() {
		this.mesas = new HashMap<String, Mesa>();
	}

	public void agregarMesa(Mesa mesa) {
		if (yaSeAgregoLaMesa(mesa))
			throw new RuntimeException(
					String.format("Ya existe una mesa con el identificador '%s'", mesa.getIdentificador()));
	}

	private boolean yaSeAgregoLaMesa(Mesa mesa) {
		return this.mesas.containsKey(mesa.getIdentificador());
	}

}

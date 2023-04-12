package oo2.practico1.ejercicio2;

import java.util.Objects;

public class Mesa {
	private float suma_de_costo;
	private String identificador;

	public Mesa(String identificador) {
		Objects.requireNonNull(identificador);
		assert identificador.isBlank() : "Identificador de mesa en blanco.";

		this.identificador = identificador;
		this.suma_de_costo = 0;
	}

	public String getIdentificador() {
		return this.identificador;
	}

}

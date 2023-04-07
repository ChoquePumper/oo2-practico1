package oo2.practico1.ejercicio2;

public class Propina {
	static enum opciones_posibles {
		PROPINA_2PC, PROPINA_5PC, PROPINA_10PC
	};

	private float porcentaje;

	public Propina(float porcentaje) {
		if (porcentaje <= 0)
			throw new RuntimeException("Porcentaje inválido.");
		this.porcentaje = porcentaje;
	}

	public float calcular(float monto) {
		return monto * this.porcentaje / 100;
	}

	public String toString() {
		return String.format("Propina(%.1f%%)", porcentaje);
	}

}
package oo2.practico1.ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaComidas implements Iterable<Comida> {

//	private ArrayList<PlatoPrincipal> platos_principales;
//	private ArrayList<Bebida> bebidas;
	private ArrayList<Comida> comidas;
	// private Map<Propina, Float> seleccion_propina;

	public ListaComidas() {
		this.comidas = new ArrayList<Comida>();
	}

	List<Comida> soloBebidas() {
		ArrayList<Comida> lista = new ArrayList<Comida>();
		for (Comida comida : comidas)
			comida.soloBebidas(lista);
		return lista;
	}

	List<Comida> soloPlatosPrincipales() {
		ArrayList<Comida> lista = new ArrayList<Comida>();
		for (Comida comida : comidas)
			comida.soloPlatosPrincipales(lista);
		return lista;
	}

	public void agregar(Comida comida) {
		this.comidas.add(comida);
	}

	@Override
	public Iterator<Comida> iterator() {
		return comidas.iterator();
	}

}

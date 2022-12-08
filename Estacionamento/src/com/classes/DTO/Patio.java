package com.classes.DTO;

import java.util.ArrayList;
import java.util.List;

public class Patio extends Vaga {

	private List<Vaga> lista = new ArrayList<Vaga>();

	public String mostraLista() {
		
		return lista.toString();
	}
}

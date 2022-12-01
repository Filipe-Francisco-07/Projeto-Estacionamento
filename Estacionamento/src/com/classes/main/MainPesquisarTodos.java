package com.classes.main;

import java.util.ArrayList;
import java.util.List;
import com.classes.BO.VagaBO;
import com.classes.DTO.Vaga;

public class MainPesquisarTodos {

	public static void main(String[] args) {
		
		// Teste Pesquisar Todos (Retorna a Lista de Marcas)
	
		
		VagaBO VagaBO = new VagaBO();
		List<Vaga> lista = new ArrayList<Vaga>();
		lista = VagaBO.pesquisarTodos();	
		for (Vaga vaga : lista) {
			System.out.println(vaga.toString());
		}
	
	}
}
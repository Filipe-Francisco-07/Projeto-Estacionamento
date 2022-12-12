package com.classes.main;

import java.util.ArrayList;
import java.util.List;

import com.classes.BO.ClienteBO;
import com.classes.DTO.Cliente;

public class MainCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//INSERTION
		ClienteBO cBO = new ClienteBO();
		Cliente cliente = new Cliente("Marcos","123.123.123-12");
				
		if(cBO.inserir(cliente)){
			System.out.println("Veículo inserido com sucesso!");
		}
				
			
		//ALTERATION 
		Cliente cliente_alterado = new Cliente("Juliano","123.123.123-12");
		if(cBO.alterar(cliente_alterado)) {
			System.out.println("Veiculo alterado com sucesso!");
		}
				
				
		//LIST
		ClienteBO ClienteBO = new ClienteBO();
		List<Cliente> lista = new ArrayList<Cliente>();
		lista = ClienteBO.pesquisarTodos();	
		for (Cliente cli : lista) {
			System.out.println(cli.toString());
		}
					
		//SEARCH FOR CODE
				
		ClienteBO new_cBO = new ClienteBO();
		Cliente search = new Cliente("ABC1D23");
		search = new_cBO.procurarPorCodigo(search);
		System.out.println(search);
				
		//DELETE
					
		ClienteBO cBO_exclusao = new ClienteBO();
		if (cBO_exclusao.excluir(cliente)){
			System.out.println("Excluido com Sucesso");
		}else{
			System.out.println("Erro ao Excluir");
		}	
		
	}

}

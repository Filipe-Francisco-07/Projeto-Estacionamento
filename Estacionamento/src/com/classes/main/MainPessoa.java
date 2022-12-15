package com.classes.main;

import java.util.ArrayList;
import java.util.List;

import com.classes.BO.PessoaBO;
import com.classes.DTO.Pessoa;



public class MainPessoa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//INSERTION
		PessoaBO pBO = new PessoaBO();
		Pessoa Pessoa = new Pessoa("Robson","999.999.999-99");
		Pessoa Pessoa2 = new Pessoa("Renata","123.123.452.44");
	
		pBO.inserir(Pessoa2);
		
			
		if(pBO.inserir(Pessoa)){
			System.out.println("Pessoa inserido com sucesso!");
		}
		
		//ALTERATION 
		Pessoa Pessoa_alterada = new Pessoa("Renatinho","999.999.999-99");
		if(pBO.alterar(Pessoa_alterada)) {
			System.out.println("Pessoa alterada com sucesso!");
		}
				
			
		//LIST
		PessoaBO PessoaBO = new PessoaBO();
		List<Pessoa> lista = new ArrayList<Pessoa>();
		lista = PessoaBO.pesquisarTodos();	
		for (Pessoa pess : lista) {
			System.out.println(pess.toString());
		}
					
		//SEARCH FOR CODE
	
		PessoaBO new_pBO = new PessoaBO();
		Pessoa search = new Pessoa("999.999.999-99");
		search = new_pBO.procurarPorCodigo(search);
		System.out.println(search);
			
		//DELETE
	
		PessoaBO pBO_exclusao = new PessoaBO();
		if (pBO_exclusao.excluir(Pessoa)){
			System.out.println("Excluido com Sucesso");
		}else{
			System.out.println("Erro ao Excluir");
		}	
		
	}

}

package com.classes.main;

import java.util.ArrayList;
import java.util.List;

import com.classes.BO.FuncionarioBO;
import com.classes.DTO.Funcionario;

public class MainFuncionario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//INSERTION
		FuncionarioBO fBO = new FuncionarioBO();
		Funcionario Funcionario = new Funcionario("Matias","222.222.222-22");
		Funcionario.setSalario(2300.54);
						
		if(fBO.inserir(Funcionario)){
			System.out.println("Funcionario inserido com sucesso!");
		}
						
					
		//ALTERATION 
		Funcionario.setNome("Mariana");
		if(fBO.alterar(Funcionario)) {
			System.out.println("Funcionario alterado com sucesso!");
		}
						
						
		//LIST
		FuncionarioBO FuncionarioBO = new FuncionarioBO();
		List<Funcionario> lista = new ArrayList<Funcionario>();
		lista = FuncionarioBO.pesquisarTodos();	
		for (Funcionario func : lista) {
			System.out.println(func.toString());
		}
					
		//SEARCH FOR CODE
				
		FuncionarioBO new_fBO = new FuncionarioBO();
		Funcionario search = new Funcionario("222.222.222-22");
		search = new_fBO.procurarPorCodigo(search);
		System.out.println(search);
						
		//DELETE
							
		FuncionarioBO fBO_exclusao = new FuncionarioBO();
		if (fBO_exclusao.excluir(Funcionario)){
			System.out.println("Excluido com Sucesso");
		}else{
			System.out.println("Erro ao Excluir");
		}						
		
	}

}

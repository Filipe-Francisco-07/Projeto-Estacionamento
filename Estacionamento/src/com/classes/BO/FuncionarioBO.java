package com.classes.BO;

import java.util.List;

import com.classes.DAO.FuncionarioDAO;
import com.classes.DTO.Funcionario;

public class FuncionarioBO {
	
	public boolean inserir(Funcionario Funcionario){
		FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
	    return FuncionarioDAO.inserir(Funcionario); 
	} 
	public boolean alterar(Funcionario Funcionario){
		FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
	    return FuncionarioDAO.alterar(Funcionario);
	}
	public boolean excluir(Funcionario Funcionario){
		FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
	    return FuncionarioDAO.excluir(Funcionario);
	}
	public boolean existe(Funcionario Funcionario){
		FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
	    return FuncionarioDAO.existe(Funcionario);
	}
	public Funcionario procurarPorCodigo(Funcionario Funcionario){
		FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
	    return FuncionarioDAO.procurarPorCodigo(Funcionario);
	}
	public List<Funcionario> pesquisarTodos(){
		FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
	    return FuncionarioDAO.pesquisarTodos();
	}
}

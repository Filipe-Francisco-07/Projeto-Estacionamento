package com.classes.BO;

import com.classes.DTO.Cliente;
import java.util.List;
import com.classes.DAO.ClienteDAO;

public class ClienteBO {

	public boolean inserir(Cliente Cliente){
		ClienteDAO ClienteDAO = new ClienteDAO();
	    return ClienteDAO.inserir(Cliente); 
	} 
	public boolean alterar(Cliente Cliente){
		ClienteDAO ClienteDAO = new ClienteDAO();
	    return ClienteDAO.alterar(Cliente);
	}
	public boolean excluir(Cliente Cliente){
		ClienteDAO ClienteDAO = new ClienteDAO();
	    return ClienteDAO.excluir(Cliente);
	}
	public boolean existe(Cliente Cliente){
		ClienteDAO ClienteDAO = new ClienteDAO();
	    return ClienteDAO.existe(Cliente);
	}
	public List<Cliente> pesquisarTodos(){
		ClienteDAO ClienteDAO = new ClienteDAO();
	    return ClienteDAO.pesquisarTodos();
	}
}
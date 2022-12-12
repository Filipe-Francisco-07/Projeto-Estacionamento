package com.classes.BO;

import com.classes.DTO.Pessoa;
import java.util.List;
import com.classes.DAO.PessoaDAO;

public class PessoaBO {

    public boolean inserir(Pessoa Pessoa){
    	PessoaDAO PessoaDAO = new PessoaDAO();
        return PessoaDAO.inserir(Pessoa); 
    }  
	public boolean alterar(Pessoa Pessoa){
		PessoaDAO PessoaDAO = new PessoaDAO();
	    return PessoaDAO.alterar(Pessoa);
	}
	public boolean excluir(Pessoa Pessoa){
		PessoaDAO PessoaDAO = new PessoaDAO();
	    return PessoaDAO.excluir(Pessoa);
	}
	public boolean existe(Pessoa Pessoa){
		PessoaDAO PessoaDAO = new PessoaDAO();
	    return PessoaDAO.existe(Pessoa);
	}
	public Pessoa procurarPorCodigo(Pessoa Pessoa){
		PessoaDAO PessoaDAO = new PessoaDAO();
	    return PessoaDAO.procurarPorCodigo(Pessoa);
	}
	public List<Pessoa> pesquisarTodos(){
		PessoaDAO PessoaDAO = new PessoaDAO();
	    return PessoaDAO.pesquisarTodos();
	}
}
package com.classes.BO;

import com.classes.DTO.Vaga;
import java.util.List;
import com.classes.DAO.VagaDAO;

public class VagaBO {

    public boolean inserir(Vaga Vaga){
    	VagaDAO VagaDAO = new VagaDAO();
        return VagaDAO.inserir(Vaga); 
    }  
	public boolean alterar(Vaga Vaga){
		VagaDAO VagaDAO = new VagaDAO();
	    return VagaDAO.alterar(Vaga);
	}
	public boolean excluir(Vaga Vaga){
		VagaDAO VagaDAO = new VagaDAO();
	    return VagaDAO.excluir(Vaga);
	}
	public boolean existe(Vaga Vaga){
		VagaDAO VagaDAO = new VagaDAO();
	    return VagaDAO.existe(Vaga);
	}
	public List<Vaga> pesquisarTodos(){
		VagaDAO VagaDAO = new VagaDAO();
	    return VagaDAO.pesquisarTodos();
	}

}
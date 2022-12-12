package com.classes.BO;

import com.classes.DTO.Vaga;
import java.util.List;
import com.classes.DAO.VagaDAO;

public class VagaBO {

    public boolean inserir(Vaga Vaga){
    	VagaDAO VagaDAO = new VagaDAO();
        return VagaDAO.inserir(Vaga); 
    }  
    public boolean resetarVagas(Vaga Vaga){
    	VagaDAO VagaDAO = new VagaDAO();
        return VagaDAO.resetarVagas(Vaga); 
    }  
	public boolean estacionar(Vaga Vaga){
		VagaDAO VagaDAO = new VagaDAO();
	    return VagaDAO.estacionar(Vaga);
	}
	public boolean retirar(Vaga Vaga){
		VagaDAO VagaDAO = new VagaDAO();
	    return VagaDAO.retirar(Vaga);
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
package com.classes.BO;

import com.classes.DTO.Veiculo;
import java.util.List;
import com.classes.DAO.VeiculoDAO;

public class VeiculoBO {

    public boolean inserir(Veiculo veiculo){
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        return veiculoDAO.inserir(veiculo); 
    }  
	public boolean alterar(Veiculo Veiculo){
		VeiculoDAO VeiculoDAO = new VeiculoDAO();
	    return VeiculoDAO.alterar(Veiculo);
	}
	public boolean excluir(Veiculo Veiculo){
		VeiculoDAO VeiculoDAO = new VeiculoDAO();
	    return VeiculoDAO.excluir(Veiculo);
	}
	public boolean existe(Veiculo Veiculo){
		VeiculoDAO VeiculoDAO = new VeiculoDAO();
	    return VeiculoDAO.existe(Veiculo);
	}
	public Veiculo procurarPorCodigo(Veiculo Veiculo){
		VeiculoDAO VeiculoDAO = new VeiculoDAO();
	    return VeiculoDAO.procurarPorCodigo(Veiculo);
	}
	public List<Veiculo> pesquisarTodos(){
		VeiculoDAO VeiculoDAO = new VeiculoDAO();
	    return VeiculoDAO.pesquisarTodos();
	}

}
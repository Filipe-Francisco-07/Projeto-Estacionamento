package com.classes.main;

import java.util.ArrayList;
import java.util.List;

import com.classes.BO.VeiculoBO;
import com.classes.DTO.Veiculo;

public class MainVeiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//PRONTO
		
		//INSERTION
		VeiculoBO vBO = new VeiculoBO();
		Veiculo veiculo = new Veiculo("ABC1D23","Preto","Honda Civic",4,"111.111.111-11");
		
		if(vBO.inserir(veiculo)){
			System.out.println("Veículo inserido com sucesso!");
		}
		
		//ALTERATION 
		veiculo.setCor("Branco");
		veiculo.setModelo("Toyota Corolla");
		
		if(vBO.alterar(veiculo)) {
			System.out.println("Veiculo alterado com sucesso!");
		}
		
		
		
		//LIST
		VeiculoBO VeiculoBO = new VeiculoBO();
		List<Veiculo> lista = new ArrayList<Veiculo>();
		lista = VeiculoBO.pesquisarTodos();	
		for (Veiculo veic : lista) {
			System.out.println(veic.toString());
		}
		
			
		//SEARCH FOR CODE
		
		VeiculoBO new_vBO = new VeiculoBO();
		Veiculo search = new Veiculo("ABC1D23");
			search = new_vBO.procurarPorCodigo(search);
			System.out.println(search);
		
		//DELETE
			
		VeiculoBO vBO_exclusao = new VeiculoBO();
		if (vBO_exclusao.excluir(veiculo)){
			System.out.println("Excluido com Sucesso");
		}else{
			System.out.println("Erro ao Excluir");
		}
		
	

	}
}

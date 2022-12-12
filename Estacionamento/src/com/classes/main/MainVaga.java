package com.classes.main;

import java.util.ArrayList;
import java.util.List;

import com.classes.BO.VagaBO;
import com.classes.BO.VeiculoBO;
import com.classes.DTO.Vaga;
import com.classes.DTO.Veiculo;

public class MainVaga {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//INSERTION
		
		Veiculo veiculo = new Veiculo("ABC1D23","Preto","Honda Civic",4,"111.111.111-11");
		
		VagaBO vBO = new VagaBO();
		Vaga vaga = new Vaga(veiculo.getPlaca(),12);
		
		if(vBO.inserir(vaga)){
			System.out.println("Veículo inserido com sucesso!");
		}
		
		//ALTERATION 
		Veiculo veiculo_alterado = new Veiculo("ABC1D23","Branco","Toyota Corolla",4,"111.111.111-11");
		if(vBO.alterar(veiculo_alterado)) {
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

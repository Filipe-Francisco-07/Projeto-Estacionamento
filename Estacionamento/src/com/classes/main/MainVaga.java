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
		
		VagaBO vagaBO = new VagaBO();
		/*
		if(vagaBO.criarVagas(null)){
			System.out.println("As 30 vagas foram criadas");
		}
		
		/*
		//RESET 
		
		vagaBO.resetarVagas(null);
		
		//PARKING ou ALTERATION
		*/
		
		Veiculo veiculo = new Veiculo("234ADFV","Preto","Porsche Cayanne",4,"512.123.435-34");
		
		Vaga vaga = new Vaga(veiculo.getPlaca(),17);
		
		vagaBO.estacionar(vaga);

		
		//REMOVING VEHICLE ou DELETE
		
		vagaBO.retirar(vaga);
		
		//PESQUISAR TODOS
		
		List<Vaga> lista = new ArrayList<Vaga>();
		lista = vagaBO.pesquisarTodos();	
		for (Vaga vag : lista) {
			System.out.println(vag.toString());
		}

		
		
			
		//SEARCH FOR CODE
		
		VeiculoBO new_vBO = new VeiculoBO();
		Veiculo search = new Veiculo("ABC1D23");
			search = new_vBO.procurarPorCodigo(search);
			System.out.println(search);
		
		//RESET
		  if(vagaBO.resetarVagas(null)){
			System.out.println("Todas as vagas foram resetadas");
		}
		
		
		//DELETE
			
		if(vagaBO.excluirVagas(null)){
			System.out.println("Todas as vagas foram excluidas");
		}
		
		
	}

}

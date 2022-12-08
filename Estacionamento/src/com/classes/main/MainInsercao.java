package com.classes.main;

import com.classes.BO.VeiculoBO;
import com.classes.DTO.Veiculo;
import com.classes.BO.PessoaBO;
import com.classes.BO.VagaBO;
import com.classes.DTO.Pessoa;
import com.classes.DTO.Vaga;

public class MainInsercao {
	public static void main(String[] args) {
		// Teste Inserir

		
		VeiculoBO vBO = new VeiculoBO();
		Veiculo v= new Veiculo("113AYUD","Vermelho","Mitsubishi Eclipse",4);
		
		if(vBO.inserir(v))
			System.out.println("Inserido com Sucesso");

	/*	PessoaBO pBO = new PessoaBO();
		Pessoa p= new Pessoa("Cleiton","123.123.123-21");
				
			if(pBO.inserir(p))
				System.out.println("Inserido com Sucesso");

		VagaBO vagaBO = new VagaBO();
		Vaga vaga= new Vaga("DISPONÍVEL",1);
				
			if(vagaBO.inserir(vaga))
				System.out.println("Inserido com Sucesso");
		
*/
	}
}
package com.classes.main;

import com.classes.BO.PessoaBO;
import com.classes.BO.VagaBO;
import com.classes.BO.VeiculoBO;
import com.classes.DTO.Pessoa;
import com.classes.DTO.Vaga;
import com.classes.DTO.Veiculo;

public class MainAlteracao {

	public static void main(String[] args) {
			
		// Teste Alterar	
		
		VagaBO VagaBO = new VagaBO();
		Vaga Vaga = new Vaga("OCUPADO",1);
		VagaBO.alterar(Vaga);
		System.out.println(Vaga);
		
		PessoaBO PessoaBO = new PessoaBO();
		Pessoa Pessoa = new Pessoa("Xande","123.123.123-21");
		PessoaBO.alterar(Pessoa);
		System.out.println(Pessoa);
		
		VeiculoBO VeiculoBO = new VeiculoBO();
		Veiculo Veiculo = new Veiculo("135ABCD","CAMALEAO","BMX DO MATEUS",3);
		VeiculoBO.alterar(Veiculo);
		System.out.println(Veiculo);
		
	}
}
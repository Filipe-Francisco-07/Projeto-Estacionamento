package com.classes.main;

import com.classes.BO.PessoaBO;
import com.classes.BO.VagaBO;
import com.classes.BO.VeiculoBO;
import com.classes.DTO.Pessoa;
import com.classes.DTO.Vaga;
import com.classes.DTO.Veiculo;

public class MainExiste {

	public static void main(String[] args) {

		// Teste Existe
		// Verifica se existe outro item com a mesma descricao

		
		VagaBO VagaBO = new VagaBO();
		Vaga Vaga = new Vaga(1);
		if (VagaBO.existe(Vaga))
			System.out.println("Vaga já existe");
		else
			System.out.println("Vaga Nao Encontrada");
		
		PessoaBO PessoaBO = new PessoaBO();
		Pessoa Pessoa = new Pessoa("123.123.123-12");
		if (PessoaBO.existe(Pessoa))
			System.out.println("CPF já existe");
		else
			System.out.println("Pessoa Nao Encontrada");
		
		VeiculoBO VeiculoBO = new VeiculoBO();
		Veiculo Veiculo = new Veiculo("123ABCD");
		if (VeiculoBO.existe(Veiculo))
			System.out.println("Veiculo já existe");
		else
			System.out.println("Veiculo Nao Encontrada");

	}
}
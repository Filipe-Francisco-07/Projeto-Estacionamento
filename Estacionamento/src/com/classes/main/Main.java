package com.classes.main;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.classes.BO.ClienteBO;
import com.classes.BO.MonitoramentoBO;
import com.classes.BO.VagaBO;
import com.classes.BO.VeiculoBO;
import com.classes.DTO.Cliente;
import com.classes.DTO.Funcionario;
import com.classes.DTO.Monitoramento;
import com.classes.DTO.Vaga;
import com.classes.DTO.Veiculo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner input = new Scanner(System.in);

		//MAIN PRINCIPAL
		//cria veiculo
		VeiculoBO veiculoBO = new VeiculoBO();
		Veiculo veiculo= new Veiculo("1114YU4","Preto","Mitsubishi Eclipse",4);
		/*
		 * add veiculo
		 * 
		if(veiculoBO.inserir(veiculo)) {
			System.out.println("Inserido com Sucesso");
		}else {
			System.out.println("já existe.");
		}
		*/
		
		//cria cliente
		Cliente cliente = new Cliente("Cleito","123.123.123-44");

		//entra com o cliente e veiculo
		Monitoramento entrada = new Monitoramento(cliente.getCpf(),12,false,veiculo.getPlaca());
		
		MonitoramentoBO moniBO = new MonitoramentoBO();
		
		//insere a entrada
		if(moniBO.inserir(entrada))
			System.out.println("Inserido com Sucesso");
		
		Vaga vaga = new Vaga(veiculo.getPlaca(),5);
		
		VagaBO vagabo = new VagaBO();
		
		vagabo.estacionar(vaga);
		
		Monitoramento saida = new Monitoramento(cliente.getCpf(),veiculo.getPlaca(),16);
		
		vagabo.retirar(vaga);
		
		moniBO.sair(saida);
		saida.pagar(100.00);
		moniBO.pagamento(saida);
		
		

		input.close();
	}

}

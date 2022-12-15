package com.classes.main;
import java.util.Scanner;

import com.classes.BO.ClienteBO;
import com.classes.BO.MonitoramentoBO;
import com.classes.BO.VagaBO;
import com.classes.BO.VeiculoBO;
import com.classes.DTO.Cliente;
import com.classes.DTO.Monitoramento;
import com.classes.DTO.Vaga;
import com.classes.DTO.Veiculo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		
		Scanner input = new Scanner(System.in);

		//MAIN PRINCIPAL
		
		//cria cliente
		Cliente cliente = new Cliente("Mateus Granny","122.123.123-12");
		
		//cria veiculo
		Veiculo veiculo= new Veiculo("OMFGGG","Laranja","Crossfox",4,cliente.getCpf());
		
		VeiculoBO veiculoBO = new VeiculoBO();
		
		ClienteBO clienteBO = new ClienteBO();
		
		if(veiculoBO.inserir(veiculo))
			System.out.println("Inserido com Sucesso");
		//}else {
		//	System.out.println("já existe.");
	//	}
	//	
		clienteBO.inserir(cliente);

		//entra com o cliente e veiculo
		
		Monitoramento entrada = new Monitoramento(cliente.getCpf(),8,false,veiculo.getPlaca());
		
		MonitoramentoBO moniBO = new MonitoramentoBO();
		
		//insere a entrada
		if(moniBO.inserir(entrada)) 
			System.out.println("Inserido com Sucesso");
	//	}else{
	//		System.out.println("nao");
	//	}
		//selecionando a vaga na qual o veiculo vai estacionar
		
		Vaga vaga = new Vaga(veiculo.getPlaca());
		
		
		
		if(entrada.getVal()) {
			vaga = new Vaga(veiculo.getPlaca());
		}else{
			vaga = new Vaga(veiculo.getPlaca(),23);
		}
		
		VagaBO vagabo = new VagaBO();
		
		
	//	VagaDAO v = new VagaDAO();
	//	v.resetarVagas(vaga);
		
		//setando status na vaga de ocupado(nenhum outro carro poderá estacionar nesse status de vaga)
		vagabo.estacionar(vaga);

		
		
		//criando a saida do carro
		Monitoramento saida = new Monitoramento(cliente.getCpf(),veiculo.getPlaca(),16);
		
		//retirando o carro da vaga
		vagabo.retirar(vaga);
		
		//saindo
		moniBO.sair(saida);
		
		//pagando
		saida.pagar(100.00);
		
		//verificando pagamento
		moniBO.pagamento(saida);

		moniBO.sair(saida);
		vagabo.retirar(vaga);
		Monitoramento pagamento = new Monitoramento(75.00,saida.getValorTotal());
		
		moniBO.pagamento(pagamento);
		
		

		input.close();
	}

}

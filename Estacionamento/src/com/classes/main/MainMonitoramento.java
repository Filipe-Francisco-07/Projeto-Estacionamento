package com.classes.main;

import java.util.ArrayList;
import java.util.List;

import com.classes.BO.MonitoramentoBO;
import com.classes.DTO.Cliente;
import com.classes.DTO.Monitoramento;
import com.classes.DTO.Veiculo;


public class MainMonitoramento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//INSERTION
		
		Cliente cliente = new Cliente("Amanda","174.122.223-72");
		Veiculo veiculo = new Veiculo("TCV1724","Amarelo","Corsa",4,"174.122.223-72");
		
		
		
		
		MonitoramentoBO mBO = new MonitoramentoBO();
		Monitoramento Moni = new Monitoramento(cliente.getCpf(),14,true,veiculo.getPlaca());
				
		if(mBO.inserir(Moni)){
			System.out.println("Entrada registrada com sucesso!");
		}
			
				
		//ALTERATION 
		Monitoramento Monitoramento_alterado = new Monitoramento(cliente.getCpf(),14,true,veiculo.getPlaca());
		if(mBO.alterar(Monitoramento_alterado)) {
			System.out.println("Registro alterado com sucesso!");
		}				
	
		
		
		//SEARCH FOR CODE
				
		MonitoramentoBO new_mBO = new MonitoramentoBO();
		Monitoramento search = new Monitoramento();
		search.setId(3);
		System.out.println(new_mBO.procurarPorCodigo(search));

				
		//EXITING
		
	
		Moni.setDataSaida(20);
		
		mBO.sair(Moni);
		
		
		//PAYMENT
		
		Moni.setPagamento(50);
		
		mBO.pagamento(Moni);
	
		
		//LIST
		//LIST
		MonitoramentoBO listaBO = new MonitoramentoBO();
		List<Monitoramento> lista = new ArrayList<Monitoramento>();
		lista = listaBO.pesquisarTodos();	
		for (Monitoramento lista_monit : lista) {
			System.out.println(lista_monit.toString());
		}
		
		//DELETE
					
		MonitoramentoBO mBO_exclusao = new MonitoramentoBO();
		if (mBO_exclusao.excluir(Moni)){
			System.out.println("Excluido com Sucesso");
		}else{
			System.out.println("Erro ao Excluir");
		}		
	
	}

}

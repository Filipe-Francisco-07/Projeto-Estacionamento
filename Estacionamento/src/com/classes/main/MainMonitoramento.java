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
		
		Cliente cliente2 = new Cliente("Weliton","223.126.543-35");
		Veiculo veiculo2 = new Veiculo("PDW6677","Cinza","HB20",4,"223.126.543-35");
		
		
		
		MonitoramentoBO mBO = new MonitoramentoBO();
		Monitoramento Moni_com_valet = new Monitoramento(cliente.getCpf(),14,true,veiculo.getPlaca());
		Monitoramento Moni_sem_valet = new Monitoramento(cliente2.getCpf(),14,false,veiculo2.getPlaca());
				
		if(mBO.inserir(Moni_com_valet)){
			System.out.println("Veículo inserido com sucesso!");
		}
		if(mBO.inserir(Moni_sem_valet)){
			System.out.println("Veículo inserido com sucesso!");
		}
				
				
				
		//ALTERATION 
		Monitoramento Monitoramento_alterado = new Monitoramento(cliente2.getCpf(),14,true,veiculo2.getPlaca());
		if(mBO.alterar(Monitoramento_alterado)) {
			System.out.println("Veiculo alterado com sucesso!");
		}				
		
		
		
		//SEARCH FOR CODE
				
		MonitoramentoBO new_mBO = new MonitoramentoBO();
		Monitoramento search = new Monitoramento(cliente2.getCpf());
		search = new_mBO.procurarPorCodigo(search);
		System.out.println(search);
				
		//EXITING
		
		
		Moni_com_valet.setDataSaida(20);
		
		mBO.sair(Moni_com_valet);
		
		
		//PAYMENT
		
		Moni_com_valet.setPagamento(50);
		
		mBO.pagamento(Moni_com_valet);
	
		
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
		if (mBO_exclusao.excluir(Moni_com_valet)){
			System.out.println("Excluido com Sucesso");
		}else{
			System.out.println("Erro ao Excluir");
		}		
		
	}

}

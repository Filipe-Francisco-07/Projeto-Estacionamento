package com.classes.main;

import java.util.ArrayList;
import java.util.List;

import com.classes.BO.MonitoramentoBO;
import com.classes.DTO.Monitoramento;


public class MainMonitoramento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//INSERTION
		MonitoramentoBO mBO = new MonitoramentoBO();
		Monitoramento Moni_com_valet = new Monitoramento("333.333.333-33",14,true,"ABC1234");
		Monitoramento Moni_sem_valet = new Monitoramento("444.444.444-44",14,false,"TRSA123");
				
		if(mBO.inserir(Moni_com_valet)){
			System.out.println("Veículo inserido com sucesso!");
		}
		if(mBO.inserir(Moni_sem_valet)){
			System.out.println("Veículo inserido com sucesso!");
		}
				
				
				
		//ALTERATION 
		Monitoramento Monitoramento_alterado = new Monitoramento("987.654.321-00",14,true,"TRSA123");
		if(mBO.alterar(Monitoramento_alterado)) {
			System.out.println("Veiculo alterado com sucesso!");
		}				
					
		//SEARCH FOR CODE
				
		MonitoramentoBO new_mBO = new MonitoramentoBO();
		Monitoramento search = new Monitoramento("ABC1D23");
		search = new_mBO.procurarPorCodigo(search);
		System.out.println(search);
				
		//EXITING
		
		if(mBO.sair(Moni_com_valet)) {
			System.out.println("Veículo de placa: "+Moni_com_valet.getPlaca()+" saiu com sucesso.");
		}
		
		//PAYMENT
		
		mBO.pagamento(Moni_com_valet);
		
		Moni_com_valet.pagar(100.00);
		
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
		if (mBO_exclusao.excluir(Moni_sem_valet)){
			System.out.println("Excluido com Sucesso");
		}else{
			System.out.println("Erro ao Excluir");
		}		
		
	}

}

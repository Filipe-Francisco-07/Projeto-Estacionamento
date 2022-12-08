package com.classes.BO;

import java.util.List;
import com.classes.DAO.MonitoramentoDAO;
import com.classes.DTO.Monitoramento;

public class MonitoramentoBO {
	
	public boolean inserir(Monitoramento Monitoramento){
	    MonitoramentoDAO MonitoramentoDAO = new MonitoramentoDAO();
	    return MonitoramentoDAO.inserir(Monitoramento);
	}
	public String pagamento(Monitoramento Monitoramento){
	    MonitoramentoDAO MonitoramentoDAO = new MonitoramentoDAO();
	    return MonitoramentoDAO.pagamento(Monitoramento);
	}
	public boolean alterar(Monitoramento Monitoramento){
		MonitoramentoDAO MonitoramentoDAO = new MonitoramentoDAO();
	    return MonitoramentoDAO.alterar(Monitoramento);
	}
	public boolean excluir(Monitoramento Monitoramento){
		MonitoramentoDAO MonitoramentoDAO = new MonitoramentoDAO();
	    return MonitoramentoDAO.excluir(Monitoramento);
	}
	public boolean existe(Monitoramento Monitoramento){
		MonitoramentoDAO MonitoramentoDAO = new MonitoramentoDAO();
	    return MonitoramentoDAO.existe(Monitoramento);
	}
	public boolean sair(Monitoramento Monitoramento){
		MonitoramentoDAO MonitoramentoDAO = new MonitoramentoDAO();
	    return MonitoramentoDAO.sair(Monitoramento);
	}
	public List<Monitoramento> pesquisarTodos(){
		MonitoramentoDAO MonitoramentoDAO = new MonitoramentoDAO();
	    return MonitoramentoDAO.pesquisarTodos();
	}
}

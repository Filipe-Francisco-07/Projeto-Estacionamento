package com.classes.DAO;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.classes.DTO.Monitoramento;
import com.classes.Conexao.Conexao;

public class MonitoramentoDAO {

    final String NOMEDATABELA = "monitoramento";
    
    public boolean inserir(Monitoramento Monitoramento) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (cpf, dataEntrada, valorHora, valet, placa, valorTotal)   VALUES (?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Monitoramento.getCpf());
            ps.setInt(2, Monitoramento.getDataEntrada());
            ps.setDouble(3, Monitoramento.getValorHora());
            if(Monitoramento.getVal()){
            	ps.setString(4, "Sim");
            }else {
            	ps.setString(4, "Nao");
            }
            ps.setString(5, Monitoramento.getPlaca());
            if(Monitoramento.getVal()){
            	ps.setDouble(6, 10);
            }else {
            	ps.setDouble(6, 0);
            }
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public String pagamento(Monitoramento Monitoramento) {
       
        double pagamento = (Monitoramento.getPagamento() - Monitoramento.getValorTotal());
    	if(pagamento >= 0) {
    		double troco = pagamento;
    		return ("Seu pagamento de "+Monitoramento.getPagamento()+" resultou em um troco de "+troco+", Obrigado pela prefer�ncia.");
    	}else {
    		double saldo = pagamento;
    		return ("Seu pagamento de "+Monitoramento.getPagamento()+" n�o foi suficiente e voc� ainda est� devendo "+saldo+" R$.");
    	}   
    }
    public boolean alterar(Monitoramento Monitoramento) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET descricao = ? WHERE codigo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
    
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public boolean sair(Monitoramento Monitoramento) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET dataSaida = ?, N_horas = ?, valorTotal = ? WHERE cpf = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            Monitoramento.setN_horas(Monitoramento.getDataSaida()-Monitoramento.getDataEntrada());
            ps.setInt(1, Monitoramento.getDataSaida());
            ps.setInt(2, Monitoramento.getN_horas());
            if(Monitoramento.getVal()){
            	Monitoramento.setValorTotal(Monitoramento.getN_horas()*Monitoramento.getValorHora()+10);
            	ps.setDouble(3, Monitoramento.getValorTotal());
            }else {
            	Monitoramento.setValorTotal(Monitoramento.getN_horas()*Monitoramento.getValorHora());
            	ps.setDouble(3, Monitoramento.getValorTotal());
            }
            ps.setString(4, Monitoramento.getCpf());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public boolean excluir(Monitoramento Monitoramento) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE codigo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
      
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public List<Monitoramento> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Monitoramento> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            //System.err.println("Erro: " + e.toString());
            //e.printStackTrace();
            return null;
        }
    }
    
    public boolean existe(Monitoramento Monitoramento) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE descricao = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Monitoramento.getCpf());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            //System.err.println("Erro: " + e.toString());
            //e.printStackTrace();
            return false;
        }
        return false;
    }
    
    public List<Monitoramento> montarLista(ResultSet rs) {
        List<Monitoramento> listObj = new ArrayList<Monitoramento>();
        try {
            while (rs.next()) {
            	Monitoramento obj = new Monitoramento();
                obj.setId(rs.getInt(1));
                obj.setCpf(rs.getString(2));
                obj.setPlaca(rs.getString(3));
                obj.setDataEntrada(rs.getInt(4));
                obj.setDataSaida(rs.getInt(5));
                obj.setVal(rs.getBoolean(6));
                obj.setValorTotal(rs.getDouble(7));
                obj.setValorHora(rs.getDouble(8));
                obj.setN_horas(rs.getInt(9));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            //System.err.println("Erro: " + e.toString());
            //e.printStackTrace();
            return null;
        }
    }
    
}
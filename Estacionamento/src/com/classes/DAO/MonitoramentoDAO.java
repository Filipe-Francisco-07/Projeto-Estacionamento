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
            String sql = "INSERT INTO " + NOMEDATABELA + " (cpf, dataEntrada, valorHora, valet, placa,valorTotal) VALUES (?,?,?,?,?,?);";
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
    public boolean pagamento(Monitoramento Monitoramento) {
       
    	if((Monitoramento.getPagamento() - Monitoramento.getValorTotal()) >= 0) {
    		System.out.println("Seu pagamento de "+Monitoramento.getPagamento()+" resultou em um troco de "+(Monitoramento.getPagamento() - Monitoramento.getValorTotal())+" R$, Obrigado pela prefer�ncia.");
    		return true;
    	}else {
    		System.out.println("Seu pagamento de "+Monitoramento.getPagamento()+" n�o foi suficiente e voc� ainda est� devendo "+((Monitoramento.getPagamento() - Monitoramento.getValorTotal())*(-1))+" R$.");
    		return true;
    	}   
    }
    public boolean alterar(Monitoramento Monitoramento) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET dataEntrada = ?, valet = ?, placa = ? , valorTotal = ? WHERE cpf = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setInt(1, Monitoramento.getDataEntrada());
		    if(Monitoramento.getVal()) {
		    	ps.setString(2, "Sim");	
		    }else {
		    	ps.setString(2, "Não");	
		    }
		    ps.setString(3, Monitoramento.getPlaca());
		    if(Monitoramento.getVal()){
            	ps.setDouble(4, 10);
            }else {
            	ps.setDouble(4, 0);
            }
		    ps.setString(5, Monitoramento.getCpf());
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
            ps.setInt(2, Monitoramento.getDataSaida()-Monitoramento.getDataEntrada());
            if(Monitoramento.getVal()){
            	Monitoramento.setValorTotal(Monitoramento.getN_horas()*Monitoramento.getValorHora()+10);
            	System.out.println("Valor a ser pago: "+((Monitoramento.getN_horas()*Monitoramento.getValorHora())+10)+" R$.");
            	ps.setDouble(3, Monitoramento.getValorTotal());
            }else {
            	Monitoramento.setValorTotal(Monitoramento.getN_horas()*Monitoramento.getValorHora());
            	System.out.println("Valor a ser pago: "+Monitoramento.getN_horas()*Monitoramento.getValorHora()+" R$.");
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
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE placa = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Monitoramento.getPlaca());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    
    public Monitoramento procurarPorCodigo(Monitoramento Monitoramento) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cpf = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Monitoramento.getCpf());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	Monitoramento obj = new Monitoramento();
                obj.setId(rs.getInt(1));
                obj.setCpf(rs.getString(2));       
                obj.setDataEntrada(rs.getInt(3));
                obj.setN_horas(rs.getInt(4));       
                obj.getValorHora();
                if(rs.getString(6) == "Sim") {
                	 obj.setVal(true);
                }else {
                	obj.setVal(false);
                }
                obj.setPlaca(rs.getString(7));
                obj.setValorTotal(rs.getDouble(8));
                obj.setDataSaida(rs.getInt(9));         
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
        	 e.printStackTrace();
             return null;
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
                obj.setDataEntrada(rs.getInt(3));
                obj.setN_horas(rs.getInt(4));
                obj.getValorHora();
                if(rs.getString(6) == "Sim") {
                	obj.setVal(true);
                }else {
                	obj.setVal(false);
                }
                obj.setPlaca(rs.getString(7));
                obj.setValorTotal(rs.getDouble(8));
                obj.setDataSaida(rs.getInt(9));

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
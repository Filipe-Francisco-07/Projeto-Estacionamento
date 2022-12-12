package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.classes.DTO.Veiculo;
import com.classes.Conexao.Conexao;

public class VeiculoDAO {

	final String NOMEDATABELA = "veiculo";
	    
	public boolean inserir(Veiculo veiculo) {
		try {
			Connection conn = Conexao.conectar();
		    String sql = "INSERT INTO " + NOMEDATABELA + " (placa, cor, modelo, n_rodas, cpf) VALUES (?,?,?,?,?);";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, veiculo.getPlaca());
		    ps.setString(2, veiculo.getCor());
		    ps.setString(3, veiculo.getModelo());
		    ps.setInt(4, veiculo.getN_rodas());
		    ps.setString(5, veiculo.getCpf());
		    ps.executeUpdate();
		    ps.close();
		    conn.close();
		    return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	   public boolean alterar(Veiculo veiculo) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET cor = ?, modelo = ?, n_rodas = ? WHERE placa = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
			    ps.setString(1, veiculo.getCor());
			    ps.setString(2, veiculo.getModelo());
			    ps.setInt(3, veiculo.getN_rodas());
			    ps.setString(4, veiculo.getPlaca());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   public boolean excluir(Veiculo veiculo) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE placa = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, veiculo.getPlaca());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   
	   public boolean existe(Veiculo veiculo) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE placa = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, veiculo.getPlaca());
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
	   public Veiculo procurarPorCodigo(Veiculo Veiculo) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE placa = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, Veiculo.getPlaca());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	Veiculo obj = new Veiculo();
	                obj.setPlaca(rs.getString(1));
	                obj.setCor(rs.getString(2));
	                obj.setModelo(rs.getString(3));
	                obj.setN_rodas(rs.getInt(4));
	                obj.setCpf(rs.getString(5));
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
	   
	    public List<Veiculo> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Veiculo> listObj = montarLista(rs);
	            return listObj;
	        } catch (Exception e) {
	            //System.err.println("Erro: " + e.toString());
	            //e.printStackTrace();
	            return null;
	        }	  
	    }
	  
	    public List<Veiculo> montarLista(ResultSet rs) {
	        List<Veiculo> listObj = new ArrayList<Veiculo>();
	        try {
	            while (rs.next()) {
	                Veiculo obj = new Veiculo();
	                obj.setPlaca(rs.getString(1));
	                obj.setCor(rs.getString(2));
	                obj.setModelo(rs.getString(3));
	                obj.setN_rodas(rs.getInt(4));
	                obj.setCpf(rs.getString(5));
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

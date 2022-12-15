package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.classes.Conexao.Conexao;
import com.classes.DTO.Funcionario;


public class FuncionarioDAO {

	final String NOMEDATABELA = "funcionario";
    
	public boolean inserir(Funcionario Funcionario) {
		try {
			Connection conn = Conexao.conectar();
		    String sql = "INSERT INTO " + NOMEDATABELA + " (nome, cpf, salario) VALUES (?,?,?);";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, Funcionario.getNome());
		    ps.setString(2, Funcionario.getCpf());
		    ps.setDouble(3, Funcionario.getSalario());
		    ps.executeUpdate();
		    ps.close();
		    conn.close();
		    return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	   public boolean alterar(Funcionario Funcionario) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE cpf = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, Funcionario.getNome());
			    ps.setString(2, Funcionario.getCpf());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   public boolean excluir(Funcionario Funcionario) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE cpf = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
			    ps.setString(1, Funcionario.getCpf());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   
	   public boolean existe(Funcionario Funcionario) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cpf = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
			    ps.setString(1, Funcionario.getCpf());
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
	   public Funcionario procurarPorCodigo(Funcionario Funcionario) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cpf = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, Funcionario.getCpf());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	Funcionario obj = new Funcionario();
	                obj.setCpf(rs.getString(1));
	                obj.setNome(rs.getString(2));
	                obj.setSalario(rs.getDouble(3));
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
	   
	    public List<Funcionario> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Funcionario> listObj = montarLista(rs);
	            return listObj;
	        } catch (Exception e) {
	            //System.err.println("Erro: " + e.toString());
	            //e.printStackTrace();
	            return null;
	        }	  
	    }
	  
	    public List<Funcionario> montarLista(ResultSet rs) {
	        List<Funcionario> listObj = new ArrayList<Funcionario>();
	        try {
	            while (rs.next()) {
	            	Funcionario obj = new Funcionario();
	                obj.setNome(rs.getString(1));
	                obj.setCpf(rs.getString(2));
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
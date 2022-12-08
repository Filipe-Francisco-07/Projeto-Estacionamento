package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.classes.Conexao.Conexao;
import com.classes.DTO.Cliente;

public class ClienteDAO {

	final String NOMEDATABELA = "cliente";
    
	public boolean inserir(Cliente Cliente) {
		try {
			Connection conn = Conexao.conectar();
		    String sql = "INSERT INTO " + NOMEDATABELA + " (nome, cpf) VALUES (?,?);";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, Cliente.getNome());
		    ps.setString(2, Cliente.getCpf());
		    ps.executeUpdate();
		    ps.close();
		    conn.close();
		    return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	   public boolean alterar(Cliente Cliente) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE cpf = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, Cliente.getNome());
			    ps.setString(2, Cliente.getCpf());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   public boolean excluir(Cliente Cliente) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE cpf = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
			    ps.setString(1, Cliente.getCpf());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   
	   public boolean existe(Cliente Cliente) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cpf = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
			    ps.setString(1, Cliente.getCpf());
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
	   
	    public List<Cliente> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Cliente> listObj = montarLista(rs);
	            return listObj;
	        } catch (Exception e) {
	            //System.err.println("Erro: " + e.toString());
	            //e.printStackTrace();
	            return null;
	        }	  
	    }
	  
	    public List<Cliente> montarLista(ResultSet rs) {
	        List<Cliente> listObj = new ArrayList<Cliente>();
	        try {
	            while (rs.next()) {
	            	Cliente obj = new Cliente();
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
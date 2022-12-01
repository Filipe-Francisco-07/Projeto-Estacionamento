package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.classes.DTO.Pessoa;
import com.classes.Conexao.Conexao;

public class PessoaDAO {

	final String NOMEDATABELA = "pessoa";
	    
	public boolean inserir(Pessoa pessoa) {
		try {
			Connection conn = Conexao.conectar();
		    String sql = "INSERT INTO " + NOMEDATABELA + " (nome, cpf) VALUES (?,?);";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, pessoa.getNome());
		    ps.setString(2, pessoa.getCpf());
		    ps.executeUpdate();
		    ps.close();
		    conn.close();
		    return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	   public boolean alterar(Pessoa pessoa) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE cpf = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, pessoa.getNome());
			    ps.setString(2, pessoa.getCpf());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   public boolean excluir(Pessoa pessoa) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE cpf = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
			    ps.setString(1, pessoa.getCpf());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   
	   public boolean existe(Pessoa pessoa) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cpf = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
			    ps.setString(1, pessoa.getCpf());
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
	   
	    public List<Pessoa> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Pessoa> listObj = montarLista(rs);
	            return listObj;
	        } catch (Exception e) {
	            //System.err.println("Erro: " + e.toString());
	            //e.printStackTrace();
	            return null;
	        }	  
	    }
	  
	    public List<Pessoa> montarLista(ResultSet rs) {
	        List<Pessoa> listObj = new ArrayList<Pessoa>();
	        try {
	            while (rs.next()) {
	            	Pessoa obj = new Pessoa();
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
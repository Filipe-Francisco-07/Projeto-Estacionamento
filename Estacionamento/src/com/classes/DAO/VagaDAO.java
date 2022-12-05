package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.classes.DTO.Vaga;
import com.classes.Conexao.Conexao;

public class VagaDAO {

	final String NOMEDATABELA = "vaga";
	    
	public boolean inserir(Vaga vaga) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        List<Vaga> listObj = new ArrayList<Vaga>();
	        while (rs.next()) {
            	Vaga obj = new Vaga();
                obj.setStatus(rs.getString(1));
                obj.setCodigo(rs.getInt(2));

                listObj.add(obj);
            }
	        for(int i = 0; i < 31; i++) {
	        	if(listObj.get(i).getCodigo() == 30) {
	        		System.out.println("Número total de vagas preenchido.");
	        		return false;
	        	}
	        }
			
		    sql = "INSERT INTO " + NOMEDATABELA + " (status, codigo) VALUES (?,?);";
		    ps = conn.prepareStatement(sql);
		    ps.setString(1, vaga.getStatus());
		    ps.setInt(2, vaga.getCodigo());
		    ps.executeUpdate();
		    ps.close();
		    conn.close();
		    return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	   public boolean alterar(Vaga vaga) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET status = ? WHERE codigo = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, vaga.getStatus());
			    ps.setInt(2, vaga.getCodigo());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   public boolean excluir(Vaga vaga) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE codigo = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, vaga.getCodigo());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   
	   public boolean existe(Vaga vaga) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigo = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, vaga.getCodigo());
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
	   
	    public List<Vaga> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Vaga> listObj = montarLista(rs);
	            return listObj;
	        } catch (Exception e) {
	            //System.err.println("Erro: " + e.toString());
	            //e.printStackTrace();
	            return null;
	        }	  
	    }
	  
	    public List<Vaga> montarLista(ResultSet rs) {
	        List<Vaga> listObj = new ArrayList<Vaga>();
	        try {
	            while (rs.next()) {
	            	Vaga obj = new Vaga();
	                obj.setStatus(rs.getString(1));
	                obj.setCodigo(rs.getInt(2));

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
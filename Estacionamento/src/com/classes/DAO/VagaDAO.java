package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.classes.DTO.Vaga;
import com.classes.Conexao.Conexao;

public class VagaDAO {

	final String NOMEDATABELA = "vaga";
	    
	
	public boolean resetaVagas(Vaga vaga) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public boolean inserir(Vaga vaga) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        List<Vaga> listObj = new ArrayList<Vaga>();
	        while (rs.next()) {
            	Vaga obj = new Vaga();
                obj.setStats(rs.getString(1));
                obj.setCodigo(rs.getInt(2));

                listObj.add(obj);
            }
	        for(int i = 0; i < 31; i++) {
	        	if(listObj.get(i).getCodigo() == 30) {
	        		System.out.println("NÃºmero total de vagas preenchido.");
	        		return false;
	        	}
	        }
		    sql = "INSERT INTO " + NOMEDATABELA + " (stats, codigo) VALUES (?,?);";
		    ps = conn.prepareStatement(sql);
		    ps.setString(1, vaga.getStats());
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
	   public boolean estacionar(Vaga vaga) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT stats FROM " + NOMEDATABELA + " WHERE codigo = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, vaga.getCodigo());
	            ResultSet rs = ps.executeQuery();
	            while(rs.toString() == "OCUPADO"){
	            	Random r = new Random();
	            	vaga.setCodigo(r.nextInt(1,30));
	            	
	            	sql = "SELECT stats FROM " + NOMEDATABELA + " WHERE codigo = ?;";
		            ps = conn.prepareStatement(sql);
		            ps.setInt(1, vaga.getCodigo());
		            ps.executeQuery();

	            }
	            sql = "UPDATE " + NOMEDATABELA + " SET stats = (?), placa = (?) WHERE codigo = ?;";	    
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, "OCUPADO");
	            ps.setString(2, vaga.getPlaca());
			    ps.setInt(3, vaga.getCodigo());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   
	   public boolean retirar(Vaga vaga) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET stats = (?), placa = ? WHERE codigo = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, "DISPONÍVEL");
			    ps.setString(2, ""); 
			    ps.setInt(3, vaga.getCodigo());
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
	                obj.setStats(rs.getString(1));
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
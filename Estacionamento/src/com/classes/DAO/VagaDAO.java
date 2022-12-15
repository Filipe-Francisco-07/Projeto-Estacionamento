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
	    
	
	public boolean criarVagas(Vaga vaga) {
		try {			
	        for(int i = 1; i < 31; i++) {
	        Connection conn = Conexao.conectar();
	        String sql = "INSERT INTO " + NOMEDATABELA + " (stats, placa) VALUES (?,?);";   
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, "DISPONIVEL");
	        ps.setString(2, "");
	        ps.executeUpdate();
	        ps.close();
	        conn.close();
	        }
	        return true;
	  
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public boolean excluirVagas(Vaga Vaga) {
        try {
 
            for(int i = 1; i < 31; i++) {
            	Connection conn = Conexao.conectar();
            	String sql = "DELETE FROM " + NOMEDATABELA + " WHERE codigo = ?;";
            	PreparedStatement ps = conn.prepareStatement(sql);
            	ps.setInt(1, i);
            	ps.executeUpdate();
            	ps.close();
            	conn.close();
            }
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
	
	public boolean resetarVagas(Vaga vaga) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "UPDATE " + NOMEDATABELA + " SET stats = (?), placa = ? WHERE codigo between 1 and 30;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "DISPONÍVEL");
			ps.setString(2, ""); 
			ps.executeUpdate();
			ps.close();
			conn.close();

            return true;
		} catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public boolean inserir(Vaga vaga) {
		try {
	
	        Connection conn = Conexao.conectar();
	        String sql = "INSERT INTO " + NOMEDATABELA + " (stats, codigo) VALUES (?,?);";
	        PreparedStatement ps = conn.prepareStatement(sql);
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
	        	//pt 1
	        	if(vaga.getCodigo() == 0) {
					Random r = new Random();
					vaga.setCodigo(r.nextInt(1,30));	
				}
				boolean validar = true;
				boolean ocupado = false;
				boolean plaquita = false;
				Connection conn = Conexao.conectar();
				String sql = "SELECT stats FROM " + NOMEDATABELA +" where codigo = ?;";
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ps.setInt(1, vaga.getCodigo());
		        ResultSet rs = ps.executeQuery();
		        while(rs.next()) {
	            	Vaga obj = new Vaga();
	                obj.setStats(rs.getString("stats").toString());
	                String status = obj.getStats();	             
	                if(status.equals("OCUPADO")) {
	                	validar = false;
	                	ocupado = true;
	                }else {
	                	validar = true;
	                }
	            }		        
		        //pt2
				sql = "SELECT placa FROM " + NOMEDATABELA +" ;";
		        ps = conn.prepareStatement(sql);
		        rs = ps.executeQuery();
		        while(rs.next()) {
	            	Vaga obj = new Vaga();
	                obj.setPlaca(rs.getString("placa").toString());
	                String placa = obj.getPlaca();	        
	                if(placa.equals(vaga.getPlaca().toString())) {
	                	validar = false;
	                	plaquita = true;
	                }		                
		        }
		        
		        if(validar) {
		        	sql = "UPDATE " + NOMEDATABELA + " SET stats = ?, placa = ? WHERE codigo = ?;";	    
		        	ps = conn.prepareStatement(sql);
		        	ps.setString(1,"OCUPADO");
		        	ps.setString(2, vaga.getPlaca());
		        	ps.setInt(3, vaga.getCodigo());
		        	ps.executeUpdate();
		        	ps.close();
		        	conn.close();
		        	System.out.println("Estacionado na vaga "+vaga.getCodigo()+" com sucesso.");
		        	return true;
		        }else {
		        	if(plaquita) {
		        		System.out.println("O veículo com a placa correspondente já está estacionado.");
		        	}
		        	if(ocupado) {
		        		System.out.println("Vaga "+vaga.getCodigo()+" ocupada.");
		        	}
		        	return false;

		        	}
		        
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	   
	   public boolean retirar(Vaga vaga) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET stats = ?, placa = ? WHERE codigo = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, "DISPONIVEL");
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
	   
	   public Vaga procurarPorCodigo(Vaga vaga) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE placa = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, vaga.getPlaca());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	Vaga obj = new Vaga();
	                obj.setCodigo(rs.getInt(1));
	                obj.setStats(rs.getString(2));
	                obj.setPlaca(rs.getString(3));
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
	            //System.err.println("Erro: " + e.toString());
	            //e.printStackTrace();
	            return null;
	        }
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
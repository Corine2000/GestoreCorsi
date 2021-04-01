package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {
	
	
	public List<Corso> getCorsiPerPd(Integer periodoDidatico){
		List<Corso> risultato = new ArrayList<>();
		
		
		try {
			Connection conn = DBConnect.getConnection();
			String sql = "SELECT * FROM corso WHERE pd=?";
			
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodoDidatico);
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				String codins = result.getString("codins");
				 Integer crediti = result.getInt("crediti");
				 String nome = result.getString("nome");
				 Integer pd = result.getInt("pd");
				 
				 Corso c = new Corso(codins, crediti, nome, pd);
				 risultato.add(c);
			}
			conn.close();
			
		}catch(SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("ERRORE NEL METODO getCorsiPerPd", e);
		}
		
		return risultato;
	}
	
	public int NumIscrittiPerPD(Integer periodoDidatico) {
		int numero=0;
		
		String sql = "SELECT COUNT(*) AS cnt "
				+ "FROM iscrizione i, corso c "
				+ "WHERE  i.codins = c.codins AND c.pd=? ";
		 try {
			 Connection conn = DBConnect.getConnection();
				
				PreparedStatement st = conn.prepareStatement(sql);
				st.setInt(1, periodoDidatico);
				ResultSet result = st.executeQuery();
				result.first();
				
				numero = result.getInt("cnt");
				
				st.close();
				conn.close();
		 } catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("ERRORE NEL METODO getCorsiPerPd", e);
	     }
		 return numero;
	}
}

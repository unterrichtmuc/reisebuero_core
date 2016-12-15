package de.cmt.reisebuero.core.reise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReiseSqlHelper 
{
	/**
	 * Create method for the Customer
	 * 
	 * @param con The database connection
	 * @param reise Der Kunde ohne ID!!!!
	 * @return Kunde mit ID
	 * 
	 * @throws SQLException Wenn etwas
	 */
	public static Reise create(Connection con, Reise reise) throws SQLException {
		String sql = "INSERT into reisen "
				+ "(titel, beschreibung, beginn, dauer, art, preis, land, state) "
				+ "VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		ps.setString(1, reise.getTitel());
		ps.setString(2, reise.getBeschreibung());
		ps.setInt(4, reise.getDauer());
		ps.setDate(3, new java.sql.Date(reise.getBeginn().getTime()));
		ps.setInt(5, reise.getArt());
		ps.setDouble(6, reise.getPreis());
		ps.setString(7, reise.getLand());
		ps.setInt(8, reise.getState());
		
		ps.execute();
		
		ResultSet rs = ps.getGeneratedKeys();
		
		rs.next();
		
		reise.setId(rs.getInt(1));
		
		rs.close();
		con.close();

		return reise;
	}
	public static Reise update(Connection con, Reise reise) throws SQLException {
		String sql = "UPDATE reisen "
				+ "SET titel = ?, beschreibung = ?, beginn = ?, dauer = ?, art = ?, preis = ?, land = ?, state = ? "
				+ "WHERE id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, reise.getTitel());
		ps.setString(2, reise.getBeschreibung());
		ps.setInt(4, reise.getDauer());
		ps.setDate(3, new java.sql.Date(reise.getBeginn().getTime()));
		ps.setInt(5, reise.getArt());
		ps.setDouble(6, reise.getPreis());
		ps.setString(7, reise.getLand());
		ps.setInt(8, reise.getState());
		ps.setInt(9, reise.getId());
		
		ps.execute();
		
		con.close();

		return reise;
	}
	public static final int ALL_REISEN = -1;
	
	public static Reise[] getReisen(Connection con, int status) throws SQLException, Exception {
		String sql = "SELECT * FROM reisen";
		
		if (status != ALL_REISEN) {
			sql += " WHERE state = ?";
		}
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		if (status != ALL_REISEN) {
			ps.setInt(1, status);
		}
		
		ps.executeQuery();
		
		ResultSet rs = ps.getResultSet();
		
		// Trick um die Anzahl der Datensätze zu bekommen - Alternative ArrayListe
		rs.last();
		int count = rs.getRow();
		rs.beforeFirst();
		
		if (count == 0) {
			con.close();
			
			return null;
		}
		
		Reise[] reisen = new Reise[count];
		
		for (int i = 0; i < reisen.length; i++)
		{
			rs.next();
			
			reisen[i] = new Reise();
			
			reisen[i].setId(rs.getInt("id"));
			reisen[i].setArt(rs.getInt("art"));
			reisen[i].setBeginn(new java.util.Date(rs.getDate("beginn").getTime()));
			reisen[i].setDauer(rs.getInt("dauer"));
			reisen[i].setLand(rs.getString("land"));
			
			reisen[i].setPreis(rs.getDouble("preis"));
			reisen[i].setState((short) rs.getInt("state"));
			reisen[i].setTitel(rs.getString("titel"));
			reisen[i].setBeschreibung(rs.getString("beschreibung"));
			
		}
		
		rs.close();
		con.close();
		
		return reisen;
	}

	
	public static Reise getReise(Connection con, int id) throws SQLException, Exception {
		String sql = "SELECT * FROM reisen where id=?";
		
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		ps.setInt(1, id);
				
		ps.executeQuery();
		
		ResultSet rs = ps.getResultSet();
		
		// Trick um die Anzahl der Datensätze zu bekommen - Alternative ArrayListe
		rs.last();
		int count = rs.getRow();
		rs.beforeFirst();
		
		if (count == 0) {
			con.close();
			
			return null;
		}
//todo remove Array		
		Reise[] reisen = new Reise[count];
		
		for (int i = 0; i < reisen.length; i++)
		{
			rs.next();
			
			reisen[i] = new Reise();
			
			reisen[i].setId(rs.getInt("id"));
			reisen[i].setArt(rs.getInt("art"));
			reisen[i].setBeginn(new java.util.Date(rs.getDate("beginn").getTime()));
			reisen[i].setDauer(rs.getInt("dauer"));
			reisen[i].setLand(rs.getString("land"));
			
			reisen[i].setPreis(rs.getDouble("preis"));
			reisen[i].setState((short) rs.getInt("state"));
			reisen[i].setTitel(rs.getString("titel"));
			reisen[i].setBeschreibung(rs.getString("beschreibung"));
			
		}
		
		rs.close();
		con.close();
		
		return reisen[0];
	}
}

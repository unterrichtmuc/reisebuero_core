package de.cmt.reisebuero.core.kunde;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KundeSqlHelper 
{
	/**
	 * Create method for the Customer
	 * 
	 * @param con The database connection
	 * @param kunde Der Kunde ohne ID!!!!
	 * @return Kunde mit ID
	 * 
	 * @throws SQLException Wenn etwas
	 */
	public static Kunde create(Connection con, Kunde kunde) throws SQLException {
		String sql = "INSERT into kunden "
				+ "(vorname, nachname, benutzername, passwort, geburtsdatum, plz, state) "
				+ "VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		ps.setString(1, kunde.getVorname());
		ps.setString(2, kunde.getNachname());
		ps.setString(3, kunde.getBenutzername());
		ps.setString(4, kunde.getPassword());
		ps.setDate(5, new java.sql.Date(kunde.getGeburtsdatum().getTime()));
		ps.setString(6, kunde.getPlz());
		ps.setInt(7, kunde.getState());
		
		ps.execute();
		
		ResultSet rs = ps.getGeneratedKeys();
		
		rs.next();
		
		kunde.setId(rs.getInt(1));
		
		rs.close();
		con.close();

		return kunde;
	}
	
	public static final int ALL_KUNDEN = -1;
	
	public static Kunde[] getKunden(Connection con, int status) throws SQLException, Exception {
		String sql = "SELECT * FROM kunden";
		
		if (status != ALL_KUNDEN) {
			sql += " WHERE state = ?";
		}
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		if (status != ALL_KUNDEN) {
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
		
		Kunde[] kunden = new Kunde[count];
		
		for (int i = 0; i < kunden.length; i++)
		{
			rs.next();
			
			kunden[i] = new Kunde(rs.getString("nachname"));
			
			kunden[i].setId(rs.getInt("id"));
			kunden[i].setVorname(rs.getString("vorname"));
			kunden[i].setBenutzername(rs.getString("benutzername"));
			kunden[i].setPassword(rs.getString("passwort"));
			
			kunden[i].setGeburtsdatum(new java.util.Date(rs.getDate("geburtsdatum").getTime()));
			kunden[i].setPlz(rs.getString("plz"));
			kunden[i].setState(rs.getInt("state"));
		}
		
		rs.close();
		con.close();
		
		return kunden;
	}
}

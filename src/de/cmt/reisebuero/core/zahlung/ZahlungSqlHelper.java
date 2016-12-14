package de.cmt.reisebuero.core.zahlung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZahlungSqlHelper 
{
	/**
	 * Create method for the Customer
	 * 
	 * @param con The database connection
	 * @param buchung Der Kunde ohne ID!!!!
	 * @return Kunde mit ID
	 * 
	 * @throws SQLException Wenn etwas
	 */
	public static Zahlung create(Connection con, Zahlung zahlung) throws SQLException {
		String sql = "INSERT into zahlungen "
				+ "(buchung_id, zahlungs_datum, bezahlt, state) "
				+ "VALUES "
				+ "(?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		ps.setInt(1, zahlung.getBuchungId());
		ps.setDate(2, new java.sql.Date(zahlung.getZahlungsDatum().getTime()));
		ps.setInt(3, zahlung.isBezahlt() ? 1 : 0);
		ps.setInt(4, zahlung.getState());
		
		ps.execute();
		
		ResultSet rs = ps.getGeneratedKeys();
		
		rs.next();
		
		zahlung.setId(rs.getInt(1));
		
		rs.close();
		con.close();

		return zahlung;
	}
	
	public static final int ALL_KUNDEN = -1;
	
	/*public static Kunde[] getKunden(Connection con, int status) throws SQLException, Exception {
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
	}*/
}

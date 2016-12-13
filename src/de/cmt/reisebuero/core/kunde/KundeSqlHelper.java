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
}

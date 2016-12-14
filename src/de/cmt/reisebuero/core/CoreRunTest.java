package de.cmt.reisebuero.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import de.cmt.reisebuero.core.buchung.Buchung;
import de.cmt.reisebuero.core.buchung.BuchungSqlHelper;
import de.cmt.reisebuero.core.buchung.BuchungState;
import de.cmt.reisebuero.core.reise.Reise;
import de.cmt.reisebuero.core.reise.ReiseArt;
import de.cmt.reisebuero.core.reise.ReiseSqlHelper;
import de.cmt.reisebuero.core.reise.ReiseState;
import de.cmt.reisebuero.core.zahlung.Zahlung;
import de.cmt.reisebuero.core.zahlung.ZahlungSqlHelper;
import de.cmt.reisebuero.core.zahlung.ZahlungState;

public class CoreRunTest {

	public static void main(String[] args) {
		Reise reise = new Reise();
		//buchung();
		zahlung();

		reise.setArt(ReiseArt.KULTURREISE);
		reise.setBeginn(new Date());
		reise.setBeschreibung("Rom");
		reise.setDauer(5);
		reise.setLand("Italien");
		reise.setPreis(899.99);
		reise.setState((short) ReiseState.SICHTBAR);
		reise.setTitel("Rom Kulturreise");
		Connection con = DbHelper.get();
		/*try {
			ReiseSqlHelper.create(con, reise);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public static void buchung() {
		Buchung buchung = new Buchung(1, 7);

		buchung.setBuchungsDatum(new Date());
		buchung.setPersonen(3);
		buchung.setGesamtPreis(2000.01);
		buchung.setState(BuchungState.AKTIV);
		Connection con = DbHelper.get();
		try {
			BuchungSqlHelper.create(con, buchung);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void zahlung() {
		Zahlung zahlung = new Zahlung();
		zahlung.setBuchungId(1);
		zahlung.setZahlungsDatum(new Date());
		zahlung.setBezahlt(true);
		zahlung.setState(ZahlungState.AKTIV);
		
		Connection con = DbHelper.get();
		try {
			ZahlungSqlHelper.create(con, zahlung);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}

package de.cmt.reisebuero.core.buchung;

import java.util.Date;

public class Buchung {
	private int id;
	private int reiseId;
	private int kundeId;
	private Date buchungsDatum;
	private int personen;
	private double gesamtPreis;
	private int state;
		
	public Buchung(int reiseId, int kundeId) {
		super();
		this.reiseId = reiseId;
		this.kundeId = kundeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReiseId() {
		return reiseId;
	}

	public void setReiseId(int reiseId) {
		this.reiseId = reiseId;
	}

	public int getKundeId() {
		return kundeId;
	}

	public void setKundeId(int kundeId) {
		this.kundeId = kundeId;
	}

	public Date getBuchungsDatum() {
		return buchungsDatum;
	}

	public void setBuchungsDatum(Date buchungsDatum) {
		this.buchungsDatum = buchungsDatum;
	}

	public int getPersonen() {
		return personen;
	}

	public void setPersonen(int personen) {
		this.personen = personen;
	}

	public double getGesamtPreis() {
		return gesamtPreis;
	}

	public void setGesamtPreis(double gesamtPreis) {
		this.gesamtPreis = gesamtPreis;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
		

}

package de.cmt.reisebuero.core.zahlung;

import java.util.Date;

public class Zahlung {
	private int id;
	private int buchungId;
	private Date zahlungsDatum;
	private boolean bezahlt;
	private int state;
	public Zahlung(int id, int buchungId, Date zahlungsDatum, boolean bezahlt, int state) {
		super();
		this.id = id;
		this.buchungId = buchungId;
		this.zahlungsDatum = zahlungsDatum;
		this.bezahlt = bezahlt;
		this.state = state;
	}
	public Zahlung() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuchungId() {
		return buchungId;
	}
	public void setBuchungId(int buchungId) {
		this.buchungId = buchungId;
	}
	public Date getZahlungsDatum() {
		return zahlungsDatum;
	}
	public void setZahlungsDatum(Date zahlungsDatum) {
		this.zahlungsDatum = zahlungsDatum;
	}
	public boolean isBezahlt() {
		return bezahlt;
	}
	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
		
	
		

}

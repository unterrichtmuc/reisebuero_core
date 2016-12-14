package de.cmt.reisebuero.core.reise;

import java.util.Date;

public class Reise {
	private int id;
	private String titel;
	private String beschreibung;
	private Date beginn;
	private int dauer;
	private int art;
	private double preis;
	private String land;
	private short state;
		
	
	public Reise() {
		super();
	}
	public Reise(String titel, Date beginn, int dauer) {
		super();
		this.titel = titel;
		this.beginn = beginn;
		this.dauer = dauer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Date getBeginn() {
		return beginn;
	}
	public void setBeginn(Date beginn) {
		this.beginn = beginn;
	}
	public int getDauer() {
		return dauer;
	}
	public void setDauer(int dauer) {
		this.dauer = dauer;
	}
	public int getArt() {
		return art;
	}
	public void setArt(int art) {
		this.art = art;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public short getState() {
		return state;
	}
	public void setState(short state) {
		this.state = state;
	}
	
	

}

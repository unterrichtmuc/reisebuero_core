package de.cmt.reisebuero.core.kunde;

import java.util.Date;

import de.cmt.reisebuero.core.exception.InvalidAttributeValueException;

public class Kunde {

	private int id;
	
	// Änderung in Branch FeatureX
	private String vorname;
	
	// Required, Min-Length 2, Max-Length 255
	private String nachname;
	
	private String benutzername;
	
	private String password;
	
	// Required, Format XYDate
	private Date geburtsdatum;
	
	private String plz;
	
	private int state;	
	
	public Kunde(String nachname) throws InvalidAttributeValueException {
		super();
		this.setNachname(nachname);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) throws InvalidAttributeValueException {
		if (nachname.length() < 2) {
			throw new InvalidAttributeValueException("Invalid value for nachname"); 	
		}
		
		this.nachname = nachname;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	
	public String toString() {
		return "" + id;
	}
}

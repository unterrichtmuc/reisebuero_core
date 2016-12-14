package de.cmt.reisebuero.core.kunde;

public class KundeState {
	
	public static final int AKTIV = 1;

	public static final int INAKTIV = 0;
	
	public static final int ARCHIVIERT = 2;
	
	public static final int GELOESCHT = 3;
	
	public static String getText(int state) {
		if (state == AKTIV) {
			return "Aktiv";
		}
		
		//@todo andere Werte
		return "Inaktiv";
	}
}

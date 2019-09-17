package buchhaltung.klassen;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.*;

public class Konto {

	private String kontoBezeichnung;
	private int kontoId;
	private double anfangsbestand;
	private double endbestand;
	private List<BuchungsSatz> buchungen = new ArrayList<BuchungsSatz>();




	public void buchen(double wert, Beleg beleg, String position) {
			BuchungsSatz bs= new BuchungsSatz(wert,beleg,position);
			buchungen.add(bs);
	}

	public String getKontoBezeichnung() {
		return kontoBezeichnung;
	}
	public int getKontoId() {
		return kontoId;
	}
	public double getAnfangsbestand() {
		return anfangsbestand;
	}
	public double getEndbestand() {
		return endbestand;
	}
	public void setKontoBezeichnung(String kontoBezeichnung) {
		this.kontoBezeichnung = kontoBezeichnung;
	}
	public void setAnfangsbestand() {
		anfangsbestand = 0.00;
	}

	public String getKontoArt() {
		return ((getKontoId() > 4999) && (getKontoId() < 8000)) ? "Aufwandskonto" : "Erfolgskonto";
	}
	

	
	public Konto(String kontoBezeichnung, int kontoId) {
		this.kontoBezeichnung = kontoBezeichnung;
		this.kontoId = kontoId;
		setAnfangsbestand();
		System.out.print("Kontoerstellung:");
		System.out.println(toString());
		
	}
	
	@Override
	public String toString() {
		String buchus=  buchungen.stream().reduce("", (acc,bs) -> acc + BuchungsEintrag(bs)+"\n", String::concat );
		return MessageFormat.format(" [Kontonummer = {0}, Bezeichnung = {1}, AB = {2}] \nVorgaenge:\n{3}]", kontoId, kontoBezeichnung, anfangsbestand, buchus);
	}
		
	public static  String BuchungsEintrag(BuchungsSatz bs){
		return MessageFormat.format("{0} {1}", bs.getPosition(), formattedDoubleString(bs.getWert()));
	}

	public static String formattedDoubleString(double wert) {
		DecimalFormat newFormat = new DecimalFormat("#.00");

		return newFormat.format(wert);
	}


}



































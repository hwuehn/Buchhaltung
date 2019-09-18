package buchhaltung.klassen;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.*;

public class Konto {

	private String kontoBezeichnung;
	private int kontoId;
	private double anfangsbestand;
	private double endbestand;

	public int getKontoId() {
		return kontoId;
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
		System.out.println(ausgabe());
		
	}

	public String ausgabe() {
		return MessageFormat.format(" [Kontonummer = {0}, Bezeichnung = {1}, AB = {2}]", kontoId, kontoBezeichnung, anfangsbestand);
	}

	@Override
	public String toString() {
		String buchus=  Buchungsverwaltung.getBuchungen().stream().reduce("", (acc,bs) -> acc + BuchungsEintrag(bs)+"\n", String::concat );
		return MessageFormat.format("Soll       {0} {1}        Haben \n" +
				                            "----------------------------------------- \n" +
				                            "AB                {2} |                   \n" +
				                            "            {3} |                         \n",
				                    kontoId, kontoBezeichnung, anfangsbestand, buchus);
	}
		
	public static  String BuchungsEintrag(BuchungsSatz bs){
		return MessageFormat.format("{0} {1}", bs.getPosition(), formattedDoubleString(bs.getWert()));
	}

	public static String formattedDoubleString(double wert) {
		DecimalFormat newFormat = new DecimalFormat("#.00");

		return newFormat.format(wert);
	}


}



































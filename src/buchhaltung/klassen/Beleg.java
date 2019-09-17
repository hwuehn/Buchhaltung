package buchhaltung.klassen;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Beleg {

	public static int counter = 1;
	
	private String artikelBezeichnung;
	private int artikelMenge;
	private double artikelPreis;
	private Calendar datum;
	private double gesamtpreisNetto;
	private double vorsteuer;
	private double endpreisBrutto;
	
	
	public String getArtikelBezeichnung() {
		return artikelBezeichnung;
	}
	public int getArtikelMenge() {
		return artikelMenge;
	}
	public double getArtikelPreis() {
		return artikelPreis;
	}
	public Calendar getDatum() {
		return datum;
	}
	public double getGesamtpreisNetto() {
		return gesamtpreisNetto;
	}
	public double getVorsteuer() {
		return vorsteuer;
	}
	public double getEndpreisBrutto() {
		return endpreisBrutto;
	}
	public void setArtikelBezeichnung(String artikelBezeichnung) {
		this.artikelBezeichnung = artikelBezeichnung;
	}
	public void setArtikelMenge(int artikelMenge) {
		this.artikelMenge = artikelMenge;
	}
	public void setArtikelPreis(double artikelPreis) {
		this.artikelPreis = artikelPreis;
		
	}
	public void setDatum(Calendar datum) {
		this.datum = datum;
	}
	public void setGesamtpreisNetto() {
		gesamtpreisNetto = getArtikelPreis() * getArtikelMenge();
	}
	public void setVorsteuer() {
		
		vorsteuer = 1.19 * getGesamtpreisNetto() - getGesamtpreisNetto();
		
	}
	public void setEndpreisBrutto() {
		endpreisBrutto = getGesamtpreisNetto() + getVorsteuer();
	}

	public Beleg(String artikelBezeichnung, int artikelMenge, double artikelPreis) {
		this.artikelBezeichnung = artikelBezeichnung;
		this.artikelMenge = artikelMenge;
		this.artikelPreis = artikelPreis;
		setGesamtpreisNetto();
		setVorsteuer();
		setEndpreisBrutto();
		System.out.print("Rechnung ");
		System.out.println(toString());
		counter++;
	}
	@Override
	public String toString() {
		return counter + ":" + " [Artikel = " + artikelBezeichnung + ", Menge = " + artikelMenge 
				+ ", Preis = " + artikelPreis + ", Gesamtpreis=" + formatZweiStellenNachkomma(gesamtpreisNetto) + ", Vorsteuer=" + formatZweiStellenNachkomma(vorsteuer)
				+ ", Endpreis=" + formatZweiStellenNachkomma(endpreisBrutto)  + "]";
	}
	
	public String formatZweiStellenNachkomma(double value) {
		String neuerWert = "";
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		for (Number n : Arrays.asList(value)) {
			Double d = n.doubleValue();	
			neuerWert = df.format(d);
		}
		return neuerWert;
		
			    
		} 
	}
	
	
	


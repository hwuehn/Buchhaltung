package data;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

public class Rechnung {



	private String artikelBezeichnung;
	private int artikelMenge;
	private double artikelPreis;
	private LocalDate datum;
	private double gesamtpreisNetto;
	private double vorsteuer;
	private double endpreisBrutto;
	private int rechnungsNr;

	public int getRechnungsNr() {
		return rechnungsNr;
	}
	public String getArtikelBezeichnung() {
		return artikelBezeichnung;
	}
	public int getArtikelMenge() {
		return artikelMenge;
	}
	public double getArtikelPreis() {
		return artikelPreis;
	}
	public LocalDate getDatum() {
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
	public void setGesamtpreisNetto() {
		gesamtpreisNetto = getArtikelPreis() * getArtikelMenge();
	}
	public void setVorsteuer() {
		
		vorsteuer = 1.19 * getGesamtpreisNetto() - getGesamtpreisNetto();
		
	}
	public void setEndpreisBrutto() {
		endpreisBrutto = getGesamtpreisNetto() + getVorsteuer();
	}

	public Rechnung(LocalDate datum, int rechnungsNr, String artikelBezeichnung, int artikelMenge, double artikelPreis) {
		this.datum = datum;
	    this.artikelBezeichnung = artikelBezeichnung;
		this.artikelMenge = artikelMenge;
		this.artikelPreis = artikelPreis;
		setGesamtpreisNetto();
		setVorsteuer();
		setEndpreisBrutto();
		this.rechnungsNr = rechnungsNr;
		System.out.println(toString());
	}
	@Override
	public String toString() {
		return "Rechnung: " + " [Rechnugsdatum = " + datum + ", Artikel = " + artikelBezeichnung + ", Menge = " + artikelMenge
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
	
	
	


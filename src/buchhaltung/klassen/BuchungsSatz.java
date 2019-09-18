package buchhaltung.klassen;

import java.util.List;

public class BuchungsSatz {

	private double wert;
    private Rechnung rechnungNr;
    private String position;
    private Konto gegenKontoID;

    /*public BuchungsSatz(double wert, Rechnung rechnungNr, String position, Konto gegenKontoID) {
        this.wert = wert;
        this.rechnungNr = rechnungNr;
        this.position = position;
        this.gegenKontoID = gegenKontoID;
    }*/

    public BuchungsSatz(Buchungsverwaltung konto, List<Position> positions, Seite seite) {

    }


        //public void buchen(double wert, Rechnung rechnung, String position, Konto gegenKontoId) {
        //    BuchungsSatz bs= new BuchungsSatz(wert, rechnung, position, gegenKontoId);
        //    buchungen.add(bs);
        //}
        // kontoId, betrag, rechnungsNr, gegenKontoId
        //Rechnung b1= belege.belege.get(0);
		/*_6330.buchen(b1.getGesamtpreisNetto(), b1,"GesamtPreisNetto");
		_1400.buchen(b1.getVorsteuer(), b1,"Vorsteuer");
		_1800.buchen(- b1.getEndpreisBrutto(), b1,"EndPreisBrutto");
		*/



    public double getWert() {
        return wert;
    }

    public String getPosition() {
        return position;
    }
}

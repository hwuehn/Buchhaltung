package buchhaltung.klassen;

public class BuchungsSatz {

	private double wert;
    private Beleg beleg;
    private String position;
    private Konto gegenKontoID;

    public BuchungsSatz(double wert, Beleg beleg, String position, Konto gegenKontoID) {
        this.wert = wert;
        this.beleg = beleg;
        this.position = position;
        this.gegenKontoID = gegenKontoID;
    }

    public double getWert() {
        return wert;
    }

    public String getPosition() {
        return position;
    }
}

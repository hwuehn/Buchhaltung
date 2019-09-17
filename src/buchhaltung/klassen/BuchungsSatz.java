package buchhaltung.klassen;

public class BuchungsSatz {

	private double wert;
    private Beleg beleg;
    private String position;

    public BuchungsSatz(double wert, Beleg beleg, String position) {
        this.wert = wert;
        this.beleg = beleg;
        this.position = position;

	}

    public double getWert() {
        return wert;
    }

    public String getPosition() {
        return position;
    }
}

package buchhaltung.klassen;

import java.util.ArrayList;

public class BuchungsSatz {

    private Buchungsverwaltung konto;
    private final ArrayList<Position> positions;
    private final Seite seite;

    public BuchungsSatz(Buchungsverwaltung konto, ArrayList<Position> positions, Seite seite) {
        this.konto = konto;
        this.positions = positions;
        this.seite = seite;
    }

    public double getWert() {
        positions.

        return wert;
    }

    public String getPosition() {
        return position;
    }
}

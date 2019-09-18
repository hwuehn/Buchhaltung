package buchhaltung.klassen;

import java.util.ArrayList;
import java.util.List;

public class Buchungsverwaltung {

    private static List<BuchungsSatz> buchungen = new ArrayList<>();

    public static List<BuchungsSatz> getBuchungen() {
        return buchungen;
    }

    public void buchen(List<Position> positions) {
        BuchungsSatz bs1 = new BuchungsSatz(this,  positions, Seite.SOLL);
        BuchungsSatz bs2 = new BuchungsSatz(this,  positions, Seite.HABEN);
    }
}

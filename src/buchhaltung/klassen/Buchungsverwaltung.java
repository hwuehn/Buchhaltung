package buchhaltung.klassen;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Buchungsverwaltung {

    private static List<BuchungsSatz> buchungen = new ArrayList<>();

    public static List<BuchungsSatz> getBuchungen() {
        return buchungen;
    }

    public void buchen(Konto kontoSoll, Konto gegenKonto, List<Position> positions, Seite seite) {
        BuchungsSatz bs1 = new BuchungsSatz(kontoSoll, positions, Seite.SOLL);
        BuchungsSatz bs2 = new BuchungsSatz(gegenKonto, positions, Seite.HABEN);
        buchungen.add(bs1);
        buchungen.add(bs2);
    }

    @Override
    public String toString() {
        String buchus=  Buchungsverwaltung.getBuchungen().stream().reduce("", (acc,bs) -> acc + BuchungsEintrag(bs)+"\n", String::concat );
        return MessageFormat.format("Buchung: {0} {1} {2} \n", Konto.getKontoId(), Konto.getKontoBezeichnung(), buchus);
    }

    public static  String BuchungsEintrag(BuchungsSatz bs){
        return MessageFormat.format("{0}",  formattedDoubleString(bs.gesamtWert()));
    }

    public static String formattedDoubleString(double wert) {
        DecimalFormat newFormat = new DecimalFormat("#.00");

        return newFormat.format(wert);
    }

}

package application;

import data.Konto;
import data.Position;
import data.Seite;
import de.company.buchhaltung.data.BuchungsSatz;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Buchungsverwaltung {

    private List<BuchungsSatz> buchungen=new ArrayList<>();

    public List<BuchungsSatz> getBuchungen() {
        return buchungen;
    }

    public void buchen(Konto kontoSoll, Konto gegenKonto, List<Position> positions) {
        int max = buchungen.stream().map(b -> b.getBuchungsid()).mapToInt(i -> i).max().orElse(0);
        System.out.println(max);
        BuchungsSatz bs1 = new BuchungsSatz(kontoSoll, positions, Seite.SOLL,max +1);
        BuchungsSatz bs2 = new BuchungsSatz(gegenKonto, positions, Seite.HABEN,max +1);
        buchungen.add(bs1);
        buchungen.add(bs2);
    }

    @Override
    public String toString() {
        String buchus=  buchungen.stream().reduce("", (acc,bs) -> acc + bs.toString()+"\n", String::concat );
        return MessageFormat.format("Buchungen:\n{0}", buchus);
    }

    public static String formattedDoubleString(double wert) {
        DecimalFormat newFormat = new DecimalFormat("#.00");
        return newFormat.format(wert);
    }

}

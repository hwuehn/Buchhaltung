package de.company.buchhaltung.data;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;


public class BuchungsSatz {

    private final data.Konto konto;
    private final List<data.Position> positions;
    private final data.Seite seite;
    private final int buchungsid;

    public data.Konto getKonto() {
        return konto;
    }
    public List<data.Position> getPositions() {
        return positions;
    }

    public int getBuchungsid() {
        return buchungsid;
    }

    public BuchungsSatz(data.Konto konto, List<data.Position> positions, data.Seite seite, int buchungsid) {
        this.konto = konto;
        this.positions = positions;
        this.seite = seite;
        this.buchungsid = buchungsid;
    }

    public Double gesamtWert(){
        return positions.stream().map(p -> p.getGesamtpreisNetto()).reduce(0d ,(acc,e) -> acc + e);
    }

    public String toString() {
        return MessageFormat.format("Buchung: {0} {1} {2} {3} ", konto.getKontoId(), konto.getKontoBezeichnung(), formattedDoubleString(gesamtWert()),seite);
    }

    public static String formattedDoubleString(double wert) {
        DecimalFormat newFormat = new DecimalFormat("#.00");
        return newFormat.format(wert);
    }
}
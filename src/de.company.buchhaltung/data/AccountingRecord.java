package data;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;

public class AccountingRecord {
    //private Map<Integer, String> accList = new HashMap<Integer, String>();

    //konto -> acclist key
    private final Integer konto;
    private final List<Position> positions;
    private final Seite seite;
    private final int buchungsid;

    public AccountingRecord(Integer konto, List<Position> positions, Seite seite, int buchungsid) {
        this.konto = konto;
        this.positions = positions;
        this.seite = seite;
        this.buchungsid = buchungsid;
    }

    public Integer getKonto() {
        return konto;
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

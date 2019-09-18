package buchhaltung.klassen;

import java.time.LocalDate;
import java.util.List;

public class Position  {

    private final LocalDate datum;
    private final int rechnungsNr;
    private final double gesamtpreisNetto;
    private final String artikelBezeichnung;

    public Position(LocalDate datum, int rechnungsNr, double gesamtpreisNetto, String artikelBezeichnung) {
        this.datum = datum;
        this.rechnungsNr = rechnungsNr;
        this.gesamtpreisNetto = gesamtpreisNetto;
        this.artikelBezeichnung = artikelBezeichnung;
    }
}
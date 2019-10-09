package de.company.accounting.data;

import de.company.accounting.application.AccountingAdministration;

import java.time.LocalDate;
import java.util.List;

public class Position  {

    private final LocalDate datum;
    private final int rechnungsNr;

    public double getGesamtpreisNetto() {
        return gesamtpreisNetto;
    }
    public LocalDate getDatum() { return datum; }

    private final double gesamtpreisNetto;
    private final String artikelBezeichnung;

    public Position(LocalDate datum, int rechnungsNr, double gesamtpreisNetto, String artikelBezeichnung) {
        this.datum = datum;
        this.rechnungsNr = rechnungsNr;
        this.gesamtpreisNetto = gesamtpreisNetto;
        this.artikelBezeichnung = artikelBezeichnung;
    }
}

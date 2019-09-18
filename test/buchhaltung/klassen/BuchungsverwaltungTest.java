package buchhaltung.klassen;

import buchhaltung.testdata.BelegStapel;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BuchungsverwaltungTest {

    @Test
    public void buchen() {
        Konto _1800 = new Konto("Bank", 1800);
        Konto _6330 = new Konto("Reinigung", 6330);

        Rechnung b1= new Rechnung(LocalDate.of(2019,01,01),1,"Reinigungsmittel", 2, 1.50);
        Position p1= new Position(b1.getDatum(), b1.getRechnungsNr(), b1.getGesamtpreisNetto(), b1.getArtikelBezeichnung());
        Buchungsverwaltung bv = new Buchungsverwaltung();
        bv.buchen(_6330, _1800, Arrays.asList(p1));

        BuchungsSatz bs1 = bv.getBuchungen().get(0);
        BuchungsSatz bs2 = bv.getBuchungen().get(1);
        assertEquals(bs1.gesamtWert(), 3d,0);
        assertEquals(bs2.gesamtWert(), 3d,0);
    }
}
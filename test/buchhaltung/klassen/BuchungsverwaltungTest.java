//package buchhaltung.klassen;
//
//import application.Buchungsverwaltung;
//import de.company.buchhaltung.data.BuchungsSatz;
//import org.junit.Test;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//public class BuchungsverwaltungTest {
//
//    @Test
//    public void buchen() {
//        data.Konto _1800 = new data.Konto(1800,"Bank");
//        data.Konto _6330 = new data.Konto(6330, "Reinigung");
//
//        data.Invoice b1= new data.Invoice(LocalDate.of(2019,01,01),1,"Reinigungsmittel", 2, 1.50);
//        data.Position p1= new data.Position(b1.getDatum(), b1.getRechnungsNr(), b1.getGesamtpreisNetto(), b1.getArtikelBezeichnung());
//
//        Buchungsverwaltung bv = new Buchungsverwaltung();
//        bv.buchen(_6330, _1800, Arrays.asList(p1));
//
//        BuchungsSatz bs1 = bv.getBuchungen().get(0);
//        BuchungsSatz bs2 = bv.getBuchungen().get(1);
//       // assertEquals(bs1.gesamtWert(), 3d,0);
//       // assertEquals(bs2.gesamtWert(), 3d,0);
//    }
//}
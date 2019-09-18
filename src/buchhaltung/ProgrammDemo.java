package buchhaltung;


import buchhaltung.testdata.BelegStapel;
import buchhaltung.klassen.Konto;
import buchhaltung.klassen.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgrammDemo {

	public static void main(String[] args) {
				
		KontoVerwaltung kv= new KontoVerwaltung();
		Konto _1400 = kv.createKonto("VSt", 1400);
		Konto _1800 = kv.createKonto("Bank", 1800);
		Konto _6330 = kv.createKonto("Reinigung", 6330);
		Konto _6815 = kv.createKonto("Buerobedarf", 6815);
			
		System.out.println();
		
		BelegStapel belege = new BelegStapel();
		
		System.out.println();
		Rechnung b1= belege.belege.get(0);
		Position p1= new Position(b1.getDatum(), b1.getRechnungsNr(), b1.getGesamtpreisNetto(), b1.getArtikelBezeichnung());
        Buchungsverwaltung bv = new Buchungsverwaltung();
		bv.buchen(_6330, _1800, Arrays.asList(p1));
		bv.buchen(_1400, _1800, Arrays.asList(p1));
		Rechnung b2= belege.belege.get(1);
		Position p2= new Position(b2.getDatum(), b2.getRechnungsNr(), b2.getGesamtpreisNetto(), b2.getArtikelBezeichnung());
		bv.buchen(_6815, _1800, Arrays.asList(p2));
        bv.buchen(_1400, _1800, Arrays.asList(p2));
        Rechnung b3= belege.belege.get(2);
        Position p3= new Position(b3.getDatum(), b3.getRechnungsNr(), b3.getGesamtpreisNetto(), b3.getArtikelBezeichnung());
        bv.buchen(_6815, _1800, Arrays.asList(p3));
        bv.buchen(_1400, _1800, Arrays.asList(p3));
        Rechnung b4= belege.belege.get(3);
        Position p4= new Position(b4.getDatum(), b4.getRechnungsNr(), b4.getGesamtpreisNetto(), b4.getArtikelBezeichnung());
        bv.buchen(_6815, _1800, Arrays.asList(p4));
        bv.buchen(_1400, _1800, Arrays.asList(p4));
        Rechnung b5= belege.belege.get(4);
        Position p5= new Position(b5.getDatum(), b5.getRechnungsNr(), b5.getGesamtpreisNetto(), b5.getArtikelBezeichnung());
        bv.buchen(_6815, _1800, Arrays.asList(p5));
        bv.buchen(_1400, _1800, Arrays.asList(p5));
        Rechnung b6= belege.belege.get(5);
        Position p6= new Position(b6.getDatum(), b6.getRechnungsNr(), b6.getGesamtpreisNetto(), b6.getArtikelBezeichnung());
        bv.buchen(_6815, _1800, Arrays.asList(p6));
        bv.buchen(_1400, _1800, Arrays.asList(p6));
        Rechnung b7= belege.belege.get(6);
        Position p7= new Position(b7.getDatum(), b7.getRechnungsNr(), b7.getGesamtpreisNetto(), b7.getArtikelBezeichnung());
        bv.buchen(_6330, _1800, Arrays.asList(p7));
        bv.buchen(_1400, _1800, Arrays.asList(p7));
        Rechnung b8= belege.belege.get(7);
        Position p8= new Position(b8.getDatum(), b8.getRechnungsNr(), b8.getGesamtpreisNetto(), b8.getArtikelBezeichnung());
        bv.buchen(_6815, _1800, Arrays.asList(p8));
        bv.buchen(_1400, _1800, Arrays.asList(p8));
        Rechnung b9= belege.belege.get(8);
        Position p9= new Position(b9.getDatum(), b9.getRechnungsNr(), b9.getGesamtpreisNetto(), b9.getArtikelBezeichnung());
        bv.buchen(_6815, _1800, Arrays.asList(p9));
        bv.buchen(_1400, _1800, Arrays.asList(p9));
        Rechnung b10= belege.belege.get(9);
        Position p10= new Position(b10.getDatum(), b10.getRechnungsNr(), b10.getGesamtpreisNetto(), b10.getArtikelBezeichnung());
        bv.buchen(_6815, _1800, Arrays.asList(p10));
        bv.buchen(_1400, _1800, Arrays.asList(p10));
        System.out.println(bv.toString());





		//_1400.buchenMitGegenKonto(Arrays.asList(p1), _1800);
		/*_6330.buchen(b1.getGesamtpreisNetto(), b1,"GesamtPreisNetto");
		_1400.buchen(b1.getVorsteuer(), b1,"Vorsteuer");
		_1800.buchen(- b1.getEndpreisBrutto(), b1,"EndPreisBrutto");
		*/

		//_6330.buchen(b1.getGesamtpreisNetto(), b1, "GesamtPreisNetto", _1800);



		/*Rechnung b2=belege.belege.get(1);
		_6815.buchen(b2.getGesamtpreisNetto(), b2,"GesamtPreisNetto");
		_6815.buchen(b2.getGesamtpreisNetto(), b2,"GesamtPreisNetto");
		_1400.buchen(b2.getVorsteuer(), b2,"Vorsteuer");
		_1800.buchen(- b2.getEndpreisBrutto(), b2,"EndPreisBrutto");
		System.out.println(_6815.toString());*/
	}

}

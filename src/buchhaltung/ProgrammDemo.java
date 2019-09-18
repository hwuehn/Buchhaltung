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

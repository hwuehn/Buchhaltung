package buchhaltung;


import buchhaltung.testdata.BelegStapel;
import buchhaltung.klassen.Konto;
import buchhaltung.klassen.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ProgrammDemo {

	public static void main(String[] args) {
				
		KontoVerwaltung kv= new KontoVerwaltung();
		Konto _14000= kv.createKonto("VSt", 1400);
		KontoVerwaltung kontoverw = new KontoVerwaltung();


		Konto _1400 = new Konto("VSt", 1400);
		Konto _1800 = new Konto("Bank", 1800);
		Konto _6330 = new Konto("Reinigung", 6330);
		Konto _6815 = new Konto("Buerobedarf", 6815);
			
		System.out.println();
		
		BelegStapel belege = new BelegStapel();
		
		System.out.println();
		Rechnung b1= belege.belege.get(0);
		Position p1= new Position(b1.getDatum(), b1. b1.getGesamtpreisNetto(), b1.getArtikelBezeichnung());

		_1400.buchenMitGegenKonto(Arrays.asList(p1), _1800);
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

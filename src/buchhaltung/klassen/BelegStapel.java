package buchhaltung.klassen;

import java.util.*;

public class BelegStapel {

	public List<Beleg> belege = new ArrayList<Beleg>();
	
	public BelegStapel() {
		
		belege.add(new Beleg("Reinigungsmittel", 2, 1.50));
		belege.add( new Beleg("Kasten Bier" ,1, 12.00));
		belege.add( new Beleg("Ordner", 10, 1.00));
		belege.add( new Beleg("Kugelschreiber", 20, 1.75));
		belege.add( new Beleg("Notizzettel", 1, 4.00));
		belege.add( new Beleg("Kasten Wasser", 1, 10.00));
		belege.add( new Beleg("Reinigungstabs", 1, 15.00));
		belege.add( new Beleg("Toner", 2, 40.00));
		belege.add( new Beleg("PC Maus", 1, 30.00));
		belege.add( new Beleg("Mehrfachsteckdose", 1, 11.00));
	}
}

package buchhaltung.klassen;

import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class BelegStapel {

	public List<Beleg> belege = new ArrayList<Beleg>();
	
	public BelegStapel() {
		belege.add(new Beleg(LocalDate.of(2019,01,01),"Reinigungsmittel", 2, 1.50));
		belege.add( new Beleg(LocalDate.of(2019,01,04),"Kasten Bier" ,1, 12.00));
		belege.add( new Beleg(LocalDate.of(2019,01,07),"Ordner", 10, 1.00));
		belege.add( new Beleg(LocalDate.of(2019,01,10),"Kugelschreiber", 20, 1.75));
		belege.add( new Beleg(LocalDate.of(2019,01,12), "Notizzettel", 1, 4.00));
		belege.add( new Beleg(LocalDate.of(2019,01,15),"Kasten Wasser", 1, 10.00));
		belege.add( new Beleg(LocalDate.of(2019,01,20), "Reinigungstabs", 1, 15.00));
		belege.add( new Beleg(LocalDate.of(2019,01,21),"Toner", 2, 40.00));
		belege.add( new Beleg(LocalDate.of(2019,01,25),"PC Maus", 1, 30.00));
		belege.add( new Beleg(LocalDate.of(2019,01,30),"Mehrfachsteckdose", 1, 11.00));
	}

	//public void dateFormat(LocalDate datum) {
	//	DateTimeFormatter formatPattern = new DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	//	String formattedDate = datum.format(formatPattern);
	//}
}

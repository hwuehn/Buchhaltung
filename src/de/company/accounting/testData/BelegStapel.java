package de.company.accounting.testData;

import de.company.accounting.data.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BelegStapel {

	public List<Invoice> belege = new ArrayList<Invoice>();
	
	public BelegStapel() {
		belege.add(new Invoice(LocalDate.of(2019,01,01),1,"Reinigungsmittel", 2, 1.50));
		belege.add( new Invoice(LocalDate.of(2019,01,04),2,"Kasten Bier" ,1, 12.00));
		belege.add( new Invoice(LocalDate.of(2019,01,07),3, "Ordner", 10, 1.00));
		belege.add( new Invoice(LocalDate.of(2019,01,10),4,"Kugelschreiber", 20, 1.75));
		belege.add( new Invoice(LocalDate.of(2019,01,12), 5,"Notizzettel", 1, 4.00));
		belege.add( new Invoice(LocalDate.of(2019,01,15),6,"Kasten Wasser", 1, 10.00));
		belege.add( new Invoice(LocalDate.of(2019,01,20), 7,"Reinigungstabs", 1, 15.00));
		belege.add( new Invoice(LocalDate.of(2019,01,21),8,"Toner", 2, 40.00));
		belege.add( new Invoice(LocalDate.of(2019,01,25),9,"PC Maus", 1, 30.00));
		belege.add( new Invoice(LocalDate.of(2019,01,30),10,"Mehrfachsteckdose", 1, 11.00));
	}

	//public void dateFormat(LocalDate datum) {
	//	DateTimeFormatter formatPattern = new DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	//	String formattedDate = datum.format(formatPattern);
	//}
}

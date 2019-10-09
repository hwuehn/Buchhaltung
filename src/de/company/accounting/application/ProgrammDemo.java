package de.company.accounting.application;


import de.company.accounting.data.Position;
import de.company.accounting.data.Rechnung;
import de.company.accounting.presentation.InputForm;
import de.company.accounting.presentation.MyTableModel;
import de.company.accounting.testData.BelegStapel;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ProgrammDemo {

	public static void main(String[] args) throws IOException, InvocationTargetException, InterruptedException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    AccountAdministration accountAdministration = new AccountAdministration();
        InputForm form = new InputForm(accountAdministration);

        form.table1.setModel((new MyTableModel()));




        JFrame inputFrame = new JFrame("InputFrame");
        inputFrame.setContentPane(form.getPanel());
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputFrame.pack();
        inputFrame.setVisible(true);

        accountAdministration.load();
        form.fillCombos(accountAdministration.getSortedList());


    	BelegStapel belege = new BelegStapel();
        System.out.println();

        Rechnung b1 = belege.belege.get(0);
		Position p1= new Position(b1.getDatum(), b1.getRechnungsNr(), b1.getGesamtpreisNetto(), b1.getArtikelBezeichnung());
        Buchungsverwaltung bv = new Buchungsverwaltung();
//		bv.buchen(_6330, _1800, Arrays.asList(p1));
//		bv.buchen(_1400, _1800, Arrays.asList(p1));
//		Rechnung b2= belege.belege.get(1);
//		Position p2= new Position(b2.getDatum(), b2.getRechnungsNr(), b2.getGesamtpreisNetto(), b2.getArtikelBezeichnung());
//		bv.buchen(_6815, _1800, Arrays.asList(p2));
//        bv.buchen(_1400, _1800, Arrays.asList(p2));
//        Rechnung b3= belege.belege.get(2);
//        Position p3= new Position(b3.getDatum(), b3.getRechnungsNr(), b3.getGesamtpreisNetto(), b3.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p3));
//        bv.buchen(_1400, _1800, Arrays.asList(p3));
//        Rechnung b4= belege.belege.get(3);
//        Position p4= new Position(b4.getDatum(), b4.getRechnungsNr(), b4.getGesamtpreisNetto(), b4.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p4));
//        bv.buchen(_1400, _1800, Arrays.asList(p4));
//        Rechnung b5= belege.belege.get(4);
//        Position p5= new Position(b5.getDatum(), b5.getRechnungsNr(), b5.getGesamtpreisNetto(), b5.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p5));
//        bv.buchen(_1400, _1800, Arrays.asList(p5));
//        Rechnung b6= belege.belege.get(5);
//        Position p6= new Position(b6.getDatum(), b6.getRechnungsNr(), b6.getGesamtpreisNetto(), b6.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p6));
//        bv.buchen(_1400, _1800, Arrays.asList(p6));
//        Rechnung b7= belege.belege.get(6);
//        Position p7= new Position(b7.getDatum(), b7.getRechnungsNr(), b7.getGesamtpreisNetto(), b7.getArtikelBezeichnung());
//        bv.buchen(_6330, _1800, Arrays.asList(p7));
//        bv.buchen(_1400, _1800, Arrays.asList(p7));
//        Rechnung b8= belege.belege.get(7);
//        Position p8= new Position(b8.getDatum(), b8.getRechnungsNr(), b8.getGesamtpreisNetto(), b8.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p8));
//        bv.buchen(_1400, _1800, Arrays.asList(p8));
//        Rechnung b9= belege.belege.get(8);
//        Position p9= new Position(b9.getDatum(), b9.getRechnungsNr(), b9.getGesamtpreisNetto(), b9.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p9));
//        bv.buchen(_1400, _1800, Arrays.asList(p9));
//        Rechnung b10= belege.belege.get(9);
//        Position p10= new Position(b10.getDatum(), b10.getRechnungsNr(), b10.getGesamtpreisNetto(), b10.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p10));
//        bv.buchen(_1400, _1800, Arrays.asList(p10));
//        System.out.println(bv.toString());
//
//        System.out.println(_1400.toString());
//        System.out.println(Konto.ausgabeKontoBuchungen(bv.getBuchungen(),_1800));
//        System.out.println(Konto.ausgabeKontoBuchungen(bv.getBuchungen(),_6815));
//
//        System.out.println(_1800.toString());
//        System.out.println(_6330.toString());
//        System.out.println(_6815.toString());

	}
}

package de.company.accounting.application;

import de.company.accounting.data.Invoice;
import de.company.accounting.presentation.InputForm;
import de.company.accounting.presentation.MyTableModel;
import de.company.accounting.presentation.EvenOddRenderer;
import de.company.accounting.testData.documentStack;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ProgrammDemo {

	public static void main(String[] args) throws IOException, InvocationTargetException, InterruptedException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        //invoke administration
        AccountAdministration accountAdministration = new AccountAdministration();
        AccountingAdministration accountingAdministration = new AccountingAdministration();

	    //invoke objects with API
	    InputForm inputForm = new InputForm(accountAdministration, accountingAdministration);
        MyTableModel myTableModel = new MyTableModel(accountAdministration, accountingAdministration);

        inputForm.table1.setModel((myTableModel));
        inputForm.table1.setDefaultRenderer(Object.class, new EvenOddRenderer());

        JFrame inputFrame = new JFrame("InputFrame");
        inputFrame.setContentPane(inputForm.getPanel());
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputFrame.pack();
        inputFrame.setVisible(true);

        accountAdministration.load();
        inputForm.fillCombos(accountAdministration.getSortedList());

    	documentStack belege = new documentStack();
        System.out.println();

        Invoice b1 = belege.document.get(0);
		//Position p1= new Position(b1.getDatum(), b1.getRechnungsNr(), b1.getGesamtpreisNetto(), b1.getArtikelBezeichnung());
        //Buchungsverwaltung bv = new Buchungsverwaltung();
//		bv.buchen(_6330, _1800, Arrays.asList(p1));
//		bv.buchen(_1400, _1800, Arrays.asList(p1));
//		Invoice b2= belege.belege.get(1);
//		Position p2= new Position(b2.getDatum(), b2.getRechnungsNr(), b2.getGesamtpreisNetto(), b2.getArtikelBezeichnung());
//		bv.buchen(_6815, _1800, Arrays.asList(p2));
//        bv.buchen(_1400, _1800, Arrays.asList(p2));
//        Invoice b3= belege.belege.get(2);
//        Position p3= new Position(b3.getDatum(), b3.getRechnungsNr(), b3.getGesamtpreisNetto(), b3.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p3));
//        bv.buchen(_1400, _1800, Arrays.asList(p3));
//        Invoice b4= belege.belege.get(3);
//        Position p4= new Position(b4.getDatum(), b4.getRechnungsNr(), b4.getGesamtpreisNetto(), b4.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p4));
//        bv.buchen(_1400, _1800, Arrays.asList(p4));
//        Invoice b5= belege.belege.get(4);
//        Position p5= new Position(b5.getDatum(), b5.getRechnungsNr(), b5.getGesamtpreisNetto(), b5.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p5));
//        bv.buchen(_1400, _1800, Arrays.asList(p5));
//        Invoice b6= belege.belege.get(5);
//        Position p6= new Position(b6.getDatum(), b6.getRechnungsNr(), b6.getGesamtpreisNetto(), b6.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p6));
//        bv.buchen(_1400, _1800, Arrays.asList(p6));
//        Invoice b7= belege.belege.get(6);
//        Position p7= new Position(b7.getDatum(), b7.getRechnungsNr(), b7.getGesamtpreisNetto(), b7.getArtikelBezeichnung());
//        bv.buchen(_6330, _1800, Arrays.asList(p7));
//        bv.buchen(_1400, _1800, Arrays.asList(p7));
//        Invoice b8= belege.belege.get(7);
//        Position p8= new Position(b8.getDatum(), b8.getRechnungsNr(), b8.getGesamtpreisNetto(), b8.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p8));
//        bv.buchen(_1400, _1800, Arrays.asList(p8));
//        Invoice b9= belege.belege.get(8);
//        Position p9= new Position(b9.getDatum(), b9.getRechnungsNr(), b9.getGesamtpreisNetto(), b9.getArtikelBezeichnung());
//        bv.buchen(_6815, _1800, Arrays.asList(p9));
//        bv.buchen(_1400, _1800, Arrays.asList(p9));
//        Invoice b10= belege.belege.get(9);
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

package de.company.accounting.application;

import de.company.accounting.data.Invoice;
import de.company.accounting.data.Position;
import de.company.accounting.presentation.EvenOddRenderer;
import de.company.accounting.presentation.InputForm;
import de.company.accounting.presentation.MyTableModel;
import de.company.accounting.testData.documentStack;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws IOException, InvocationTargetException, InterruptedException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        //invoke administration
        AccountAdministration accountAdministration = new AccountAdministration();
        AccountingAdministration accountingAdministration = new AccountingAdministration();
       
	    //invoke objects with API
        MyTableModel myTableModel = new MyTableModel(accountAdministration, accountingAdministration);
        InputForm inputForm = new InputForm(accountAdministration, accountingAdministration, myTableModel);

        inputForm.table1.setModel((myTableModel));
        inputForm.table1.setDefaultRenderer(Object.class, new EvenOddRenderer());

        JFrame inputFrame = new JFrame("InputFrame");
        inputFrame.setContentPane(inputForm.getPanel());
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputFrame.pack();
        inputFrame.setVisible(true);

        accountAdministration.load();
        //inputForm.fillCombos(accountAdministration.getSortedList());
        inputForm.fillCombos2(accountAdministration.sortAccList());

        documentStack belege = new documentStack();
        System.out.println();

        System.out.print(accountAdministration.sortAccList());

        Invoice b1 = belege.document.get(0);
		Position p1= new Position(b1.getDate(), b1.getDocumentNumber(), b1.getTotalNetPrice(), b1.getArticleDescription());
//        accountingAdministration.bookings(6330 , 1800, Arrays.asList(p1));
//		accountingAdministration.bookings(_1400, _1800, Arrays.asList(p1));
//		Invoice b2= belege.document.get(1);
//		Position p2= new Position(b2.getDate(), b2.getDocumentNumber(), b2.getTotalNetPrice(), b2.getArticleDescription());
//		accountingAdministration.bookings(_6815, _1800, Arrays.asList(p2));
//        accountingAdministration.bookings(_1400, _1800, Arrays.asList(p2));
//        Invoice b3= belege.document.get(2);
//        Position p3= new Position(b3.getDate(), b3.getDocumentNumber(), b3.getTotalNetPrice(), b3.getArticleDescription());
//        accountingAdministration.bookings(_6815, _1800, Arrays.asList(p3));
//        accountingAdministration.bookings(_1400, _1800, Arrays.asList(p3));
//        Invoice b4= belege.document.get(3);
//        Position p4= new Position(b4.getDate(), b4.getDocumentNumber(), b4.getTotalNetPrice(), b4.getArticleDescription());
//        accountingAdministration.bookings(_6815, _1800, Arrays.asList(p4));
//        accountingAdministration.bookings(_1400, _1800, Arrays.asList(p4));
//        Invoice b5= belege.document.get(4);
//        Position p5= new Position(b5.getDate(), b5.getDocumentNumber(), b5.getTotalNetPrice(), b5.getArticleDescription());
//        accountingAdministration.bookings(_6815, _1800, Arrays.asList(p5));
//        accountingAdministration.bookings(_1400, _1800, Arrays.asList(p5));
//        Invoice b6= belege.document.get(5);
//        Position p6= new Position(b6.getDate(), b6.getDocumentNumber(), b6.getTotalNetPrice(), b6.getArticleDescription());
//        accountingAdministration.bookings(_6815, _1800, Arrays.asList(p6));
//        accountingAdministration.bookings(_1400, _1800, Arrays.asList(p6));
//        Invoice b7= belege.document.get(6);
//        Position p7= new Position(b7.getDate(), b7.getDocumentNumber(), b7.getTotalNetPrice(), b7.getArticleDescription());
//        accountingAdministration.bookings(_6330, _1800, Arrays.asList(p7));
//        accountingAdministration.bookings(_1400, _1800, Arrays.asList(p7));
//        Invoice b8= belege.document.get(7);
//        Position p8= new Position(b8.getDate(), b8.getDocumentNumber(), b8.getTotalNetPrice(), b8.getArticleDescription());
//        accountingAdministration.bookings(_6815, _1800, Arrays.asList(p8));
//        accountingAdministration.bookings(_1400, _1800, Arrays.asList(p8));
//        Invoice b9= belege.document.get(8);
//        Position p9= new Position(b9.getDate(), b9.getDocumentNumber(), b9.getTotalNetPrice(), b9.getArticleDescription());
//        accountingAdministration.bookings(_6815, _1800, Arrays.asList(p9));
//        accountingAdministration.bookings(_1400, _1800, Arrays.asList(p9));
//        Invoice b10= belege.document.get(9);
//        Position p10= new Position(b10.getDate(), b10.getDocumentNumber(), b10.getTotalNetPrice(), b10.getArticleDescription());
//        accountingAdministration.bookings(_6815, _1800, Arrays.asList(p10));
//        accountingAdministration.bookings(_1400, _1800, Arrays.asList(p10));
//        System.out.println(accountingAdministration.toString());
//
//        System.out.println(_1400.toString());
//        System.out.println(Account.outputAccountBookings(accountingAdministration.getBookings(),_1800));
//        System.out.println(Account.outputAccountBookings(accountingAdministration.getBookings(),_6815));
//
//        System.out.println(_1800.toString());
//        System.out.println(_6330.toString());
//        System.out.println(_6815.toString());

	}
}

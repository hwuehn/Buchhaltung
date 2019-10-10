package de.company.accounting.presentation;

import de.company.accounting.application.AccountAdministration;
import de.company.accounting.application.AccountingAdministration;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class MyTableModel extends DefaultTableModel {

    private AccountAdministration accountAdministration;
    private AccountingAdministration accountingAdministration;
    private final List<String> cols;
    private List<Integer> row = IntStream.range(0,7).boxed().collect(Collectors.toList());
    private List<List<Integer>> rows = new ArrayList<>();

    public MyTableModel(AccountAdministration accountAdministration, AccountingAdministration accountingAdministration) {
        this.accountAdministration = accountAdministration;
        this.accountingAdministration = accountingAdministration;
        cols = asList("Nr.", "Umsatz", "Soll", "Belegnummer", "Datum", "Haben", "Buchungstext");
    }


    @Override
    public void addRow(Object[] rowData) {
        super.addRow(rowData);
    }

    @Override
    public int getRowCount() {
        return super.getRowCount();
    }

    @Override
    public int getColumnCount() {
       return cols.size();
    }

    @Override
    public String getColumnName(int columns) {
        return cols.get(columns);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    @Override
    public void fireTableRowsUpdated(int firstRow, int lastRow) {
        super.fireTableRowsUpdated(firstRow, lastRow);
    }
}



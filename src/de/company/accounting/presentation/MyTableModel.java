package de.company.accounting.presentation;

import de.company.accounting.application.AccountAdministration;
import de.company.accounting.application.AccountingAdministration;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyTableModel extends AbstractTableModel {

    private AccountAdministration accountAdministration;
    private AccountingAdministration accountingAdministration;
    private final List<String> cols;
    private List<Integer> row = IntStream.range(0,7).boxed().collect(Collectors.toList());
    private List<List<Integer>> rows = Arrays.asList(row, row, row, row, row, row, row, row, row, row, row, row, row, row);

    public MyTableModel(AccountAdministration accountAdministration, AccountingAdministration accountingAdministration) {
        this.accountAdministration = accountAdministration;
        this.accountingAdministration = accountingAdministration;
        cols = Arrays.asList("Nr.", "Umsatz", "Soll", "Belegnummer", "Datum", "Haben", "Buchungstext");
    }

    @Override
    public int getRowCount() {
       return rows.size();
    }

    @Override
    public int getColumnCount() {
       return cols.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int columns) {
        return cols.get(columns);
    }

    @Override
    public void fireTableRowsUpdated(int firstRow, int lastRow) {
        super.fireTableRowsUpdated(firstRow, lastRow);
    }

    public void setData(List<List<Integer>> rows) {
        this.rows = rows;
        fireTableRowsUpdated(0, rows.size() );
    }
}



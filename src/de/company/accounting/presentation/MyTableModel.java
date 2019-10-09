package de.company.accounting.presentation;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyTableModel extends AbstractTableModel {

    private final List<String> cols;
    private List<Integer> row = IntStream.range(0,7).boxed().collect(Collectors.toList());
    private List<List<Integer>> rows = Arrays.asList(row, row, row, row, row, row, row);


    public MyTableModel() {
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

    public void setData(List<List<Integer>> rows) {
        this.rows = rows;
    }
}



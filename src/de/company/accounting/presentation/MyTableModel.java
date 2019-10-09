package de.company.accounting.presentation;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
       return 100;
    }

    @Override
    public int getColumnCount() {
       return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if ( columnIndex == 0 )
            return "" + rowIndex;
        else if ( columnIndex == 1 )
            return "" + (rowIndex * rowIndex);
        else
            return "" + (rowIndex * rowIndex * rowIndex);

    }

 }



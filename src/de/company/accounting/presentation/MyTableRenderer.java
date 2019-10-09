package de.company.accounting.presentation;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MyTableRenderer extends JLabel implements TableCellRenderer {

    public MyTableRenderer()
    {
        super.setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if(row % 2 == 0) {
            super.setBackground(Color.LIGHT_GRAY);
        }
        return null;
    }
}

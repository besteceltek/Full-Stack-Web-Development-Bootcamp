package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Core.Helper;
import Entity.Brand;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Layout extends JFrame {
    public void initializeGui(int width, int height) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Rent a Car");
        this.setSize(width, height);
        this.setLocation(Helper.getLocationPoint("x", this.getSize()), Helper.getLocationPoint("y", this.getSize()));
        this.setVisible(true);
    }

    public void generateTable(DefaultTableModel model, JTable table, Object[] columns, ArrayList<Object[]> rows) {
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setMaxWidth(75);
        table.setEnabled(false);

        // Table cleaner
        DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
        clearModel.setRowCount(0);

        if (rows == null) {
            rows = new ArrayList<>();
        }

        for(Object[] row : rows) {
            model.addRow(row);
        }
    }

    public int getTableSelectedRow(JTable table, int index) {
        return Integer.parseInt(table.getValueAt(table.getSelectedRow(), index).toString());
    }

    public void selectRow(JTable table) {
        // Select the chosen row
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = table.rowAtPoint(e.getPoint());
                table.setRowSelectionInterval(selected_row, selected_row);
            }
        });
    }

    public String dateFormatter (String text) {
        DateTimeFormatter FMT_IN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter FMT_OUT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date = LocalDate.parse(text, FMT_IN);
        String parsedDate = FMT_OUT.format(date);

        return parsedDate;
    }
}

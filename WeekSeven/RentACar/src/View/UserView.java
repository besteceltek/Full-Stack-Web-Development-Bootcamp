package View;

import Business.CarManager;
import Business.ModelManager;
import Core.ComboItem;
import Entity.Book;
import Entity.Car;
import Entity.Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UserView extends Layout {
    private JPanel container;
    private JTextField fld_start_date;
    private JTextField fld_finish_date;
    private JComboBox cmb_gear_filter;
    private JComboBox cmb_fuel_filter;
    private JComboBox cmb_type_filter;
    private JButton btn_reset;
    private JTable tbl_booking;
    private JButton btn_logout;
    private JLabel lbl_welcome;
    private JPanel pnl_welcome;
    private JPanel pnl_book_search;
    private JLabel lbl_start_date;
    private JLabel lbl_finish_date;
    private JLabel lbl_gear;
    private JLabel lbl_fuel;
    private JLabel lbl_type;
    private JButton btn_reserve;
    private JPanel pnl_booking;
    private JScrollPane scrl_booking;
    private JButton btn_search;
    private DefaultTableModel mdl_book = new DefaultTableModel();
    private ModelManager modelManager;
    private CarManager carManager;

    public UserView() {
        this.add(container);
        this.initializeGui(700, 300);
        this.modelManager = new ModelManager();
        this.carManager = new CarManager();

        loadBookingTable(null);
        loadBookingFilter();
        loadBookingComponents();
    }

    public void loadBookingTable(ArrayList<Object[]> carList) {
        Object[] coolBook = {"Brand", "Model", "Color", "KM", "Plate", "Year", "Type", "Fuel", "Gear"};
        generateTable(this.mdl_book, this.tbl_booking, coolBook, carList);
    }

    public void loadBookingFilter() {
        this.cmb_type_filter.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_type_filter.setSelectedItem(null);
        this.cmb_gear_filter.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_gear_filter.setSelectedItem(null);
        this.cmb_fuel_filter.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_fuel_filter.setSelectedItem(null);
    }

    public void loadBookingComponents() {
        this.selectRow(this.tbl_booking);

        this.btn_reserve.addActionListener(e -> {
            int selectCarId = this.getTableSelectedRow(this.tbl_booking, 0);
            BookView bookView = new BookView(
                    this.carManager.getByID(selectCarId),
                    this.fld_start_date.getText(),
                    this.fld_finish_date.getText(),
                    new Book()
            );
            bookView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBookingTable(null);
                    loadBookingFilter();
                }
            });
        });

        this.btn_search.addActionListener(e -> {
            ArrayList<Car> carList = this.carManager.searchForBooking(
                    this.fld_start_date.getText(),
                    this.fld_finish_date.getText(),
                    (Model.Type)this.cmb_type_filter.getSelectedItem(),
                    (Model.Gear)this.cmb_gear_filter.getSelectedItem(),
                    (Model.Fuel)this.cmb_fuel_filter.getSelectedItem()
            );
            ArrayList<Object[]> carBookingRow = this.carManager.getForTable(10, carList);
            loadBookingTable(carBookingRow);
        });

        this.btn_reset.addActionListener(e -> {
            this.cmb_type_filter.setSelectedItem(null);
            this.cmb_gear_filter.setSelectedItem(null);
            this.cmb_fuel_filter.setSelectedItem(null);
        });

        this.btn_logout.addActionListener(e -> {
            dispose();
            LoginView loginView = new LoginView();
        });
    }

    private void createUIComponents() throws ParseException {
        // Today
        String today = LocalDate.now().toString();

        // One week later
        String  weekLater = LocalDate.now().plusWeeks(1).toString();

        this.fld_start_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_start_date.setText(this.dateFormatter(today));
        this.fld_finish_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_finish_date.setText(this.dateFormatter(weekLater));
    }
}

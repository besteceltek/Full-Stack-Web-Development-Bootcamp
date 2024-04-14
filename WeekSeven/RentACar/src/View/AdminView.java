package View;

import Business.BookManager;
import Business.BrandManager;
import Business.CarManager;
import Business.ModelManager;
import Core.ComboItem;
import Core.Helper;
import Entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JPanel pnl_brand;
    private JScrollPane scrl_brand;
    private JTable tbl_brand;
    private JTable tbl_model;
    private User user;
    private DefaultTableModel mdl_brand = new DefaultTableModel();
    private DefaultTableModel mdl_model = new DefaultTableModel();
    private DefaultTableModel mdl_car = new DefaultTableModel();
    private DefaultTableModel mdl_book = new DefaultTableModel();
    private JPanel pnl_model;
    private JScrollPane scrl_model;
    private JButton btn_add;
    private JButton btn_update;
    private JButton btn_delete;
    private JPanel pnl_car;
    private JScrollPane scrl_car;
    private JTable tbl_car;
    private JPanel pnl_book;
    private JScrollPane scrl_book;
    private JTable tbl_book;
    private JButton btn_logout;
    private JPanel pnl_model_filter;
    private JComboBox cmb_brand_filter;
    private JComboBox cmb_type_filter;
    private JComboBox cmb_fuel_filter;
    private JComboBox cmb_gear_filter;
    private JButton btn_model_search;
    private JLabel lbl_brand_filter;
    private JLabel lbl_type_filter;
    private JLabel lbl_fuel_filter;
    private JLabel lbl_gear_filter;
    private JButton btn_model_reset;
    private JPanel pnl_book_filter;
    private JLabel lbl_car_plate;
    private JComboBox cmb_car_plate;
    private JButton btn_book_filter;
    private JButton btn_book_reset;
    private BrandManager brandManager;
    private ModelManager modelManager;
    private CarManager carManager;
    private BookManager bookManager;
    private JPopupMenu brandMenu;
    private Object[] colModel;
    private Object[] colBook;

    public AdminView(User user) {
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.carManager = new CarManager();
        this.bookManager = new BookManager();
        this.add(container);
        this.initializeGui(1200, 400);
        this.user = user;

        if (this.user == null) {
            dispose();
        }

        this.lbl_welcome.setText("Welcome " + this.user.getUsername());

        loadBrandTable();
        loadModelTable(null);
        loadCarTable();
        loadBookTable(null);
        loadBookingFilter();
        loadComponents();
        loadModelFilter();
        loadModelBrandFilter();
    }

    public void loadBrandTable() {
        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Object[]> brandList = this.brandManager.getForTable(col_brand.length);
        this.generateTable(this.mdl_brand, this.tbl_brand, col_brand, brandList);
    }

    public void loadModelTable(ArrayList<Object[]> modelList) {
        colModel = new Object[]{"Model ID", "Brand Name", "Model Name", "Model Year", "Model Type", "Model Fuel", "Model Gear"};
        if (modelList == null) {
            modelList = this.modelManager.getForTable(colModel.length, this.modelManager.findAll());
        }
        this.generateTable(this.mdl_model, this.tbl_model, colModel, modelList);
    }

    public void loadCarTable() {
        Object[] colCar = new Object[]{"Car ID", "Brand Name", "Model Name", "Car Color", "Car KM", "Car Plate", "Model Year", "Model Type", "Model Fuel", "Model Gear"};
        ArrayList<Object[]> carList = this.carManager.getForTable(colCar.length, this.carManager.findAll());
        this.generateTable(this.mdl_car, this.tbl_car, colCar, carList);
    }

    public void loadBookTable(ArrayList<Object[]> bookList) {
        colBook = new Object[]{"Book ID", "Car ID", "Book Name", "Book TC", "Book Phone", "Book Mail", "Start Date",
                "Finish Date", "Book Price", "Book Note", "Book Case"};
        if(bookList == null) {
            bookList = this.bookManager.getForTable(colBook.length, this.bookManager.findAll());
        }
        this.generateTable(this.mdl_book, this.tbl_book, colBook, bookList);
    }

    public void loadModelFilter() {
        this.cmb_type_filter.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_type_filter.setSelectedItem(null);
        this.cmb_gear_filter.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_gear_filter.setSelectedItem(null);
        this.cmb_fuel_filter.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_fuel_filter.setSelectedItem(null);
    }

    public void loadModelBrandFilter() {
        this.cmb_brand_filter.removeAllItems();
        for (Brand brand : this.brandManager.findAll()) {
            this.cmb_brand_filter.addItem(new ComboItem(brand.getBrandId(), brand.getBrandName()));
        }
        this.cmb_brand_filter.setSelectedItem(null);
    }

    public void loadBookingFilter() {
        for (Book book : this.bookManager.findAll()) {
            this.cmb_car_plate.addItem(new ComboItem(book.getBookCarId(), this.carManager.getByID(book.getBookCarId()).getCarPlate()));
        }
        this.cmb_car_plate.setSelectedItem(null);
    }

    public void loadComponents() {
        this.selectRow(this.tbl_brand);
        this.selectRow(this.tbl_model);
        this.selectRow(this.tbl_car);
        this.selectRow(this.tbl_book);

        this.btn_add.addActionListener(e -> {
            int selectedIndex = tab_menu.getSelectedIndex();
            switch (selectedIndex) {
                case 0:
                    BrandView brandView = new BrandView(null);
                    brandView.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadBrandTable();
                            loadModelBrandFilter();
                        }
                    });
                    break;
                case 1:
                    ModelView modelView = new ModelView(new Model());
                    modelView.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadModelTable(null);
                        }
                    });
                    break;
                case 2:
                    CarView carView = new CarView(new Car());
                    carView.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadCarTable();
                        }
                    });
                    break;
                case 3:
                    BookView bookView = new BookView(null, null, null, new Book());
                    bookView.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadBookTable(null);
                        }
                    });
            }
        });

        this.btn_update.addActionListener(e -> {
            int selectedIndex = tab_menu.getSelectedIndex();
            switch (selectedIndex) {
                case 0:
                    int selectBrandID = this.getTableSelectedRow(this.tbl_brand, 0);
                    BrandView brandView = new BrandView(this.brandManager.getByID(selectBrandID));
                    brandView.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadBrandTable();
                            loadModelTable(null);
                            loadCarTable();
                            loadModelBrandFilter();
                            loadBookTable(null);
                        }
                    });
                    break;
                case 1:
                    int selectModelID = this.getTableSelectedRow(this.tbl_model, 0);
                    ModelView modelView = new ModelView(this.modelManager.getByID(selectModelID));
                    modelView.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadModelTable(null);
                            loadCarTable();
                            loadBookTable(null);
                        }
                    });
                    break;
                case 2:
                    int selectCarID = this.getTableSelectedRow(this.tbl_car, 0);
                    CarView carView = new CarView(this.carManager.getByID(selectCarID));
                    carView.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadCarTable();
                            loadBookTable(null);
                        }
                    });
                    break;
                case 3:
                    int selectBookId = this.getTableSelectedRow(this.tbl_book, 0);
                    BookView bookView = new BookView(null, null, null, this.bookManager.getByID(selectBookId));
                    bookView.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadBookTable(null);
                        }
                    });
                    break;
            }
        });

        this.btn_delete.addActionListener(e -> {
            int selectedIndex = tab_menu.getSelectedIndex();
            if (Helper.confirm("sure")) {
                switch (selectedIndex) {
                    case 0:
                        int selectBrandID = this.getTableSelectedRow(this.tbl_brand, 0);
                        if (this.brandManager.delete(selectBrandID)) {
                            Helper.showMessage("done");
                            loadBrandTable();
                            loadModelTable(null);
                            loadCarTable();
                            loadModelBrandFilter();
                        } else {
                            Helper.showMessage("error");
                        }
                        break;
                    case 1:
                        int selectModelID = this.getTableSelectedRow(this.tbl_model, 0);
                        if (this.modelManager.delete(selectModelID)) {
                            Helper.showMessage("done");
                            loadModelTable(null);
                            loadCarTable();
                        } else {
                            Helper.showMessage("error");
                        }
                        break;
                    case 2:
                        int selectCarID = this.getTableSelectedRow(this.tbl_car, 0);
                        if (this.carManager.delete(selectCarID)) {
                            Helper.showMessage("done");
                            loadCarTable();
                        } else {
                            Helper.showMessage("error");
                        }
                        break;
                    case 3:
                        int selectBookId = this.getTableSelectedRow(this.tbl_book, 0);
                        if (this.bookManager.delete(selectBookId)) {
                            Helper.showMessage("done");
                            loadBookTable(null);
                        } else {
                            Helper.showMessage("error");
                        }
                        break;
                }
            }
        });

        this.btn_model_search.addActionListener(e -> {
            ComboItem selectedBrand = (ComboItem) this.cmb_brand_filter.getSelectedItem();
            int key = 0;
            if (selectedBrand != null) {
                key = selectedBrand.getKey();
            }
            ArrayList<Model> modelListBySearch = this.modelManager.searchForTable(
                    key,
                    (Model.Fuel) cmb_fuel_filter.getSelectedItem(),
                    (Model.Gear) cmb_gear_filter.getSelectedItem(),
                    (Model.Type) cmb_type_filter.getSelectedItem());

            ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(this.colModel.length, modelListBySearch);
            loadModelTable(modelRowListBySearch);
        });

        this.btn_model_reset.addActionListener(e -> {
            this.cmb_brand_filter.setSelectedItem(null);
            this.cmb_type_filter.setSelectedItem(null);
            this.cmb_gear_filter.setSelectedItem(null);
            this.cmb_fuel_filter.setSelectedItem(null);
            loadModelTable(null);
        });

        this.btn_book_filter.addActionListener(e -> {
            ComboItem selectedPlate = (ComboItem) this.cmb_car_plate.getSelectedItem();
            int key = 0;
            if (selectedPlate != null) {
                key = selectedPlate.getKey();
            }
            ArrayList<Book> bookListBySearch = this.bookManager.searchForTable(key);
            ArrayList<Object[]> bookRowListBySearch = this.bookManager.getForTable(this.colBook.length, bookListBySearch);
            loadBookTable(bookRowListBySearch);
        });

        this.btn_book_reset.addActionListener(e -> {
            this.cmb_car_plate.setSelectedItem(null);
            loadBookTable(null);
        });

        this.btn_logout.addActionListener(e -> {
            dispose();
            LoginView loginView = new LoginView();
        });
    }
}

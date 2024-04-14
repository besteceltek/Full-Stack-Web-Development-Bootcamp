package View;

import Business.BookManager;
import Business.CarManager;
import Core.ComboItem;
import Core.Helper;
import Entity.Book;
import Entity.Car;
import Entity.Model;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookView extends Layout {
    private JPanel container;
    private JLabel lbl_book;
    private JLabel lbl_name;
    private JTextField fld_name;
    private JLabel lbl_tc;
    private JTextField fld_tc;
    private JLabel lbl_phone;
    private JTextField fld_phone;
    private JLabel lbl_mail;
    private JTextField fld_mail;
    private JLabel lbl_note;
    private JButton btn_save;
    private JPanel pnl_reserve;
    private JLabel lbl_start_date;
    private JTextField fld_start_date;
    private JLabel lbl_finish_date;
    private JTextField fld_finish_date;
    private JLabel lbl_price;
    private JTextField fld_price;
    private JTextArea txta_note;
    private JLabel lbl_car;
    private JComboBox cmb_car;
    private BookManager bookManager;
    private CarManager carManager;
    private Car car;
    private Book book;

    public BookView(Car selectedCar, String startDate, String finishDate, Book selectedBook) {
        this.add(container);
        this.initializeGui(300, 600);
        this.bookManager = new BookManager();
        this.carManager = new CarManager();
        this.car = selectedCar;
        this.book = selectedBook;

        for (Car car : this.carManager.findAll()) {
            this.cmb_car.addItem(car.getComboItem());
        }

        if (selectedCar != null && startDate != null & finishDate != null) {
            lbl_book.setText("Reserve Car: " +
                    this.car.getCarPlate() + " / " +
                    this.car.getModel().getBrand().getBrandName() + " / " +
                    this.car.getModel().getModelName());

            this.fld_start_date.setText(startDate);
            this.fld_finish_date.setText(finishDate);
            ComboItem defaultModel = new ComboItem(this.car.getCarId(),
                    this.car.getModel().getBrand().getBrandName() +
                            " - " +
                            this.car.getModel().getModelName() +
                            " - " +
                            this.car.getCarPlate()
            );
            this.cmb_car.getModel().setSelectedItem(defaultModel);
        }

        if(this.book != null) {
            if (this.book.getBookId() != 0) {
                this.car = this.book.getCar();
                lbl_book.setText("Reserve Car: " +
                        this.car.getCarPlate() + " / " +
                        this.car.getModel().getBrand().getBrandName() + " / " +
                        this.car.getModel().getModelName());

                this.fld_start_date.setText(this.dateFormatter(this.book.getBookStartDate().toString()));
                this.fld_finish_date.setText(this.dateFormatter(this.book.getBookFinishDate().toString()));
                this.fld_price.setText(String.valueOf(this.book.getBookPrice()));
                this.fld_mail.setText(this.book.getBookMail());
                this.fld_name.setText(this.book.getBookName());
                this.fld_phone.setText(this.book.getBookPhone());
                this.fld_tc.setText(this.book.getBookTc());
                this.txta_note.setText(this.book.getBookNote());
                ComboItem defaultModel = new ComboItem(this.book.getBookId(), this.carManager.getByID(this.book.getBookCarId()).getModel().getModelName());
                this.cmb_car.getModel().setSelectedItem(defaultModel);
            }
        }

        btn_save.addActionListener(e -> {
            JTextField[] checkFieldList = {
                    this.fld_name,
                    this.fld_mail,
                    this.fld_phone,
                    this.fld_tc,
                    this.fld_start_date,
                    this.fld_finish_date,
                    this.fld_price
            };

            if (Helper.isFieldListEmpty(checkFieldList)) {
                Helper.showMessage("fill");
            } else {
                boolean result;

                this.book.setBookCase("done");
                this.book.setBookCarId(this.car.getCarId());
                this.book.setBookName(this.fld_name.getText());
                this.book.setBookStartDate(LocalDate.parse(fld_start_date.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                this.book.setBookFinishDate(LocalDate.parse(fld_finish_date.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                this.book.setBookTc(this.fld_tc.getText());
                this.book.setBookPhone(this.fld_phone.getText());
                this.book.setBookMail(this.fld_mail.getText());
                this.book.setBookNote(this.txta_note.getText());
                this.book.setBookPrice(Integer.parseInt(this.fld_price.getText()));

                if (this.book.getBookId() != 0) { // Update
                    result = this.bookManager.update(this.book);
                } else { // Add
                    result = this.bookManager.save(this.book);
                }

                if (result) {
                    Helper.showMessage("done");
                    dispose();
                } else {
                    Helper.showMessage("error");
                }

            }
        });
    }
}

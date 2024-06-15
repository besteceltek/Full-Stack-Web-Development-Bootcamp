package Entity;

import java.time.LocalDate;
import java.util.Date;

public class Book {
    private int bookId, bookCarId, bookPrice;
    private String bookName, bookTc, bookPhone, bookMail, bookNote, bookCase;
    private LocalDate bookStartDate, bookFinishDate;
    private Car car;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookCarId() {
        return bookCarId;
    }

    public void setBookCarId(int bookCarId) {
        this.bookCarId = bookCarId;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookTc() {
        return bookTc;
    }

    public void setBookTc(String bookTc) {
        this.bookTc = bookTc;
    }

    public String getBookPhone() {
        return bookPhone;
    }

    public void setBookPhone(String bookPhone) {
        this.bookPhone = bookPhone;
    }

    public String getBookMail() {
        return bookMail;
    }

    public void setBookMail(String bookMail) {
        this.bookMail = bookMail;
    }

    public String getBookNote() {
        return bookNote;
    }

    public void setBookNote(String bookNote) {
        this.bookNote = bookNote;
    }

    public String getBookCase() {
        return bookCase;
    }

    public void setBookCase(String bookCase) {
        this.bookCase = bookCase;
    }

    public LocalDate getBookStartDate() {
        return bookStartDate;
    }

    public void setBookStartDate(LocalDate bookStartDate) {
        this.bookStartDate = bookStartDate;
    }

    public LocalDate getBookFinishDate() {
        return bookFinishDate;
    }

    public void setBookFinishDate(LocalDate bookFinishDate) {
        this.bookFinishDate = bookFinishDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String toString() {
        return "Book{" +
                "id=" + bookId +
                ", car_id=" + bookCarId +
                ", car=" + car +
                ", name=" + bookName + '\'' +
                ", tc=" + bookTc + '\'' +
                ", phone=" + bookPhone + '\'' +
                ", mail=" + bookMail + '\'' +
                ", start_date" + bookStartDate +
                ", finish_date" + bookFinishDate +
                ", case=" + bookCase + '\'' +
                ", price=" + bookPrice +
                "}";
    }
}

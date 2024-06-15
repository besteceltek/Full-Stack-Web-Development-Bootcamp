package Business;

import Core.Helper;
import DAO.BookDao;
import Entity.Book;
import Entity.Car;

import java.util.ArrayList;

public class BookManager {

    private BookDao bookDao;

    public BookManager() {
        this.bookDao = new BookDao();
    }

    public ArrayList<Book> findAll() {
        return this.bookDao.findAll();
    }

    public boolean save(Book book) {
        if (book.getBookId() != 0) {
            Helper.showMessage("error");
        }
        return this.bookDao.save(book);
    }

    public boolean update(Book book) {
        if (this.getByID(book.getBookId()) == null) {
            Helper.showMessage("notFound");
        }
        return this.bookDao.update(book);
    }

    public boolean delete(int id) {
        if (this.getByID(id) == null) {
            Helper.showMessage("Book ID " + id + " is not found");
            return false;
        }
        return this.bookDao.delete(id);
    }

    public Book getByID(int id) {
        return this.bookDao.getByID(id);
    }

    public ArrayList<Object[]> getForTable(int colSize, ArrayList<Book> bookList) {
        ArrayList<Object[]> bookRowList = new ArrayList<>();
        for (Book book : bookList) {
            Object[] rowObject = new Object[colSize];
            int i = 0;
            rowObject[i++] = book.getBookId();
            rowObject[i++] = book.getBookCarId();
            rowObject[i++] = book.getBookName();
            rowObject[i++] = book.getBookTc();
            rowObject[i++] = book.getBookPhone();
            rowObject[i++] = book.getBookMail();
            rowObject[i++] = book.getBookStartDate();
            rowObject[i++] = book.getBookFinishDate();
            rowObject[i++] = book.getBookPrice();
            rowObject[i++] = book.getBookNote();
            rowObject[i++] = book.getBookCase();
            bookRowList.add(rowObject);
        }
        return bookRowList;
    }

    public ArrayList<Book> searchForTable(int carId) {
        String select = "SELECT * FROM public.book";
        ArrayList<String> whereList = new ArrayList<>();

        if (carId != 0) {
            whereList.add("book_car_id = " + carId);
        }

        String whereStr = String.join(" AND ", whereList);
        String query = select;
        if (whereStr.length() > 0) {
            query += " WHERE " + whereStr;
        }
        return this.bookDao.selectByQuery(query);
    }
}

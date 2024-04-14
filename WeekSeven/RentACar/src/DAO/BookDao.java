package DAO;

import Core.Database;
import Entity.Book;
import Entity.Car;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookDao {

    private Connection connection;
    private final CarDao carDao;

    public BookDao() {
        this.connection = Database.getInstance();
        this.carDao = new CarDao();
    }

    public Book match(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setBookId(resultSet.getInt("book_id"));
        book.setBookCarId(resultSet.getInt("book_car_id"));
        book.setBookName(resultSet.getString("book_name"));
        book.setBookTc(resultSet.getString("book_tc"));
        book.setBookPhone(resultSet.getString("book_phone"));
        book.setBookMail(resultSet.getString("book_mail"));
        book.setBookStartDate(LocalDate.parse(resultSet.getString("book_start_date")));
        book.setBookFinishDate(LocalDate.parse(resultSet.getString("book_finish_date")));
        book.setBookPrice(resultSet.getInt("book_price"));
        book.setBookNote(resultSet.getString("book_note"));
        book.setBookCase(resultSet.getString("book_case"));
        book.setCar(this.carDao.getByID(resultSet.getInt("book_car_id")));
        return book;
    }

    public ArrayList<Book> selectByQuery(String query) {
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            ResultSet resultSet = this.connection.createStatement().executeQuery(query);
            while (resultSet.next()) {
                bookList.add(this.match(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public ArrayList<Book> findAll() {
        return this.selectByQuery("SELECT * FROM public.book ORDER BY book_id ASC");
    }

    public Book getByID(int id) {
        Book book = null;
        String query = "SELECT * FROM public.book WHERE book_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = this.match(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public boolean save(Book book) {
        String query = "INSERT INTO public.book " +
                "(" +
                "book_car_id, " +
                "book_name, " +
                "book_tc, " +
                "book_phone, " +
                "book_mail, " +
                "book_start_date, " +
                "book_finish_date, " +
                "book_price, " +
                "book_note, " +
                "book_case" +
                ")" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, book.getBookCarId());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setString(3, book.getBookTc());
            preparedStatement.setString(4, book.getBookPhone());
            preparedStatement.setString(5, book.getBookMail());
            preparedStatement.setDate(6, Date.valueOf(book.getBookStartDate()));
            preparedStatement.setDate(7, Date.valueOf(book.getBookFinishDate()));
            preparedStatement.setInt(8, book.getBookPrice());
            preparedStatement.setString(9, book.getBookNote());
            preparedStatement.setString(10, book.getBookCase());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(Book book) {
        String query = "UPDATE public.book SET " +
                "book_name = ? ," +
                "book_tc = ? ," +
                "book_phone = ? ," +
                "book_mail = ? ," +
                "book_start_date = ? ," +
                "book_finish_date = ? ," +
                "book_price = ? ," +
                "book_note = ? " +
                "WHERE book_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getBookTc());
            preparedStatement.setString(3, book.getBookPhone());
            preparedStatement.setString(4, book.getBookMail());
            preparedStatement.setDate(5, Date.valueOf(book.getBookStartDate()));
            preparedStatement.setDate(6, Date.valueOf(book.getBookFinishDate()));
            preparedStatement.setInt(7, book.getBookPrice());
            preparedStatement.setString(8, book.getBookNote());
            preparedStatement.setInt(9, book.getBookId());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int book_id) {
        String query = "DELETE FROM public.book WHERE book_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, book_id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

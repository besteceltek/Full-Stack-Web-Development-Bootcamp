package Business;

import Core.Helper;
import DAO.BookDao;
import DAO.CarDao;
import Entity.Book;
import Entity.Car;
import Entity.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CarManager {
    private final CarDao carDao;
    private final BookDao bookDao;

    public CarManager() {
        this.carDao = new CarDao();
        this.bookDao = new BookDao();
    }

    public ArrayList<Car> findAll() {
        return this.carDao.findAll();
    }

    public boolean save(Car car) {
        if (car.getCarId() != 0) {
            Helper.showMessage("error");
        }
        return this.carDao.save(car);
    }

    public boolean update(Car car) {
        if (this.getByID(car.getCarId()) == null) {
            Helper.showMessage("notFound");
        }
        return this.carDao.update(car);
    }

    public boolean delete(int id) {
        if (this.getByID(id) == null) {
            Helper.showMessage("Car ID " + id + " is not found");
            return false;
        }
        return this.carDao.delete(id);
    }

    public Car getByID(int id) {
        return this.carDao.getByID(id);
    }

    public ArrayList<Object[]> getForTable(int colSize, ArrayList<Car> carList) {
        ArrayList<Object[]> carRowList = new ArrayList<>();
        for (Car car : carList) {
            Object[] rowObject = new Object[colSize];
            int i = 0;
            rowObject[i++] = car.getCarId();
            rowObject[i++] = car.getModel().getBrand().getBrandName();
            rowObject[i++] = car.getModel().getModelName();
            rowObject[i++] = car.getCarColor();
            rowObject[i++] = car.getCarKm();
            rowObject[i++] = car.getCarPlate();
            rowObject[i++] = car.getModel().getModelYear();
            rowObject[i++] = car.getModel().getModelType();
            rowObject[i++] = car.getModel().getModelFuel();
            rowObject[i++] = car.getModel().getModelGear();
            carRowList.add(rowObject);
        }
        return carRowList;
    }

    public ArrayList<Car> getByListModelId(int modelId) {
        return this.carDao.getByListBrandId(modelId);
    }

    public ArrayList<Car> searchForBooking(String startDate, String finishDate, Model.Type type, Model.Gear gear, Model.Fuel fuel) {
        String query = "SELECT * FROM public.car as C LEFT JOIN public.model as M";
        ArrayList<String> where = new ArrayList<>();
        ArrayList<String> joinWhere = new ArrayList<>();
        ArrayList<String> bookOrWhere = new ArrayList<>();

        joinWhere.add("C.car_model_id = M.model_id");

        startDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
        finishDate = LocalDate.parse(finishDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();

        if (fuel != null) where.add("M.model_fuel = '" + fuel.toString() + "'");
        if (gear != null) where.add("M.model_gear = '" + gear.toString() + "'");
        if (type != null) where.add("M.model_type = '" + type.toString() + "'");

        String whereStr = String.join(" AND ", where);
        String joinStr = String.join(" AND ", joinWhere);

        if (!joinStr.isEmpty()) {
            query += " ON " + joinStr;
        }
        if (!whereStr.isEmpty()) {
            query += " ON " + whereStr;
        }

        ArrayList<Car> searchedCarList = this.carDao.selectByQuery(query);

        bookOrWhere.add("('" + startDate + "' BETWEEN book_start_date AND book_finish_date)");
        bookOrWhere.add("('" + finishDate + "' BETWEEN book_start_date AND book_finish_date)");
        bookOrWhere.add("(book_start_date BETWEEN '" + startDate + "' AND '" + finishDate + "')");
        bookOrWhere.add("(book_finish_date BETWEEN '" + startDate + "' AND '" + finishDate + "')");

        String bookOrWhereStr = String.join(" OR ", bookOrWhere);
        String bookQuery = "SELECT * FROM public.book WHERE " + bookOrWhereStr;

        ArrayList<Book> bookedCarList = this.bookDao.selectByQuery(bookQuery);
        ArrayList<Integer> bookedCarId = new ArrayList<>();
        for (Book book : bookedCarList) {
            bookedCarId.add(book.getBookCarId());
        }

        searchedCarList.removeIf(car -> bookedCarId.contains(car.getCarId()));

        return searchedCarList;
    }
}

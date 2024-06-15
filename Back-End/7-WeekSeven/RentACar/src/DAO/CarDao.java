package DAO;

import Core.Database;
import Entity.Car;
import Entity.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDao {
    private final Connection connection;
    private final ModelDao modelDao;

    public CarDao() {
        this.connection = Database.getInstance();
        this.modelDao = new ModelDao();
    }

    public Car match(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        car.setCarId(resultSet.getInt("car_id"));
        car.setCarModelId(resultSet.getInt("car_model_id"));
        car.setCarColor(Car.Color.valueOf(resultSet.getString("car_color")));
        car.setCarKm(resultSet.getInt("car_km"));
        car.setCarPlate(resultSet.getString("car_plate"));
        car.setModel(this.modelDao.getByID(car.getCarModelId()));
        return car;
    }

    public ArrayList<Car> selectByQuery(String query) {
        ArrayList<Car> carList = new ArrayList<>();
        try {
            ResultSet resultSet = this.connection.createStatement().executeQuery(query);
            while (resultSet.next()) {
                carList.add(this.match(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public ArrayList<Car> findAll() {
        return this.selectByQuery("SELECT * FROM public.car ORDER BY car_id ASC");
    }

    public Car getByID(int id) {
        Car car = null;
        String query = "SELECT * FROM public.car WHERE car_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                car = this.match(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public boolean save(Car car) {
        String query = "INSERT INTO public.car " +
                "(" +
                "car_model_id, " +
                "car_color, " +
                "car_km, " +
                "car_plate" +
                ")" +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, car.getCarModelId());
            preparedStatement.setString(2, car.getCarColor().toString());
            preparedStatement.setInt(3, car.getCarKm());
            preparedStatement.setString(4, car.getCarPlate());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(Car car) {
        String query = "UPDATE public.car SET " +
                "car_model_id = ? , " +
                "car_color = ? , " +
                "car_km = ? , " +
                "car_plate = ? " +
                "WHERE car_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, car.getCarModelId());
            preparedStatement.setString(2, car.getCarColor().toString());
            preparedStatement.setInt(3, car.getCarKm());
            preparedStatement.setString(4, car.getCarPlate());
            preparedStatement.setInt(5, car.getCarId());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int car_id) {
        String query = "DELETE FROM public.car WHERE car_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, car_id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Car> getByListBrandId(int modelId) {
        return this.selectByQuery("SELECT * FROM public.car WHERE car_model_id = ?" + modelId);
    }
}

package DAO;

import Core.Database;
import Entity.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelDao {
    private final Connection connection;
    private final BrandDao brandDao = new BrandDao();

    public ModelDao() {
        this.connection = Database.getInstance();
    }

    public boolean save(Model model) {
        String query = "INSERT INTO public.model " +
                "(" +
                "model_brand_id, " +
                "model_name, " +
                "model_year, " +
                "model_type, " +
                "model_fuel, " +
                "model_gear" +
                ")" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, model.getModelBrandId());
            preparedStatement.setString(2, model.getModelName());
            preparedStatement.setString(3, model.getModelYear());
            preparedStatement.setString(4, model.getModelType().toString());
            preparedStatement.setString(5, model.getModelFuel().toString());
            preparedStatement.setString(6, model.getModelGear().toString());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(Model model) {
        String query = "UPDATE public.model SET " +
                "model_brand_id = ? , " +
                "model_name = ? , " +
                "model_year = ? , " +
                "model_type = ? , " +
                "model_fuel = ? , " +
                "model_gear = ? " +
                "WHERE model_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, model.getModelBrandId());
            preparedStatement.setString(2, model.getModelName());
            preparedStatement.setString(3, model.getModelYear());
            preparedStatement.setString(4, model.getModelType().toString());
            preparedStatement.setString(5, model.getModelFuel().toString());
            preparedStatement.setString(6, model.getModelGear().toString());
            preparedStatement.setInt(7, model.getModelId());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int model_id) {
        String query = "DELETE FROM public.model WHERE model_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, model_id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Model getByID(int id) {
        Model model = null;
        String query = "SELECT * FROM public.model WHERE model_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                model = this.match(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    public ArrayList<Model> findAll() {
        return this.selectByQuery("SELECT * FROM public.model ORDER BY model_id ASC");
    }

    public ArrayList<Model> selectByQuery(String query) {
        ArrayList<Model> modelList = new ArrayList<>();
        try {
            ResultSet resultSet = this.connection.createStatement().executeQuery(query);
            while (resultSet.next()) {
                modelList.add(this.match(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    public Model match(ResultSet resultSet) throws SQLException {
        Model model = new Model();
        model.setModelId(resultSet.getInt("model_id"));
        model.setModelName(resultSet.getString("model_name"));
        model.setModelBrandId(resultSet.getInt("model_brand_id"));
        model.setBrand(this.brandDao.getByID(resultSet.getInt("model_brand_id")));
        model.setModelYear(resultSet.getString("model_year"));
        model.setModelType(Model.Type.valueOf(resultSet.getString("model_type")));
        model.setModelFuel(Model.Fuel.valueOf(resultSet.getString("model_fuel")));
        model.setModelGear(Model.Gear.valueOf(resultSet.getString("model_gear")));
        return model;
    }

    public ArrayList<Model> getByListBrandId(int brandId) {
        return this.selectByQuery("SELECT * FROM public.model WHERE model_brand_id = ?" + brandId);
    }
}

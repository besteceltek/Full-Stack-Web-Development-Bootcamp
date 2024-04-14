package DAO;

import Core.Database;
import Entity.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandDao {
    private final Connection connection;

    public BrandDao() {
        this.connection = Database.getInstance();
    }

    public ArrayList<Brand> findAll() {
        ArrayList<Brand> brandList = new ArrayList<>();
        String query = "SELECT * FROM public.brand ORDER BY brand_id ASC";
        try {
            ResultSet resultSet = this.connection.createStatement().executeQuery(query);
            while(resultSet.next()) {
                brandList.add(this.match(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brandList;
    }

    public Brand match(ResultSet resultSet) throws SQLException {
        Brand brand = new Brand();
        brand.setBrandId(resultSet.getInt("brand_id"));
        brand.setBrandName(resultSet.getString("brand_name"));
        return brand;
    }

    public boolean save(Brand brand) {
        String query = "INSERT INTO public.brand (brand_name) VALUES (?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, brand.getBrandName());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(Brand brand) {
        String query = "UPDATE public.brand SET brand_name = ? WHERE brand_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, brand.getBrandName());
            preparedStatement.setInt(2, brand.getBrandId());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int id) {
        String query = "DELETE FROM public.brand WHERE brand_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Brand getByID(int id) {
        Brand brand = null;
        String query = "SELECT * FROM public.brand WHERE brand_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                brand = this.match(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brand;
    }
}

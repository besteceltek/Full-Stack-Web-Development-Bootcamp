package DAO;

import Core.Database;
import Entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    private final Connection connection;

    public UserDao() {
        this.connection = Database.getInstance();
    }

    public ArrayList<User> findAll() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM public.user";
        try {
            ResultSet resultSet = this.connection.createStatement().executeQuery(query);
            while(resultSet.next()) {
                userList.add(this.match(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public User findByLogin(String username, String password) {
        User user = null;
        String query = "SELECT * FROM public.user WHERE user_name = ? AND  user_password = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = this.match(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User match(ResultSet resultSet) throws SQLException {
        User  user = new User();
        user.setUserId(resultSet.getInt("user_id"));
        user.setUsername(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("user_password"));
        user.setRole(resultSet.getString("user_role"));
        return user;
    }
}

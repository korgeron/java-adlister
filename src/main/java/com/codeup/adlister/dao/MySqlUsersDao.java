package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySqlUsersDao implements Users{
    private static Connection connection = null;

    public MySqlUsersDao(Config config) {
        if (connection == null){
            try {
                DriverManager.registerDriver(new Driver());
                connection = DriverManager.getConnection(
                        config.getUrl(),
                        config.getUsername(),
                        config.getPassword()
                );
            } catch (SQLException e){
                throw new RuntimeException("Connection issues", e);
            }
        }
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
        }catch (SQLException e){
            throw new RuntimeException("This is the find user method", e);
        }

    }

    @Override
    public Long insert(User user) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?,?,?)";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2,user.getEmail());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        }catch (SQLException e){
            throw new RuntimeException("insert", e);
        }



    }


    public static void main(String[] args) {
        Users userDao = new MySqlUsersDao(new Config());

//        userDao.insert(new User("bill", "@email.com", "pass"));
        System.out.println(userDao.findByUsername("bill"));
    }
}

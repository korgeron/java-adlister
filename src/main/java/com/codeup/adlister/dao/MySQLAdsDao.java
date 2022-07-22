package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO ads (user_id, title, description) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setLong(1,ad.getUserId());
            ps.setString(2,ad.getTitle());
            ps.setString(3,ad.getDescription());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();


            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }


    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    public static void main(String[] args) {

        Ads adsDao = DaoFactory.getAdsDao();
        List<Ad> ads = adsDao.all();
            adsDao.insert(new Ad("tester","this has been tested"));
        for (Ad ad : ads){
            System.out.println(ad.getUserId());
            System.out.println(ad.getTitle());
        }

    }
}

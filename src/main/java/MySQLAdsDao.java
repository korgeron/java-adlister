//TODO: STEPS TO SET UP DATABASE CONNECTION
//  1. REGISTER DRIVER
//  2. CREATE A CONNECTION
//  3. CREATE STATEMENT OBJECT
//  4. EXECUTE STATEMENT USING RESULTSET
//  5. INTERPRET RESULTS

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao() {
        try {
            Config config = new Config();

            //TODO: Register driver
            DriverManager.registerDriver(new Driver());

            //TODO: Create connection to driver
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("This is from setting up the connection", e);
        }
    }


    @Override
    public List<Ad> all() {

        //TODO: create statement object
        try {
            Statement statement = connection.createStatement();

            //TODO: execute statement
            ResultSet rs = statement.executeQuery("SELECT * FROM ads");
            List<Ad> ads = new ArrayList<>();
            //TODO: interpret results
            while (rs.next()) {
                ads.add(new Ad(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
            return ads;

        } catch (SQLException e) {
            throw new RuntimeException("This is from creating statement object", e);
        }
    }


    @Override
    public Long insert(Ad ad) {
        String query = String.format("insert into ads (user_id, title, description) values ('%d', '%s', '%s');", ad.getUserId(), ad.getTitle(), ad.getDescription());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
            }
            return rs.getLong(1);

        } catch (SQLException e) {
            throw new RuntimeException("This is from the insert method", e);
        }


    }

    public static void main(String[] args) {
        MySQLAdsDao adsDao = new MySQLAdsDao();
        List<Ad> ads = adsDao.all();

        for (Ad ad : ads) {
            System.out.println(ad.getTitle() + ", " + ad.getDescription());
        }



//        adsDao.insert(new Ad(1,"adding", "this is a test"));

    }


}

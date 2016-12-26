/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Huynh Trung Nghia
 */
public class Car {

    String connectionURL = "jdbc:mysql://localhost:3306/carrental?user=root;password=";
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;

    public void connectDB() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "root", "");
            statement = connection.createStatement();

        } catch (SQLException ex) {
        }
    }

    public void update(int ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("UPDATE Car SET Status='U' WHERE `CarID`=" + ID);
        connection.close();
    }
    public void already(int ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("UPDATE Car SET Status='A' WHERE `CarID`=" + ID);
        connection.close();
    }
    public void delete(int ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("DELETE FROM car WHERE `CarID`=" + ID);
        connection.close();
    }
    public void edit(int ID,String name, String price, String discount) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        if (!name.equals("")) {
                    statement.executeUpdate("UPDATE Car SET CarName='" + name + "' WHERE `CarID`=" + ID);
                }
                if (!price.equals("")) {
                    int Price = parseInt(price);
                    statement.executeUpdate("UPDATE Car SET Price=" + Price + " WHERE `CarID`=" + ID);
                }
                if (!discount.equals("")) {
                    int Discount = parseInt(discount);
                    statement.executeUpdate("UPDATE Car SET Discount=" + Discount + " WHERE `CarID`=" + ID);
                }
        connection.close();
    }
    public void add(String name, String carType, int seat, int price, int discount, String color, String introduce ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("INSERT INTO `car` (`CarName`, `Discount`, `CarType`, `Seats`, `Color`, `Introduce`, `Price`, `Status`, `Like`, `Dislike`) VALUES ('" + name + "', " + discount + ", '" + carType + "', " + seat + ", '" + color + "', '" + introduce + "', " + price + ", 'A', 0, 0)");
        connection.close();
    }
    
    public void like(int CarID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("UPDATE `car` SET `Like` = `Like`+1 WHERE `CarID`=" + CarID);
        connection.close();
    }
    
    public void dislike(int CarID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("UPDATE `car` SET `Dislike` = `Dislike`+1 WHERE `CarID`=" + CarID);
        connection.close();
    }
}

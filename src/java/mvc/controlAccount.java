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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class controlAccount {

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

    public void editAdmin(String AdFName, String AdPass, String adPhone, String AdAddress) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        if (!AdFName.equals("")) {
            statement.executeUpdate("UPDATE admin SET AdFName='" + AdFName + "' WHERE `AdName`='admin'");
        }
        if (!AdPass.equals("")) {
            statement.executeUpdate("UPDATE admin SET AdPass='" + AdPass + "' WHERE `AdName`= 'admin'");
        }
        if (!adPhone.equals("")) {
            int AdPhone = parseInt(adPhone);
            statement.executeUpdate("UPDATE admin SET AdPhone=" + AdPhone + " WHERE `AdName`= 'admin'");
        }
        if (!AdAddress.equals("")) {
            statement.executeUpdate("UPDATE admin SET AdAddress='" + AdAddress + "' WHERE `AdName`= 'admin'");
        }
        connection.close();
    }

    public void editCustomer(int CID, String CPass, String CFName, String CPhone, String CAddress) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        if (!CPass.equals("")) {
            statement.executeUpdate("UPDATE customer SET CPass='" + CPass + "' WHERE `CID`=" + CID);
        }
        if (!CFName.equals("")) {
            statement.executeUpdate("UPDATE customer SET CFName='" + CFName + "' WHERE `CID`=" + CID);
        }
        if (!CPhone.equals("")) {
            statement.executeUpdate("UPDATE customer SET CPhone='" + CPhone + "' WHERE `CID`=" + CID);
        }
        if (!CAddress.equals("")) {
            statement.executeUpdate("UPDATE customer SET CAddress='" + CAddress + "'  WHERE `CID`=" + CID);
        }
        connection.close();
    }

    public void ban(int CID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("INSERT INTO ban (CID) VALUES (" + CID + ")");
        connection.close();
    }

    public void unban(int CID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("DELETE FROM ban WHERE `CID`=" + CID);
        connection.close();
    }

    public void register(String CName, String CPass, String CFName, String CPhone, String CAddress, int CINumber) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("INSERT INTO customer (CName, CPass, CFName, CPhone, CAddress, CINumber) VALUES ('" + CName + "', '" + CPass + "', '" + CFName + "', " + CPhone + ", '" + CAddress + "', " + CINumber + ")");
        connection.close();
    }

    public void rent(int CarID, int ID, String getDate) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("INSERT INTO rent (CarID, CID, RentType, TimeRent)VALUES (" + CarID + "," + ID + ", 'W','" + getDate + "')");
        connection.close();
    }

    public void get(int CarID, String getDate) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("UPDATE `rent` SET `TimeRent` = '" + getDate + "', `RentType`='R' WHERE `CarID`=" + CarID);
        connection.close();
    }

    public void returnn(int CarID, int CID, String TimeRent, String TimeReturn, String CFName, String CarName, int Price, int Discount) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException {
        connectDB();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rs = statement.executeQuery("SELECT * FROM rent WHERE `CarID`=" + CarID);
        if (rs.next()) {
            CID = Integer.parseInt(rs.getString("CID"));
            TimeRent = rs.getString("TimeRent");
            rs = statement.executeQuery("SELECT CFName FROM customer WHERE `CID`=" + CID);
            if (rs.next()) {
                CFName = rs.getString("CFName");
            }
            rs = statement.executeQuery("SELECT * FROM car WHERE `CarID`=" + CarID);
            if (rs.next()) {
                CarName = rs.getString("CarName");
                Price = rs.getInt("Price");
                Discount = rs.getInt("Discount");
            }
        }
        //date
        Date date1 = df.parse(TimeRent);
        Date date2 = df.parse(TimeReturn);

        double totalDays = (date2.getTime() - date1.getTime()) * 1.0 / (1000 * 60 * 60 * 24);
        int Payment = Price - (Price * Discount / 100);
        int inttotalDays = (int) totalDays;
        double check = totalDays - (double) inttotalDays;
        if (check == 0) {
            inttotalDays = inttotalDays;
        } else {
            inttotalDays += 1;
        }
        //total price
        Payment = Payment * inttotalDays;

        statement.executeUpdate("INSERT INTO history (CarName, CFName, CID, TimeRent, TimeReturn, Payment) VALUES ('" + CarName + "', '" + CFName + "', " + CID + ",'" + TimeRent + "','" + TimeReturn + "'," + Payment + ")");
        statement.executeUpdate("DELETE FROM rent WHERE `CarID`=" + CarID);
        connection.close();
    }

    public void cancelOrder(int CarID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        statement.executeUpdate("DELETE FROM rent WHERE `CarID`=" + CarID);
        connection.close();
    }
}

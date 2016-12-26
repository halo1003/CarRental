/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import static java.lang.Integer.parseInt;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Huynh Trung Nghia
 */
public class Authenticator {

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

    public boolean checkAdmin(String username, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        rs = statement.executeQuery("SELECT * FROM admin WHERE `AdName`='" + username + "'");
        if (rs.next()) {//AdName = username
            String AdPass = rs.getString("AdPass");
            if (password.equals(AdPass)) { // check AdPass
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }
        } else {
            connection.close();
            return false;
        }
    }

    public String checkCustomer(String username, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        rs = statement.executeQuery("SELECT * FROM customer WHERE `CName`='" + username + "'");
        if (rs.next()) {//CName = username
            String CPass = rs.getString("CPass");
            String ID = rs.getString("CID");
            rs = statement.executeQuery("SELECT * FROM ban WHERE `CID`='" + ID + "'");
            if (rs.next()) {
                connection.close();
                return "banned";
            } else if (password.equals(CPass)) {// check CPass
                connection.close();
                return "success";
            } else {

                connection.close();
                return "wrongPass";
            }
        } else {// CName != username
            connection.close();
            return "wrongUsername";
        }
    }

    public boolean checkSame(String CName, int CINumber) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        connectDB();
        rs = statement.executeQuery("SELECT * FROM customer WHERE `CName`='" + CName + "' or `CINumber`=" + CINumber);
        if (rs.next()) {
            connection.close();
            return true;
        } else {
            connection.close();
            return false;
        }
    }

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

// Change this to something else.
    private static String SALT = "123456";

// A password hashing method.
    public String hashPassword(String in) {
        try {
            MessageDigest md = MessageDigest
                    .getInstance("SHA-256");
            md.update(SALT.getBytes());        // <-- Prepend SALT.
            md.update(in.getBytes());
            // md.update(SALT.getBytes());     // <-- Or, append SALT.

            byte[] out = md.digest();
            return bytesToHex(out);            // <-- Return the Hex Hash.
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}

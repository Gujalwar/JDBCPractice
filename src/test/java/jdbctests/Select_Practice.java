package jdbctests;

import java.sql.*;
import java.util.Collections;

public class Select_Practice {
/* 1. Create a connection/query
   2. Create a statement/query
   3.  Store data in resultset
   4. Close connection */

    public static void main(String[] args) throws SQLException {

        String dbURL = "jdbc:mysql://localhost/classicmodels";
        String dbPassword ="12345678";
        String dbUsername = "root";
        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        String s = "select customerNumber, customerName from customers;";
        ResultSet resultSet = statement.executeQuery(s);
        while(resultSet.next()){
            int cNumber = resultSet.getInt("customerNumber");
            String cName = resultSet.getString("customerName");
            System.out.println(cNumber + " " +cName);
        }

        connection.close();

    }


}

package jdbctests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class CRUD_Practice {

    String dbURL = "jdbc:mysql://localhost/classicmodels";
    String dbUsername = "root";
    String dbPassword = "12345678";
    Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
    Statement statement;
    ResultSet resultSet;

    public CRUD_Practice() throws SQLException {
    }

    @Test
    public void createRecord() throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        String query = "INSERT INTO customers VALUES(501,'EuroTech','Ozleblebici','Talha','+44-123-4567','22b', 'Baker Street','London','Center','LN1 1NL','UK',1370,99999);";

        int rowsAffected = statement.executeUpdate(query);

        System.out.println("rowsAffected = " + rowsAffected);

        readRecord(501);

    }


    @Test
    public String readRecord(int customerNumber) throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery("SELECT customerName FROM customers where customerNumber = " + customerNumber + ";");
        resultSet.next();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());
        System.out.println("resultSet.getString(\"customerName\") = " + resultSet.getString("customerName"));

        return resultSet.getString("customerName");
    }


    @Test
    public void updateRecord() throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String newName = "EuroTech Study";
        String query = "UPDATE customers set customerName = '" + newName + "' where customerNumber= 501";
        int rowsAffected = statement.executeUpdate(query);
        System.out.println("rowsAffected = " + rowsAffected);

        Assert.assertEquals(readRecord(501), newName);

    }

    @Test
    public void deleteRecord() throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query= "DELETE from customers where customerNumber = 501";
        int rowsAffected = statement.executeUpdate(query);
        System.out.println("rowsAffected = " + rowsAffected);


        statement.close();
        connection.close();
    }

}

package jdbctests;

import java.sql.*;

public class BaseConnection {
    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:mysql://localhost/school";
        String dbUsername = "root";
        String dbPassword = "12345678";
        System.out.println("------Creating database connection---------");

        //Create a connection
        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);

        //Create a statement
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


        //run a query and get the results in ResultSet object
        ResultSet resultSet = statement.executeQuery("select * from staffdetails;");
        resultSet.next();
        System.out.println("We are in the "+resultSet.getRow()+". Row");
        System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
        System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
        System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
        System.out.println("resultSet.getString(Teacher_Name) = " + resultSet.getString("Teacher_Name"));

        resultSet.next();
        System.out.println("We are in the "+resultSet.getRow()+ ". Row");
        System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
        System.out.println("resultSet.getString(2) = " + resultSet.getString(2));

        resultSet.next();
        System.out.println("We are in the "+resultSet.getRow()+ ". Row");
        System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
        System.out.println("resultSet.getString(3) = " + resultSet.getString(3));

        System.out.println("resultSet.absolute(4) = " + resultSet.absolute(4));
        System.out.println("resultSet.getString(\"Teacher_Name\") = " + resultSet.getString("Teacher_Name"));




    }



}

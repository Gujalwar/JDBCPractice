package jdbctests;


import java.sql.*;

public class InsertPractice {
    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:mysql://localhost/school";
        String dbUsername = "root";
        String dbPassword = "12345678";

        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        //String s = "INSERT INTO StaffDetails (Teacher_Name, Teacher_Surname, Teacher_DOB, Contract_Start_Date, Contract_End_Date )\n" +
               // "VALUES('Shubhrata', 'Naik', '1980-02-12','2020-01-01','2024-12-30');";

        //String s = "UPDATE staffDetails SET Teacher_Name = 'Pooja', Teacher_Surname = 'Gujalwar' WHERE Staff_ID = 9";
        String s = "delete from StaffDetails where Teacher_Name = 'Sunny'";
        statement.execute(s);
        connection.close();


    }


}

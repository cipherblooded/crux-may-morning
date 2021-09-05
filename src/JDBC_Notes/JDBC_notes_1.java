// Getting values from the student table

package JDBC_Notes;

import java.sql.*;

public class JDBC_notes_1 {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/aryan";
    public static final String root = "root";
    public static final String password = "Aryan@123";

    public static void main(String args[]){

        try{

            Class.forName(DRIVER);
            Connection connection= DriverManager.getConnection(url,root,password);
            Statement statement=connection.createStatement();

            /*
            // 1st method
            String sqlQuery = "SELECT * FROM student WHERE Name = 'Aryan Tripathi' or Branch = 'ME' or ID = 3";
            ResultSet resultSet=statement.executeQuery(sqlQuery);
            */


//            /*
            // 2nd method
            String sqlQuery = "SELECT * FROM student WHERE Name = ? or Branch = ? or ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setNString(1, "Aryan Tripathi");
            preparedStatement.setNString(2, "ME");
            preparedStatement.setInt(3, 4);

            ResultSet resultSet = preparedStatement.executeQuery();
//            */


            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" +
                        resultSet.getString(2) + "\t" +
                        resultSet.getString(3) + "\t" +
                        resultSet.getString(4) + "\t" +
                        resultSet.getString(5) + "\t" +
                        resultSet.getString(6));
            }
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}

// Updating the elements of student table

package JDBC_Notes;

import java.sql.*;

public class JDBC_notes_2 {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/aryan";
    public static final String root = "root";
    public static final String password = "root";

    public static void main(String args[]){

        try{

            Class.forName(DRIVER);
            Connection connection= DriverManager.getConnection(url,root,password);
            Statement statement=connection.createStatement();

            /*
            // 1st method
            String sqlQuery = "UPDATE student SET Address = 'New York' WHERE ID = 3";
            int result = statement.executeUpdate(sqlQuery);
            */


//            /*
            // 2nd method
            String sqlQuery = "UPDATE student SET Address = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setNString(1, "lahore");
            preparedStatement.setInt(2, 1);

            int result = preparedStatement.executeUpdate();
//            */

            System.out.println(result+" records affected");
            ResultSet resultSet = statement.executeQuery("select * from student");

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

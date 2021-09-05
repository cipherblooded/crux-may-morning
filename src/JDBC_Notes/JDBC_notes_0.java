package JDBC_Notes;
import java.sql.*;
public class JDBC_notes_0 {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/aryan";
    public static final String root = "root";
    public static final String password = "root";

    public static void main(String args[]){

        try{
            Class.forName(DRIVER);
            Connection connection=DriverManager.getConnection(url,root,password);
            Statement statement=connection.createStatement();

            ResultSet resultSet=statement.executeQuery("select * from student where Name = 'Tripathi'");

            if(!resultSet.next())
                System.out.println("Jai Mata Di");
//                System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3)+"  "+resultSet.getString(4)+"  "+resultSet.getString(5)+"  "+resultSet.getString(6));
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}

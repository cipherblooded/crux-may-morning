package DBMS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Bank {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/bank";
    public static final String root = "root";
    public static final String password = "Aryan@123";
    public static String sqlQuery = null;
    public static PreparedStatement preparedStatement = null;
    public static Connection connection = null;
    public static Statement statement = null;

    private int accno;
    private String name;
    private int balance;

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    void commonPart(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(url, root, password);
            statement = connection.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //method to open an account
    void openAccount() throws IOException {

        System.out.print("Enter Account No: ");
        accno = Integer.parseInt(bufferedReader.readLine());
        System.out.print("Enter Name: ");
        name = bufferedReader.readLine();
        System.out.print("Enter Balance: ");
        balance = Integer.parseInt(bufferedReader.readLine());

        commonPart();

        try {
            sqlQuery = "INSERT INTO customers VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accno);
            preparedStatement.setNString(2, name);
            preparedStatement.setInt(3, balance);
            int result = preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //method to display account details
    void showAccount() {

        commonPart();
        try{
            sqlQuery = "select * from customers";
            ResultSet resultSet=statement.executeQuery(sqlQuery);

            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "  " +
                        resultSet.getString(2) + "  " +
                        resultSet.getInt(3));
            }
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }

    //method to deposit money
    void deposit(int accno)throws IOException {

        int amt;

        System.out.println("Enter Amount U Want to Deposit : ");
        amt = Integer.parseInt(bufferedReader.readLine());

        commonPart();

        sqlQuery = "SELECT Balance FROM customers WHERE Account_No = ?";

        try {

            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accno);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                balance = resultSet.getInt(1);
            }

            balance = balance + amt;
            System.out.println(balance);

            sqlQuery = "UPDATE customers SET Balance = ? WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, balance);
            preparedStatement.setInt(2, accno);

            int result = preparedStatement.executeUpdate();
            connection.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    //method to withdraw money
    void withdrawal(int accno) throws IOException {

        int amt;

        System.out.println("Enter Amount U Want to withdraw : ");
        amt = Integer.parseInt(bufferedReader.readLine());

        commonPart();

        try {

            sqlQuery = "SELECT Balance FROM customers WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accno);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                balance = resultSet.getInt(1);
            }

            if (balance >= amt) {

                balance = balance - amt;
                sqlQuery = "UPDATE customers SET Balance = ? WHERE Account_No = ?";
                preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.setInt(1, balance);
                preparedStatement.setInt(2, accno);
                int result = preparedStatement.executeUpdate();

                if(result==1){
                    System.out.println("Transaction Completed");
                }

            } else {
                System.out.println("Less Balance..Transaction Failed..");
            }
            connection.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    //method to search an account number
    boolean search(int acn) {

        commonPart();

        try{
            sqlQuery = "SELECT * FROM customers WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, acn);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet==null){
                return false;
            }else {
                while(resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + "  " +
                            resultSet.getString(2) + "  " +
                            resultSet.getInt(3));
                }
            }
            connection.close();
            return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
}


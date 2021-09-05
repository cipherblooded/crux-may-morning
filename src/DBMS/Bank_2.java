package DBMS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Bank_2 {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/bank";
    public static final String root = "root";
    public static final String password = "Aryan@123";
    public static String sqlQuery = null;
    public static PreparedStatement preparedStatement = null;
    public static Connection connection = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;

    private int accountNo;
    private String name;
    private String accountType;
    private int balance;

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    void startConnection() {

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(url, root, password);
            statement = connection.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    void endConnection() {

        try{
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    //method to open an account
    void openAccount() throws IOException {

        System.out.print("Enter Account No: ");
        accountNo = Integer.parseInt(bufferedReader.readLine());
        System.out.print("Enter Name: ");
        name = bufferedReader.readLine();
        System.out.print("Enter Account Type:");
        accountType = accountType();
        System.out.print("Enter Balance: ");
        balance = Integer.parseInt(bufferedReader.readLine());

        try {

            startConnection();
            sqlQuery = "INSERT INTO customers VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accountNo);
            preparedStatement.setNString(2, name);
            preparedStatement.setNString(3, accountType);
            preparedStatement.setInt(4, balance);
            int result = preparedStatement.executeUpdate();

            sqlQuery = "SELECT * FROM customers WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accountNo);
            resultSet = preparedStatement.executeQuery();
            printAccountDetails(resultSet);

            endConnection();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    //method to display account details

    void printAllAccountDetails() throws IOException{

        try{
            startConnection();
            sqlQuery = "select * from customers";
            ResultSet resultSet=statement.executeQuery(sqlQuery);
            printAccountDetails(resultSet);
            endConnection();
        }catch(Exception e){
            System.out.println(e);
        }

    }

    //method to deposit money
    void deposit(int accountNo)throws IOException {

        System.out.println("Enter Amount U Want to Deposit : ");
        int amount = Integer.parseInt(bufferedReader.readLine());

        try {
            startConnection();
            sqlQuery = "SELECT Balance FROM customers WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accountNo);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                balance = resultSet.getInt(1);
            }

            balance = balance + amount;

            sqlQuery = "UPDATE customers SET Balance = ? WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, balance);
            preparedStatement.setInt(2, accountNo);

            int result = preparedStatement.executeUpdate();

            if(result==1){

                System.out.println("Transaction Completed ");
                sqlQuery = "SELECT * FROM customers WHERE Account_No = ?";
                preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.setInt(1, accountNo);
                resultSet = preparedStatement.executeQuery();
                printAccountDetails(resultSet);

            }else {
                System.out.println("Transaction Failed");
            }
            endConnection();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    //method to withdraw money
    void withdrawal(int accountNo) throws IOException {

        int amt;

        System.out.println("Enter Amount You Want to withdraw : ");
        amt = Integer.parseInt(bufferedReader.readLine());

        try {
            startConnection();
            sqlQuery = "SELECT Balance FROM customers WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accountNo);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                balance = resultSet.getInt(1);
            }

            if (balance >= amt) {

                balance = balance - amt;
                sqlQuery = "UPDATE customers SET Balance = ? WHERE Account_No = ?";
                preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.setInt(1, balance);
                preparedStatement.setInt(2, accountNo);
                int result = preparedStatement.executeUpdate();

                if(result==1){

                    System.out.println("Transaction Completed");
                    sqlQuery = "SELECT * FROM customers WHERE Account_No = ?";
                    preparedStatement = connection.prepareStatement(sqlQuery);
                    preparedStatement.setInt(1, accountNo);
                    resultSet = preparedStatement.executeQuery();
                    printAccountDetails(resultSet);

                }else {
                    System.out.println("Transaction Failed");
                }

            } else {
                System.out.println("Less Balance..Transaction Failed..");
            }
            endConnection();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    //method to search an account number
    boolean search(int accountNo) throws IOException {

        try{
            startConnection();
            sqlQuery = "SELECT * FROM customers WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accountNo);
            resultSet = preparedStatement.executeQuery();

            if(resultSet==null){
                endConnection();
                return false;
            }else {
                printAccountDetails(resultSet);
                endConnection();
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    private void printAccountDetails(ResultSet resultSet) {

        try {
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "  " +
                        resultSet.getString(2) + "  " +
                        resultSet.getString(3) + "  " +
                        resultSet.getInt(4));
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    String accountType() throws IOException{

        while (true){
            System.out.println("Press 1 for Saving Bank Account");
            System.out.println("Press 2 for Current Bank Account");
            String choice = bufferedReader.readLine();
            if(choice.equals("1")) {
                return "SA";
            }else if(choice.equals("2")){
                return "CA";
            }else{
                System.out.println("Invalid Choice, Please try Again");
            }
        }

    }
}
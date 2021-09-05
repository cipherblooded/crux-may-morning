package DBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Bank_4 {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/bank";
    private static final String root = "root";
    private static final String password = "root";

    public static String sqlQuery = null;
    public static PreparedStatement preparedStatement = null;
    public static Connection connection = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;

    private int balance;

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void startConnection() {

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(url, root, password);
            statement = connection.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void endConnection() {

        try{
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //method to open an account
    public void openAccount() throws IOException {

        System.out.println("Enter Account No: ");
        int accountNo = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter Name: ");
        String name = bufferedReader.readLine();
        String userID = "anti@bank" + accountNo;
        String userPassword = setUserPassword();
        System.out.println("Enter Account Type:");
        String accountType = setAccountType();
        System.out.println("Enter Balance: ");
        balance = Integer.parseInt(bufferedReader.readLine());

        try {

            sqlQuery = "INSERT INTO customers VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accountNo);
            preparedStatement.setNString(2, name);
            preparedStatement.setNString(3, userID);
            preparedStatement.setNString(4, userPassword);
            preparedStatement.setNString(5, accountType);
            preparedStatement.setInt(6, balance);
            int result = preparedStatement.executeUpdate();

            if(result==1){
                printSingleAccountDetail(accountNo);
            }
            else {
                System.out.println("Account can n't be created");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    //method to display account details

    public void printAllAccountDetails() throws IOException{

        try{
            sqlQuery = "select * from customers";
            resultSet=statement.executeQuery(sqlQuery);
            printResultSet(resultSet);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public void printSingleAccountDetail(int accountNo) {

        try {
            sqlQuery = "SELECT * FROM customers WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accountNo);
            resultSet = preparedStatement.executeQuery();
            printResultSet(resultSet);

        }catch (Exception e){
            System.out.println(e);
        }

    }

    private void printResultSet(ResultSet resultSet) {

        try{
            int flag=0;
            String s1,s2,s3,s4,s5,s6;

            while(resultSet.next()) {

                if(flag==0){
                    s1="Account No ";s2="Name";s3="User Id";s4="Password";s5="Account Type";s6="Balance";
                    System.out.println(s1+getSpaces(15-s1.length())+
                            s2+getSpaces(20-s2.length())+
                            s3+getSpaces(20-s3.length())+
//                            s4+getSpaces(20-s4.length())+
                            s5+getSpaces(15-s5.length())+
                            s6);
                    flag=1;
                }

                s1=resultSet.getInt(1)+"";s2=resultSet.getString(2);s3=resultSet.getString(3);
                s4=resultSet.getString(4);s5=resultSet.getString(5);s6=resultSet.getInt(6)+"";

                System.out.println(
                        s1+getSpaces(15-s1.length())+
                                s2+getSpaces(20-s2.length())+
                                s3+getSpaces(20-s3.length())+
//                                s4+getSpaces(20-s4.length())+
                                s5+getSpaces(15-s5.length())+
                                s6
                );
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //method to deposit money
    public void deposit(int accountNo)throws IOException {

        System.out.println("Enter Amount U Want to Deposit : ");
        int amount = Integer.parseInt(bufferedReader.readLine());

        try {

            balance = getBalance(accountNo);
            balance = balance + amount;
            setBalance(accountNo, balance);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    //method to withdraw money
    public void withdrawal(int accountNo) throws IOException {

        int amt;

        System.out.println("Enter Amount You Want to withdraw : ");
        amt = Integer.parseInt(bufferedReader.readLine());

        try {
            balance = getBalance(accountNo);
            if (balance >= amt) {

                balance = balance - amt;
                setBalance(accountNo, balance);

            } else {
                System.out.println("Less Balance..Transaction Failed..");
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    //method to search an account number
    public boolean search(int accountNo) throws IOException {

        try{
            sqlQuery = "SELECT * FROM customers WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accountNo);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next() ) {
                return false;
            } else {
                return true;
            }

        }catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean login(String userName, String userPassword){

        try{

            sqlQuery = "SELECT User_ID, Password FROM customers WHERE User_ID = ? and Password = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPassword);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Invalid UserId or Password, Please try again\n");
                return false;
            } else {

                String UN = resultSet.getString(1);
                String UP = resultSet.getString(2);

                if(UN.equals(userName) && UP.equals(userPassword)){
                    System.out.println("Welcome, You have logged in");
                    return true;
                }else if(!UN.equals(userName)){
                    System.out.println("Invalid UserID, Please try Again\n");
                    return false;
                }else {
                    System.out.println("Invalid Password, Please try Again\n");
                    return false;
                }
            }
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    private int getBalance(int accountNo) {

        try{
            sqlQuery = "SELECT Balance FROM customers WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, accountNo);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                balance = resultSet.getInt(1);
            }
            return balance;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }

    }

    private void setBalance(int accountNo, int balance) {

        try{
            sqlQuery = "UPDATE customers SET Balance = ? WHERE Account_No = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, balance);
            preparedStatement.setInt(2, accountNo);
            int status = preparedStatement.executeUpdate();

            if(status==1){
                System.out.println("Transaction Completed ");
                printSingleAccountDetail(accountNo);

            }else {
                System.out.println("Transaction Failed");
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }

    private String setAccountType() throws IOException{

        while (true){
            System.out.println("Press 1 for Saving Bank Account \nPress 2 for Current Bank Account :");
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

    private String setUserPassword() throws IOException {

        String pass=null;
        boolean flag1, flag2, flag3, flag4;
        char ch = ' ';

        while (true){

            flag1 = false;flag2 = false;flag3 = false;flag4 = false;

            System.out.println("Enter Your Password: ");
            pass = bufferedReader.readLine();

            if(pass.length()>=8){
                for (int i = 0; i < pass.length(); i++) {
                    ch= pass.charAt(i);
                    if(ch>=65&&ch<=90){
                        flag1=true;
                    }else if(ch>=97&&ch<=122){
                        flag2=true;
                    }else if(ch>=48&&ch<=57){
                        flag3=true;
                    }else if(ch>=35&&ch<=38||ch==63||ch==64){
                        flag4=true;
                    }
                }
                if (flag1&&flag2&&flag3&&flag4){
                    return pass;
                }else {
                    System.out.println("Your Password is too week to set, Please Try Again");
                }
            }else {
                System.out.println("Your Password is too week to set, Please Try Again");
            }
        }
    }

    public int getAccountNumber(String userID) {

        int accountNumber = 0;
        try{
            sqlQuery = "SELECT Account_No FROM customers WHERE User_ID = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, userID);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                accountNumber = resultSet.getInt(1);
            }
            return accountNumber;
        }catch (Exception e){
            System.out.println(e);
            return accountNumber;
        }

    }

    private String getSpaces(int length){

        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();

    }
}
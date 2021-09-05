package DBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExBank_4 {

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Bank_4 bank = new Bank_4();

        bank.startConnection();
        char choice;
        int accountNumber;
        boolean found;

        while (true){

            System.out.println("Main Menu :\n" +
                    "1. Open Bank Account    " +
                    "2. Display All Account    " +
                    "3. Search By Account    " +
                    "4. Deposit    " +
                    "5. Withdrawal    " +
                    "6. Exit");

            System.out.print("Please Enter Your Choice : ");
            choice = bufferedReader.readLine().charAt(0);

            if(choice=='1') {
                bank.openAccount();
            } else if(choice=='2') {
                bank.printAllAccountDetails();
            }else if(choice=='3') {

                System.out.print("Enter Account No U Want to Search...: ");
                accountNumber = Integer.parseInt(bufferedReader.readLine());
                found = bank.search(accountNumber);
                if (found) {
                    bank.printSingleAccountDetail(accountNumber);
                }else {
                    System.out.println("Search Failed..Account Not Exist..");
                }

            }else if(choice=='4') {

                while (true){
                    System.out.print("Please enter your userid : ");
                    String userID= bufferedReader.readLine();
                    System.out.print("Please enter your password : ");
                    String userPassword= bufferedReader.readLine();

                    if(bank.login(userID, userPassword)){
                        accountNumber = bank.getAccountNumber(userID);
                        found = bank.search(accountNumber);
                        bank.deposit(accountNumber);
                        System.out.println("Thank You, you have been logged out");
                        break;
                    }
                }
            }else if(choice=='5') {

                while (true){
                    System.out.print("Please enter your userid : ");
                    String userID= bufferedReader.readLine();
                    System.out.print("Please enter your Password : ");
                    String userPassword= bufferedReader.readLine();

                    if(bank.login(userID, userPassword)){
                        accountNumber = bank.getAccountNumber(userID);
                        found = bank.search(accountNumber);
                        bank.withdrawal(accountNumber);
                        System.out.println("Thank You, you have been logged out");
                        break;
                    }
                }

            }else if(choice=='6') {

                System.out.println("Good Bye..");
                break;

            }else {
                System.out.println("Invalid Choice, Please try again.");
            }
            System.out.println();
        }
        bank.endConnection();
    }
}
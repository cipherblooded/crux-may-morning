package DBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExBank_3 {

    public static void main(String arg[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Bank_3 bank = new Bank_3();

        bank.startConnection();
        char choice;
        int accountNumber;
        boolean found;

        while (true){

            System.out.println("\nMain Menu :\n" +
                    "1. Open Bank Account\t\t" +
                    "2. Display All Account\t\t" +
                    "3. Search By Account\t\t" +
                    "4. Deposit \t\t" +
                    "5. Withdrawal\t\t" +
                    "6. Exit \n");

            System.out.println("Please Enter Your Choice :");
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
                    bank.singleAccountDetail(accountNumber);
                }else {
                    System.out.println("Search Failed..Account Not Exist..");
                }

            }else if(choice=='4') {

                System.out.print("Enter Account No : ");
                accountNumber = Integer.parseInt(bufferedReader.readLine());
                found = bank.search(accountNumber);
                if (found) {
                    bank.deposit(accountNumber);
                }else {
                    System.out.println("Search Failed..Account Not Exist..");
                }

            }else if(choice=='5') {

                System.out.print("Enter Account No : ");
                accountNumber = Integer.parseInt(bufferedReader.readLine());
                found = bank.search(accountNumber);
                if (found) {
                    bank.withdrawal(accountNumber);
                }else {
                    System.out.println("Search Failed..Account Not Exist..");
                }

            }else if(choice=='6') {

                System.out.println("Good Bye..");
                break;

            }else {
                System.out.println("Invalid Choice, Please try again.");
            }
        }
        bank.endConnection();
    }
}


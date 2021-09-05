package DBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExBank {

    public static void main(String arg[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Bank bank = new Bank();

        int ch;

        while (true){

            System.out.println("\nMain Menu :\n" +
                    "1. Open Bank Account\t\t" +
                    "2. Display All Account\t\t" +
                    "3. Search By Account\t\t" +
                    "4. Deposit \t\t" +
                    "5. Withdrawal\t\t" +
                    "6. Exit \n");
            System.out.println("Please Enter Your Choice :");
            ch = Integer.parseInt(bufferedReader.readLine());
            switch (ch) {
                case 1:
                    bank.openAccount();
                    break;
                case 2:
                    bank.showAccount();
                    break;

                case 3:
                    System.out.print("Enter Account No U Want to Search...: ");
                    int acn = Integer.parseInt(bufferedReader.readLine());
                    boolean found = bank.search(acn);
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account No : ");
                    acn = Integer.parseInt(bufferedReader.readLine());
                    found = false;

                    found = bank.search(acn);
                    if (found) {
                        bank.deposit(acn);
                        break;
                    }else {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account No : ");
                    acn = Integer.parseInt(bufferedReader.readLine());
                    found = false;

                    found = bank.search(acn);
                    if (found) {
                        bank.withdrawal(acn);
                        break;
                    }else {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 6:
                    System.out.println("Good Bye..");
                    break;
            }
        }
    }
}


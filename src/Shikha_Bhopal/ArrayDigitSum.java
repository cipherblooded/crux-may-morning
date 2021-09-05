package Shikha_Bhopal;

import java.util.Scanner;

public class ArrayDigitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int []arr = new int[n];

        int [] ans = new int[n];
        int temp,sum;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


        for (int i = 0; i < n; i++) {
            temp = arr[i];
            sum = 0;

            while (temp>0){
                sum = sum+(temp%10);
                temp/=10;
            }
            ans[i] = sum;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}

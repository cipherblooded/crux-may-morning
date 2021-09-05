package Shikha_Bhopal;

import java.util.Scanner;

public class brij {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int []arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        for (int i = 0; i < n-1; i++) {
            if(arr[i]+1<arr[i+1]){
                System.out.println("false");
            }
        }
        if(arr[0]!=1 || arr[n-1]!=k){
            System.out.println("false");
        }else {
            System.out.println("true");
        }
    }
}

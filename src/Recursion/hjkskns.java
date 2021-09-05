package Recursion;

import java.util.Scanner;

public class hjkskns {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int minIndex = Integer.MAX_VALUE;
        String []arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
            if(minIndex>arr[i].length()){
                minIndex = arr[i].length();
            }

        }

        if(minIndex==0){
            System.out.println("");
            return;
        }

        int index = 0;
        for (int i = 0; i < minIndex; i++) {
            for (int j = 1; j < arr.length; j++) {
                if(arr[j].charAt(i)!=arr[0].charAt(i)){
                    System.out.println(arr[0].substring(0,i));
                    break;
                }
            }
        }
    }
}

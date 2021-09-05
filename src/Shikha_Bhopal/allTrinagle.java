package Shikha_Bhopal;

import java.util.Arrays;
import java.util.Scanner;

public class allTrinagle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String []arrOfS = s.split(" ");
        int []arr = new int[arrOfS.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(arrOfS[i]);
        }

        int count = allPossibleTriangle(arr);
        System.out.println(count);
    }

    private static int allPossibleTriangle(int[] arr) {

        int j,k;
        int count = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            j = i+1;
            k = arr.length-1;
            while (j<k){
                boolean res = isTrinagle(arr[i],arr[j],arr[k]);
                if(res){
                    count++;
                }
                if(arr[i]+arr[j]<arr[k]){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return count;
    }

    private static boolean isTrinagle(int i, int j, int k) {
        if(i+j<k){
            return false;
        }else if(i+k<j){
            return false;
        }else if(j+k<i){
            return false;
        }
        return true;
    }
}

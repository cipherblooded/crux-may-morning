package Shikha_Bhopal;

import java.util.Scanner;

public class BinaryString {
    private static String finalans = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.nextLine();
        int cash = scanner.nextInt();
        int costToSwap = scanner.nextInt();
        int costToFlip = scanner.nextInt();
        finalans = s;
        convert(s,n,cash, costToFlip, costToSwap,0, "");
    }

    private static void convert(String s, int n, int cash, int costToFlip, int costToSwap, int index, String ans) {
        if(index==n){
            if(finalans.compareTo(ans)>0){
                finalans = ans;
            }
            return;
        }

        if(costToFlip<cash){
            if(s.charAt(index)=='1'){
                convert(s,n,cash-costToFlip, costToFlip, costToSwap, index+1, ans+'0');
            }else {
                convert(s,n,cash, costToFlip, costToSwap, index+1, ans+'0');
            }
        }else {

        }
    }
}

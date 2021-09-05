package Shikha_Bhopal;

import java.util.Scanner;

public class Ency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringBuilder stringBuilder = new StringBuilder(""); // this is empty string
        int j = 0;
        int k = 1;

        for (int i = 0; i < s.length()/2; i++) {
            stringBuilder.append(s.charAt(k)).append(s.charAt(j));
            j+=2;
            k+=2;
        }

        if(s.length()%2!=0){
            stringBuilder.append(s.charAt(s.length()-1));
        }
        System.out.println(stringBuilder);
    }
}

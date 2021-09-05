package Recursion;

import java.util.Scanner;

public class dgd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int ans = LetterComb(s,"",0);
        System.out.println();
        System.out.println(ans);
    }
    public static int LetterComb(String str, String ans, int count) {
        if (str.length() == 0) {
            count++;
            System.out.print(ans+" ");
            return count;
        }
        char ch = str.charAt(0); // select a
        String part = str.substring(1);// a divide bc == sp
        String mapped = getComb(ch);
        for(int i=0;i<mapped.length();i++) {
            count = LetterComb(part, ans+mapped.charAt(i), count);
        }
        return count;
    }
    public static String getComb(char ch) {
        if (ch == '1') {
            return "abc";
        } else if (ch == '2') {

            return "def";
        } else if (ch == '3') {

            return "ghi";
        } else if (ch == '4') {

            return "jkl";
        } else if (ch == '5') {

            return "mno";
        } else if (ch == '6') {

            return "pqrs";
        } else if (ch == '7') {

            return "tuv";
        } else if (ch == '8') {

            return "wxyz";
        }
        return "";
    }
}


package Shikha_Bhopal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BalancedParenthesis {
    public static HashMap<String, Integer> hashMap = new HashMap<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];

        String s[]  = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();

            s[i] = Integer.toBinaryString(arr[i]);

            int count = 0;
            for (int j = 0; j < s[i].length(); j++) {
                if(s[i].charAt(j)=='1'){
                    count++;
                }
            }
            hashMap.put(s[i],count);
        }
//        System.out.println(Arrays.toString(s));


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1 ; j++) {
                if(compare(s[j],s[j+1])>0){
                    String temp = s[j];
                    s[j] = s[j+1];
                    s[j+1] = temp;
                }
            }
        }

        for (int i = s.length-1; i >= 0; i--) {
            arr[n-1-i] = Integer.parseInt(s[i],2);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int compare(String s1, String s2) {
        
        Integer c1 = hashMap.get(s1);
        Integer c2 = hashMap.get(s2);
        
        if(c1>c2){
            return 1;
        }else if(c1<c2) {
            return -1;
        }else {
            if(s1.length()>s2.length()){
                return 1;
            }else if(s1.length()<s2.length()){
                return -1;
            }else {
                if(s1.compareTo(s2)>0){
                    return 1;
                }else {
                    return 0;
                }
            }
        }
    }
}

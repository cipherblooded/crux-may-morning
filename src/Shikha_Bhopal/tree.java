//package Shikha_Bhopal;
//
//import java.util.Scanner;
//
//public class tree {
//    public static long count = 0;
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        int []arr = new int[n];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        combination(N,K,0,"");
//        long ans = count%((long)(Math.pow(10,9)+7));
//        System.out.println(ans);
//    }
//
//    private static void combination(int n, int k, int index, String s) {
//
//        if (index==n){
//            StringBuilder stringBuilder = new StringBuilder("");
//            int flag = 0;
//            int tempCount = 0;
//
//            for (int i = 0; i < s.length(); i++) {
//                if(stringBuilder.length()<k){
//                    stringBuilder.append(s.charAt(i));
//                    if(stringBuilder.charAt(stringBuilder.length()-1)=='1'){
//                        tempCount++;
//                    }
//                }else {
//                    if(stringBuilder.charAt(0)=='1'){
//                        tempCount--;
//                    }
//                    stringBuilder.deleteCharAt(0); // deleting a char form first index
//
//                    stringBuilder.append(s.charAt(i)); // adding a char to last index
//                    if(stringBuilder.charAt(stringBuilder.length()-1)=='1'){
//                        tempCount++;
//                    }
//                }
//                if(stringBuilder.length()==k){
//                    if(tempCount>1){
//                        flag= 1;
//                    }
//                }
//            }
//            if(flag==0){
//                count++;
//            }
//            return;
//        }
//        combination(n,k,index+1, s+'1');// black
//        combination(n,k,index+1,s+'0');// white
//    }
//}

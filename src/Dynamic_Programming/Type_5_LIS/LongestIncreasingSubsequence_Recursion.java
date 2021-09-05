package Dynamic_Programming.Type_5_LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence_Recursion {

    public static void main(String[] args) {

        int [] arr = {1,5,4,2,3,7,6};
        int [] brr = Arrays.copyOf(arr,arr.length);
        Arrays.sort(brr);
        int m=arr.length;
        int n=brr.length;
        int result = lISubsequence(arr, brr, m, n);
        System.out.println(result);

    }

    private static int lISubsequence(int []arr, int []brr, int m, int n) {

        if(m==0||n==0){
            return 0;
        }
        if(arr[m-1]==brr[n-1]){
            return 1 + lISubsequence(arr, brr, m-1, n-1);
        }else {
            return Math.max(lISubsequence(arr, brr, m, n-1),lISubsequence(arr, brr, m-1, n));
        }

    }
}


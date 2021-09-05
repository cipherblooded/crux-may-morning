package Dynamic_Programming.Type_5_LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence_Memorization {

    public static void main(String[] args) {

        int [] arr = {1,5,4,2,3,7,6};
        int [] brr = Arrays.copyOf(arr,arr.length);
        Arrays.sort(brr);
        int m=arr.length;
        int n=brr.length;

        int [][]t = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j <n+1; j++) {
                t[i][j]=-1;
            }
        }

        int result = lISubsequence(arr, brr, m, n, t);
        System.out.println(result);

    }

    private static int lISubsequence(int []arr, int []brr, int m, int n, int [][]t) {

        if(m==0||n==0){
            return 0;
        }

        // Memorization
        if(t[m][n]!=-1){
            return t[m][n];
        }

        if(arr[m-1]==brr[n-1]){
            t[m][n] = 1 + lISubsequence(arr, brr, m-1, n-1, t);
            return t[m][n];
        }else {
            t[m][n] = Math.max(lISubsequence(arr, brr, m, n-1, t),lISubsequence(arr, brr, m-1, n, t));
            return t[m][n];
        }

    }
}

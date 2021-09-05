package Dynamic_Programming.Type_5_LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence_TopDown {

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

        int result = liSubSequence(arr, brr, m, n, t);
        System.out.println(result);

    }


    private static int liSubSequence(int []arr, int []brr, int m, int n, int [][]t) {

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(i==0||j==0){
                    t[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(arr[i-1]==brr[j-1]){
                    t[i][j] = 1+t[i-1][j-1];
                }else {
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }
        return t[m][n];
    }

}

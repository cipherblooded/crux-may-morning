package Dynamic_Programming.Type_2_UnBoundedKnapsack.RodCutting;

public class RodCutting_TopDown {
    public static void main(String[] args) {

        int []price = {1, 2, 3, 4, 5, 6, 7};
        int []len = {3, 5, 1, 7, 11, 2, 6};

        int w=7; // total length of the rod
        int n=len.length;

        int [][]dp = new int[n+1][w+1];
        int result = rodCutting(len,price,w,n,dp);
        System.out.println(result);

    }

    private static int rodCutting(int[] len, int[] price, int w, int n,int dp[][]) {

        // Base Condition
        for (int i = 0; i < n+1 ; i++) {
            for (int j = 0; j < w+1; j++) {

                if(i==0||j==0){
                    dp[i][j]=0;
                }

            }
        }

        // Choice Diagram
        for (int i = 1; i < n+1 ; i++) {
            for (int j = 1; j < w+1; j++) {

                if(len[i-1]<=j){
                    dp[i][j] = Math.max( price[i-1]+ dp[i][j-len[i-1]], dp[i-1][j]);
                }else if(len[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }

            }
        }
        return dp[n][w];
    }
}

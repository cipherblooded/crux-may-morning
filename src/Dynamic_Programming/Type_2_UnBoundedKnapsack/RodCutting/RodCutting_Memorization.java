package Dynamic_Programming.Type_2_UnBoundedKnapsack.RodCutting;

public class RodCutting_Memorization {
    public static void main(String[] args) {

        int []price={1, 2, 3, 4, 5, 6, 7};
        int []len={3, 5, 1, 7, 11, 2, 6};

        int w=7; // total length of the rod

        int n=len.length;
        int [][]dp = new int[n+1][w+1];

        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <w+1 ; j++) {
                dp[i][j]=-1;
            }
        }

        int result = rodCutting(len,price,w,n,dp);
        System.out.println(result);
    }

    private static int rodCutting(int[] len, int[] price, int w, int n,int [][]dp) {
        if(n==0||w==0){
            return 0;
        }

        // Memorization
        if(dp[n][w]!=-1){
            return dp[n][w];
        }

        if(len[n-1]<=w){

            int selected = price[n-1]+ rodCutting(len,price,w-len[n-1], n,dp);
            int rejected = rodCutting(len,price,w, n-1,dp);
            dp[n][w] = Math.max(selected, rejected);
            return dp[n][w];

        }else{
            dp[n][w] = rodCutting(len, price,w, n-1,dp);
            return dp[n][w];
        }
    }
}

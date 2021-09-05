package Dynamic_Programming.Type_2_UnBoundedKnapsack.CoinChange_I;

public class CoinChange_I_TopDown {

    public static void main(String[] args) {

        int []coin= {1,2,3};
        int sum=5;
        int n=coin.length;
        int [][]t=new int[n+1][sum+1];
        int result = coinChange(coin,sum,n,t);
        System.out.println(result);

    }

    private static int coinChange(int[] coin, int sum, int n, int[][] t) {

        // Base Condition
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(i==0){
                    t[i][j]=0;
                }if(j==0){
                    t[i][j]=1;
                }
            }
        }

        // Choice Diagram
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(coin[i-1]<=j){
                    t[i][j] = t[i][j-coin[i-1]] + t[i-1][j];
                }
                else if (coin[i-1]>j){
                    t[i][j]= t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}

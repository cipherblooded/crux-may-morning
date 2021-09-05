package Dynamic_Programming.Type_2_UnBoundedKnapsack.CoinChange_I;

public class CoinChange_I_Memorization {

    public static void main(String[] args) {

        int []coin= {1,2,3};
        int sum=5;
        int n=coin.length;
        int [][]t = new int[n+1][sum+1];

        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <sum+1 ; j++) {
                t[i][j]=-1;
            }
        }

        int result = coinChange(coin,sum,n,t);
        System.out.println(result);

    }

    private static int coinChange(int[] coin, int sum, int n, int[][]t) {

        if(n==0&&sum==0){
            return 1;
        }
        if(sum==0){
            return 1;
        }
        if(n==0){
            return 0;
        }

        // Memorization
        if(t[n][sum]!=-1){
            return t[n][sum];
        }

        if(coin[n-1]<=sum){
            t[n][sum] = coinChange(coin,sum-coin[n-1], n,t) + coinChange(coin,sum, n-1,t);
            return t[n][sum];
        }else if(coin[n-1]>sum){
            t[n][sum] = coinChange(coin,sum, n-1,t);
            return t[n][sum];
        }
        return t[n][sum];
    }
}

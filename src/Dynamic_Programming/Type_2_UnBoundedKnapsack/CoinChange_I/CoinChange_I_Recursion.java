package Dynamic_Programming.Type_2_UnBoundedKnapsack.CoinChange_I;

public class CoinChange_I_Recursion {

    public static void main(String[] args) {

        int []coin= {1,2,3};
        int sum=5;
        int n=coin.length;
        int result = coinChange(coin,sum,n);
        System.out.println(result);

    }
    private static int coinChange(int[] coin, int sum, int n) {

        if(n==0&&sum==0){
            return 1;
        }
        if(sum==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(coin[n-1]<=sum){
            int selected = coinChange(coin,sum-coin[n-1], n);
            int rejected = coinChange(coin,sum, n-1);
            return selected+rejected;
        }else{
            return coinChange(coin,sum, n-1);
        }

    }
}

package Dynamic_Programming.Type_1_ZeroOneKnapsack.HasSubsetSum;

public class HasSubsetSum_Memorization {

    public static void main(String[] args) {

        int []arr= {1,2,3,4,5,6};
        int sum=7;
        int n=arr.length;
        boolean [][]t =new boolean[n+1][sum+1];
        boolean result = subsetSum(arr,sum,n,t);
        System.out.println(result);

    }

    private static boolean subsetSum(int[] arr, int sum, int n, boolean[][] t) {

        if(n==0&&sum==0){
            return true;
        }
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }

        // Memorization
        if(t[n][sum]){
            return true;
        }

        if(arr[n-1]<=sum){
            t[n][sum] = subsetSum(arr,sum-arr[n-1], n-1,t) || subsetSum(arr,sum, n-1,t);
            return t[n][sum];
        }else if(arr[n-1]>sum){
            t[n][sum] = subsetSum(arr,sum, n-1,t);
            return t[n][sum];
        }
        return t[n][sum];
    }
}

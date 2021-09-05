package Dynamic_Programming.Type_1_ZeroOneKnapsack.HasSubsetSum;

public class HasSubsetSum_Recursion {

    public static void main(String[] args) {

        int []arr= {1,2,3,4,5,6};
        int sum=7;
        int n=arr.length;
        boolean result = subsetSum(arr,sum,n);
        System.out.println(result);

    }

    private static boolean subsetSum(int[] arr, int sum, int n) {

        if(n==0&&sum==0){
            return true;
        }
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(arr[n-1]<=sum){
            return subsetSum(arr,sum-arr[n-1], n-1) || subsetSum(arr,sum, n-1);
        }else{
            return subsetSum(arr,sum, n-1);
        }

    }
}

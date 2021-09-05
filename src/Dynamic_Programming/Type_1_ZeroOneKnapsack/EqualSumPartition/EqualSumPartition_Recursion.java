package Dynamic_Programming.Type_1_ZeroOneKnapsack.EqualSumPartition;

public class EqualSumPartition_Recursion {

    public static void main(String[] args) {

        int []arr= {2,2,3,4,5,6};
        int sum=11;
        int n= arr.length;
        boolean result = equalSumPartition(arr,sum,n);
        System.out.println(result);

    }

    private static boolean equalSumPartition(int[] arr, int sum, int n) {

        int totalSum=0;
        for (int i = 0; i < n; i++) {
            totalSum = totalSum + arr[i];
        }
        if(totalSum%2==0){
            return subsetSum(arr,sum,n);
        }else{
            return false;
        }

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

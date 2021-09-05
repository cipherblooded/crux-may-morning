package Dynamic_Programming.Type_1_ZeroOneKnapsack.CountSubsetSum;

public class CountSubsetSum_Recursion {

    public static void main(String[] args) {

        int []arr= {2,3,5,8,10};
        int sum=10;
        int n=arr.length;
        int result = countSubsetSum(arr,sum,n);
        System.out.println(result);

    }
    private static int countSubsetSum(int[] arr, int sum, int n) {
        if(n==0&&sum==0){
            return 1;
        }
        if(sum==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(arr[n-1]<=sum){
            return countSubsetSum(arr,sum-arr[n-1], n-1) + countSubsetSum(arr,sum, n-1);
        }else{
            return countSubsetSum(arr,sum, n-1);
        }
    }
}

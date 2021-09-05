package Dynamic_Programming.Type_1_ZeroOneKnapsack.SubsetWithAGivenDifference;

// Count the number of subset with a given difference or target sum

public class CountSubsetDifference_Recursion {

    public static void main(String[] args) {

        int []arr= {1,1,2,3};
        int difference = 1;
        int n=arr.length;

        int sum = (difference + sumOfAllElements(arr))/2;

        int result = countSubsetSum(arr,sum,n);
        System.out.println(result);

    }

    private static int sumOfAllElements(int[] arr) {

        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;

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

package Dynamic_Programming.Type_1_ZeroOneKnapsack.SubsetWithAGivenDifference;

// Count the number of subset with a given difference or target sum

public class CountSubsetDifference_Memorization {

    public static void main(String[] args) {

        int []arr= {1,1,2,3};
        int n=arr.length;
        int difference = 1;

        int sum = (difference + sumOfAllElements(arr))/2;

        int [][]t = new int[n+1][sum+1];

        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <sum+1 ; j++) {
                t[i][j]=-1;
            }
        }

        int result = countSubsetSum(arr,sum,n,t);
        System.out.println(result);
    }

    private static int sumOfAllElements(int[] arr) {

        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    private static int countSubsetSum(int[] arr, int sum, int n, int[][] t) {

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

        if(arr[n-1]<=sum){
            t[n][sum] = countSubsetSum(arr,sum-arr[n-1], n-1,t) + countSubsetSum(arr,sum, n-1,t);
            return t[n][sum];
        }else if(arr[n-1]>sum){
            t[n][sum] = countSubsetSum(arr,sum, n-1,t);
            return t[n][sum];
        }
        return t[n][sum];

    }
}

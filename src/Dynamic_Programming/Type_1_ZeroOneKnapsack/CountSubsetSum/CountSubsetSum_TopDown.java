package Dynamic_Programming.Type_1_ZeroOneKnapsack.CountSubsetSum;

public class CountSubsetSum_TopDown {

    public static void main(String[] args) {

        int arr[]= {2,3,5,8,10};
        int sum=10,n=arr.length;
        int t[][]=new int[n+1][sum+1];
        int result = countSubsetSum(arr,sum,n,t);
        System.out.println(result);

    }

    private static int countSubsetSum(int[] arr, int sum, int n, int[][] t) {

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
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else if (arr[i-1]>j){
                    t[i][j]= t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}

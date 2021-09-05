package Dynamic_Programming.Type_1_ZeroOneKnapsack.EqualSumPartition;

public class EqualSumPartition_TopDown {

    public static void main(String[] args) {

        int []arr= {2,2,3,4,5,6};
        int sum=11;
        int n=arr.length;
        boolean result = equalSumPartition(arr,sum,n);
        System.out.println(result);

    }

    private static boolean equalSumPartition(int[] arr, int sum, int n) {

        boolean [][]t = new boolean[n+1][sum+1];

        int totalSum=0;
        for (int i = 0; i < n; i++) {
            totalSum = totalSum + arr[i];
        }
        if(totalSum%2==0){
            return subsetSum(arr,sum,n,t);
        }else{
            return false;
        }

    }

    private static boolean subsetSum(int[] arr, int sum, int n, boolean[][] t) {

        // Base Condition
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(i==0){
                    t[i][j]=false;
                }if(j==0){
                    t[i][j]=true;
                }
            }
        }

        // Choice Diagram
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else if (arr[i-1]>j){
                    t[i][j]= t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}

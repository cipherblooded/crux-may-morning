package Dynamic_Programming.Type_1_ZeroOneKnapsack.HasSubsetSum;

public class HasSubsetSum_TopDown {

    public static void main(String[] args) {

        int []arr= {1,2,3,4,5,6};
        int sum=7;
        int n=arr.length;
        boolean [][]t =new boolean[n+1][sum+1];
        boolean result = subsetSum(arr,sum,n,t);
        System.out.println(result);

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

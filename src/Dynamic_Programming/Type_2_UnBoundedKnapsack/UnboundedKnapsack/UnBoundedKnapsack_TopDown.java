package Dynamic_Programming.Type_2_UnBoundedKnapsack.UnboundedKnapsack;

public class UnBoundedKnapsack_TopDown {
    public static void main(String[] args) {

        int []val={1, 2, 3, 4, 5, 6, 7};
        int []wt={3, 5, 1, 7, 11, 2, 6};
        int w=5,n=wt.length;

        int [][]t=new int[n+1][w+1];
        int result = unboundedknapsack(wt,val,w,n,t);
        System.out.println(result);

    }

    private static int unboundedknapsack(int[] wt, int[] val, int w, int n,int t[][]) {

        // Base Condition
        for (int i = 0; i < n+1 ; i++) {
            for (int j = 0; j < w+1; j++) {

                if(i==0||j==0){
                    t[i][j]=0;
                }

            }
        }

        // Choice Diagram
        for (int i = 1; i < n+1 ; i++) {
            for (int j = 1; j < w+1; j++) {

                if(wt[i-1]<=j){
                    t[i][j] = Math.max( val[i-1]+ t[i][j-wt[i-1]], t[i-1][j]);
                }else if(wt[i-1]>j){
                    t[i][j]=t[i-1][j];
                }

            }
        }
        return t[n][w];
    }
}

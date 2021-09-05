package Dynamic_Programming.Type_1_ZeroOneKnapsack.ZeroOneKnapsack;

public class ZeroOneKnapsack_TopDown {
    public static void main(String[] args) {

        int []val={2,3,4,5,6};
        int []wt={3,4,5,6,2};
        int w=6,n=wt.length;

        int [][]t =new int[n+1][w+1];
        int result = knapsack(wt,val,w,n,t);
        System.out.println(result);

    }

    private static int knapsack(int[] wt, int[] val, int w, int n,int [][]t) {

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
                    t[i][j] = Math.max( val[i-1]+ t[i-1][j-wt[i-1]], t[i-1][j]);
                }else if(wt[i-1]>j){
                    t[i][j]=t[i-1][j];
                }

            }
        }

        for (int i = 0; i < n+1; i++) {

            for (int j = 0; j < w+1; j++) {
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        return t[n][w];
    }
}

package Dynamic_Programming.Type_1_ZeroOneKnapsack.ZeroOneKnapsack;

public class ZeroOneKnapsack_Recursion {

    public static void main(String[] args) {

        int []val={1, 2, 3, 4, 5, 6, 7};
        int []wt={3, 5, 1, 7, 11, 2, 6};
        int w=5,n=wt.length;

        int result = knapsack(wt,val,w,n);
        System.out.println(result);

    }

    private static int knapsack(int[] wt, int[] val, int w, int n) {
        if (n==0||w==0){
            return 0;
        }
        if(wt[n-1]<=w){
            return Math.max(val[n-1]+
                            knapsack(wt,val,w-wt[n-1], n-1),
                    knapsack(wt,val,w, n-1));
        }else{
            return knapsack(wt,val,w, n-1);
        }
    }
}

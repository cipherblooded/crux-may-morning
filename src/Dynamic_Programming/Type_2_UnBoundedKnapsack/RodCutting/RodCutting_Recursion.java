package Dynamic_Programming.Type_2_UnBoundedKnapsack.RodCutting;

public class RodCutting_Recursion {

    public static void main(String[] args) {

        int []price = {1, 2, 3, 4, 5, 6, 7};
        int []len = {3, 5, 1, 7, 11, 2, 6};

        int w=7; // total length of the rod
        int n=len.length;

        int result = rodCutting(len,price,w,n);
        System.out.println(result);
    }

    private static int rodCutting(int[] len, int[] price, int w, int n) {
        if (n==0||w==0){
            return 0;
        }
        if(len[n-1]<=w){
            int selected = price[n-1]+ rodCutting(len, price,w-len[n-1], n);
            int rejected = rodCutting(len, price, w, n-1);
            return Math.max(selected, rejected);
        }else{
            return rodCutting(len, price, w, n-1);
        }
    }
}

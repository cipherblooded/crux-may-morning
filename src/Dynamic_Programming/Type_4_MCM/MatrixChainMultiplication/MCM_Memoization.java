package Dynamic_Programming.Type_4_MCM.MatrixChainMultiplication;

public class MCM_Memoization {

    public static int[][]t = new int[1001][1001];

    public static void main(String[] args) {

        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                t[i][j] = -1;
            }
        }

        int [] arr = {10, 20, 30, 40, 30};
        int cost = mcm(arr, 1 ,arr.length-1);
        System.out.println(cost);

    }

    public static int mcm(int[] arr, int i, int j){

        if(i==j){
            return 0;
        }

        if(t[i][j]!=-1){
            return t[i][j];
        }

        int minimumCost = Integer.MAX_VALUE;

        for (int k = i; k < j ; k++) {

            int tempCost = (arr[i-1] * arr[k] *arr[j]) +
                    mcm(arr, i, k) +
                    mcm(arr, k+1, j) ;

            if (tempCost < minimumCost){
                minimumCost = tempCost;
            }

        }

        t[i][j] = minimumCost;
        return t[i][j];
    }

}

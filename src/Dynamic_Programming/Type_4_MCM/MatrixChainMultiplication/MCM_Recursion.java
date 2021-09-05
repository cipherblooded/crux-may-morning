package Dynamic_Programming.Type_4_MCM.MatrixChainMultiplication;

public class MCM_Recursion {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 30};
        int cost = mcm(arr, 1, arr.length - 1);
        System.out.println(cost);

    }

    public static int mcm(int[] arr, int i, int j) {

        if (i == j) {
            return 0;
        }

        int minimumCost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            int tempCost = mcm(arr, i, k) +
                    mcm(arr, k + 1, j) +
                    (arr[i - 1] * arr[k] * arr[j]);

            if (tempCost < minimumCost) {
                minimumCost = tempCost;
            }
        }
        return minimumCost;
    }

}
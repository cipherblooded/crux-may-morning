package Dynamic_Programming.Type_3_LCS.LCSubsequence;

public class LCSubsequence_TopDown {

    public static void main(String[] args) {

        String x="ABCBDAB";
        String y="BDCABA";

        int m=x.length();
        int n=y.length();
        int t[][]=new int[m+1][n+1];
        int result = lCSubsequence(x, y, m, n, t);
        System.out.println(result);

    }


    private static int lCSubsequence(String x, String y, int m, int n, int [][]t) {

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(i==0||j==0){
                    t[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(x.charAt(i-1)==y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else {
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }
        return t[m][n];
    }
}

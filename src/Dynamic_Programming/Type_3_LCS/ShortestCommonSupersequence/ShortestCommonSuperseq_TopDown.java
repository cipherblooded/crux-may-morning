package Dynamic_Programming.Type_3_LCS.ShortestCommonSupersequence;

public class ShortestCommonSuperseq_TopDown {

    public static void main(String[] args) {

        String x="ABCDE";
        String y="ABXYZ";
        int m=x.length();
        int n=y.length();
        int t[][]=new int[m+1][n+1];
        int lcs = lcsubsequence(x, y, m, n, t);
        int result = (x.length()+y.length())-lcs;
        System.out.println(result);

    }

    private static int lcsubsequence(String x, String y, int m, int n, int [][]t) {

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                t[i][j]=0;
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

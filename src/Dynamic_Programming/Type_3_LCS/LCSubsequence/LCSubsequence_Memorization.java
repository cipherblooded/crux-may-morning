package Dynamic_Programming.Type_3_LCS.LCSubsequence;

public class LCSubsequence_Memorization {

    public static void main(String[] args) {

        String x="ATSCB";
        String y="VABZD";
        int m=x.length();
        int n=y.length();

        int [][]t = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j <n+1; j++) {
                t[i][j]=-1;
            }
        }

        int result = lCSubsequence(x, y, m, n, t);
        System.out.println(result);
    }

    private static int lCSubsequence(String x, String y, int m, int n, int [][]t) {

        if(m==0||n==0){
            return 0;
        }

        // Memorization
        if(t[m][n]!=-1){
            return t[m][n];
        }

        if(x.charAt(m-1)==y.charAt(n-1)){
            t[m][n] = 1+lCSubsequence(x, y, m-1, n-1, t);
            return t[m][n];
        }else {
            t[m][n] = Math.max(lCSubsequence(x, y, m, n-1, t),lCSubsequence(x, y, m-1, n, t));
            return t[m][n];
        }
    }

}

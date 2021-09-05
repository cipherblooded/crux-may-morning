package Dynamic_Programming.Type_3_LCS.ShortestCommonSupersequence;

// Printing LCS

public class ShortestCommonSuperseq_Printing {
    public static void main(String[] args) {

        String x="ABCDE";
        String y="ABXYZ";
        int m=x.length();
        int n=y.length();
        int t[][]=new int[m+1][n+1];
        String lcs = lcsubsequence(x, y, m, n, t);
        System.out.println(lcs);

    }

    private static String lcsubsequence(String x, String y, int m, int n, int [][]t) {

        int i = 0,j = 0;
        String lcs = "";

        for (i = 0; i < m+1; i++) {
            for (j = 0; j < n + 1; j++) {
                t[i][j]=0;
            }
        }
        for (i = 1; i < m+1; i++) {
            for (j = 1; j < n+1; j++) {
                if(x.charAt(i-1)==y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else {
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }

        i = m;
        j = n;

        while (i > 0 && j > 0){
            if(x.charAt(i-1)==y.charAt(j-1)){
                lcs=x.charAt(i-1)+lcs;
                i--;
                j--;
            }else {
                if(t[i][j-1]>t[i-1][j]){
                    lcs=y.charAt(j-1)+lcs;
                    j--;
                }else {
                    lcs=x.charAt(i-1)+lcs;
                    i--;
                }
            }
        }

        if (i>0){
            lcs = x.substring(0, i) + lcs;
            i = 0;
        }else {
            lcs = y.substring(0, j) + lcs;
            j = 0;
        }
        return lcs;
    }
}
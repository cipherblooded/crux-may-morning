package Dynamic_Programming.Type_3_LCS.LongestRepeatingSubseq;

public class LongestRepeatingSubseq_TopDown {

    public static void main(String[] args) {

        String x="AACBBGDD";
        String y=x;
        int m=x.length();
        int n=y.length();
        int t[][]=new int[m+1][n+1];
        int lcs_len = lcsubsequence(x, y, m, n, t);
        System.out.println(lcs_len);

    }

    private static int lcsubsequence(String x, String y, int m, int n, int [][]t) {

        int i,j=0;

        for (i = 0; i < m+1; i++) {
            for (j = 0; j < n + 1; j++) {
                t[i][j]=0;
            }
        }
        for (i = 1; i < m+1; i++) {
            for (j = 1; j < n+1; j++) {
                if(x.charAt(i-1)==y.charAt(j-1)&&i!=j){
                    t[i][j] = 1+t[i-1][j-1];
                }else {
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }

//        for (int i = 0; i < m+1; i++) {
//            for (int j = 0; j < n+1 ; j++) {
//                System.out.print(t[i][j]+" ");
//            }
//            System.out.println();
//        }

        i = m;
        j = n;

        String lcs="";

        while (i > 0 && j > 0){
            if(x.charAt(i-1)==y.charAt(j-1)&&i!=j){
                lcs=x.charAt(i-1)+lcs;
                i--;
                j--;
            }else {
                if(t[i][j-1]>t[i-1][j]){
                    j--;
                }else {
                    i--;
                }
            }
        }
        System.out.println(lcs);
        return t[m][n];

    }
}

package Dynamic_Programming.Type_3_LCS.Sequence_Pattern_Matching;

public class Sequence_Pattern_Matching_length {

    public static void main(String[] args) {

        String x="AB";
        String y="BDCABA";

        int m=x.length();
        int n=y.length();
        int t[][]=new int[m+1][n+1];

        int lcs_len = lcsubsequence(x, y, m, n, t);
        System.out.println(lcs_len);

        if(lcs_len==x.length()||lcs_len==y.length()){
            System.out.println("True");
        }else {
            System.out.println("False");
        }

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

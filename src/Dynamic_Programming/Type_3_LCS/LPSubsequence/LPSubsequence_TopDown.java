package Dynamic_Programming.Type_3_LCS.LPSubsequence;

public class LPSubsequence_TopDown {
    public static void main(String[] args) {

        String x="NITINMADAM";
        String y=reverse(x);
        int m=x.length();
        int n=y.length();
        int t[][]=new int[m+1][n+1];
        int result = lcsubsequence(x, y, m, n, t);
        System.out.println(result);

    }

    private static String reverse(String x) {

        String sum="";
        for (int i = x.length()-1; i >=0 ; i--) {
            sum = sum + x.charAt(i);
        }
//        System.out.println(sum);
        return sum;

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

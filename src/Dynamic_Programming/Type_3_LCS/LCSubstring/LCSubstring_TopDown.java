package Dynamic_Programming.Type_3_LCS.LCSubstring;

public class LCSubstring_TopDown {

    public static void main(String[] args) {

        String x="ABCDE";
        String y="ABXYE";

        int m=x.length();
        int n=y.length();
        int t[][]=new int[m+1][n+1];
        int result = lcsubstring(x, y, m, n, t);
        System.out.println(result);

    }

    private static int lcsubstring(String x, String y, int m, int n, int [][]t) {

        int curmax = 0;

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                t[i][j]=curmax;
            }
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(x.charAt(i-1)==y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                    curmax = Math.max(curmax, t[i][j]);
                }else {
                    t[i][j] = 0;
                }
            }
        }
        return curmax;
    }
}

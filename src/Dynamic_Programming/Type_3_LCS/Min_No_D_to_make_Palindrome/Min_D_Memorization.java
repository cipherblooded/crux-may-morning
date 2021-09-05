package Dynamic_Programming.Type_3_LCS.Min_No_D_to_make_Palindrome;

public class Min_D_Memorization {

    public static void main(String[] args) {

        String x="ARYAN";
        String y=reverse(x);
        int m=x.length();
        int n=y.length();

        int [][]t = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j <n+1; j++) {
                t[i][j]=-1;
            }
        }

        int lps = lcsubsequence(x, y, m, n, t);
        int no_of_deletions = x.length() - lps;
        System.out.println(no_of_deletions);

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
        if(m==0||n==0){
            return 0;
        }

        // Memorization
        if(t[m][n]!=-1){
            return t[m][n];
        }

        if(x.charAt(m-1)==y.charAt(n-1)){
            t[m][n] = 1+lcsubsequence(x, y, m-1, n-1, t);
            return t[m][n];
        }else {
            t[m][n] = Math.max(lcsubsequence(x, y, m, n-1, t),lcsubsequence(x, y, m-1, n, t));
            return t[m][n];
        }
    }

}

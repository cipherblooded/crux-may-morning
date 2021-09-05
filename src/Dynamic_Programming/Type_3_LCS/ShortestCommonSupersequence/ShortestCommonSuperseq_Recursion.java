package Dynamic_Programming.Type_3_LCS.ShortestCommonSupersequence;

public class ShortestCommonSuperseq_Recursion {

    public static void main(String[] args) {

        String x="ABCDE";
        String y="ABXYZ";
        int m=x.length();
        int n=y.length();
        int lcs = lcsubsequence(x, y, m, n);
        int result = (x.length()+y.length())-lcs;
        System.out.println(result);

    }
    private static int lcsubsequence(String x, String y, int m, int n) {

        if(m==0||n==0){
            return 0;
        }
        if(x.charAt(m-1)==y.charAt(n-1)){
            return 1+lcsubsequence(x, y, m-1, n-1);
        }else {
            return Math.max(lcsubsequence(x, y, m, n-1),lcsubsequence(x, y, m-1, n));
        }

    }
}

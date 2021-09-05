package Dynamic_Programming.Type_3_LCS.LCSubsequence;

public class LCSubsequence_Recursion {

    public static void main(String[] args) {

        String x="ABCDE";
        String y="ABXYZ";
        int m=x.length();
        int n=y.length();
        int result = lCSubsequence(x, y, m, n);
        System.out.println(result);

    }

    private static int lCSubsequence(String x, String y, int m, int n) {

        if(m==0||n==0){
            return 0;
        }
        if(x.charAt(m-1)==y.charAt(n-1)){
            int ans1 = 1 + lCSubsequence(x, y, m-1, n-1);
            return ans1;
        }else {
            int ans1 = lCSubsequence(x, y, m, n-1);
            int ans2 = lCSubsequence(x, y, m-1, n);
            return Math.max(ans1,ans2);
        }

    }

}

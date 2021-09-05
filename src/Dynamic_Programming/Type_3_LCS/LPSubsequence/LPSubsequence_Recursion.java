package Dynamic_Programming.Type_3_LCS.LPSubsequence;

public class LPSubsequence_Recursion {

    public static void main(String[] args) {

        String x="aryan";
        String y= reverse(x);
        int m=x.length();
        int n=y.length();
        int result = lcsubsequence(x, y, m, n);
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

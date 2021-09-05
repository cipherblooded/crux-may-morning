package Dynamic_Programming.Type_3_LCS.I_D_from_String_a_to_b;

// No of insertions and deletions requires to Convert a string from a to b

public class I_D_a_to_b_Recursion {

    public static void main(String[] args) {

        String x="ABCDE";
        String y="ABXYZ";
        int m=x.length();
        int n=y.length();

        int lcs = lcsubsequence(x, y, m, n);

        int deletions = x.length() - lcs;
        int insertions = y.length() - lcs;
        System.out.println("No of deletions "+ deletions);
        System.out.println("No of insertions "+ insertions);

    }
    private static int lcsubsequence(String x, String y, int m, int n) {

        if(m==0||n==0){
            return 0;
        }
        if(x.charAt(m-1)==y.charAt(n-1)){
            int ans1 = 1 + lcsubsequence(x, y, m-1, n-1);
            return ans1;
        }else {
            int ans2 = lcsubsequence(x, y, m, n-1);
            int ans3 = lcsubsequence(x, y, m-1, n);
            return Math.max(ans2,ans3);
        }

    }
}

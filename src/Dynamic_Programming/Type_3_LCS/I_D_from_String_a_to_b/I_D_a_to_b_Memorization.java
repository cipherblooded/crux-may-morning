package Dynamic_Programming.Type_3_LCS.I_D_from_String_a_to_b;

// No of insertions and deletions requires to Convert a string from a to b

public class I_D_a_to_b_Memorization {

    public static void main(String[] args) {

        String x="ABCDE";
        String y="ABXYZ";
        int m=x.length();
        int n=y.length();

        int [][]t=new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j <n+1; j++) {
                t[i][j]=-1;
            }
        }

        int lcs = lcsubsequence(x, y, m, n, t);

        int deletions = x.length() - lcs;
        int insertions = y.length() - lcs;
        System.out.println("No of deletions "+ deletions);
        System.out.println("No of insertions "+ insertions);

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

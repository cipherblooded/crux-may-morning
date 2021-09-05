package Dynamic_Programming.Type_4_MCM.PalindromePartitioning;

public class PalindromePartitioning_Optimised {

    public static int[][]t = new int[1001][1001];

    public static void main(String[] args) {

        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                t[i][j] = -1;
            }
        }

        String s = "ababbbabbababa";
        int partition = palindromePartitioning(s,0, s.length()-1);
        System.out.println(partition);

    }

    public static int palindromePartitioning(String s, int i, int j){

        if(i==j){
            return 0;
        }

        if(isPalindrome(s, i, j)){
            return 0;
        }

        if (t[i][j]!=-1){
            return t[i][j];
        }

        int minimumCost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            int left, right;

            if(t[i][k] != -1){
                left = t[i][k];
            }else{
                left = palindromePartitioning(s, i, k);
                t[i][k] = left;
            }

            if(t[k+1][j] != -1){
                right = t[k+1][j];
            }else{
                right = palindromePartitioning(s, k+1, j);
                t[k+1][j] = right;
            }

            int tempCost = 1 + left + right;

            if (tempCost < minimumCost){
                minimumCost = tempCost;
            }

        }

        t[i][j] = minimumCost;
        return t[i][j];

    }

    private static boolean isPalindrome(String s, int i, int j) {

        if(i < j){
            while (i < j){
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }else {
                    i++;
                    j--;
                }
            }
            return true;
        }else {
            return false;
        }

    }

}

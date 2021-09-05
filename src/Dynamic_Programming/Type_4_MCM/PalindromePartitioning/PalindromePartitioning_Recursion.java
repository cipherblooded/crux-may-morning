package Dynamic_Programming.Type_4_MCM.PalindromePartitioning;

public class PalindromePartitioning_Recursion {

    public static void main(String[] args) {

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

        int minimumCost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            int tempCost = 1 +
                    palindromePartitioning(s, i, k) +
                    palindromePartitioning(s, k+1, j);

            if (tempCost < minimumCost){
                minimumCost = tempCost;
            }

        }

        return minimumCost;
    }

    private static boolean isPalindrome(String s, int i, int j) {

        if (i < j){
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

package Dynamic_Programming.Type_6_Dice;

public class DiceDP {

    public static void main (String[] args) {
        System.out.println(findWays(1, 4, 2));
        System.out.println(findWays(3,2, 2));
        System.out.println(findWays(8,6, 3));
        System.out.println(findWays(5,4, 2));
        System.out.println(findWays(5,4, 3));
    }

// Java program to find number of ways to get sum 'target' with 'dices'
// dice where every dice has 'faces' faces
// /* The main function that returns the number of ways to get sum 'target' with 'dices' dice and 'faces' with faces faces. */

    public static long findWays(int target, int faces, int dices){

    /* Create a table to store the results of subproblems.
    One extra row and column are used for simplicity
    (Number of dice is directly used as row index and sum is directly used as column index).
    The entries in 0th row and 0th column are never used. */

        long[][] table = new long[dices+1][target+1];

        /* Table entries for only one dice */
        for(int j = 1; j <= faces && j <= target; j++) {
            table[1][j] = 1;
        }

    /* Fill rest of the entries in table using recursive relation
    i: number of dice, j: sum */
        for(int i = 2; i <= dices;i++){
            for(int j = 1; j <= target; j++){
                for(int k = 1; k < j && k <= faces; k++){
                    table[i][j] += table[i - 1][j - k];
                }
            }
        }

        /* Uncomment these lines to see content of table
        for(int i = 0; i< dices+1; i++){
            for(int j = 0; j< target+1; j++)
                System.out.print(dt[i][j] + " ");
            System.out.println();
        } */

        return table[dices][target];
    }

}


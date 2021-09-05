package DS_Notes.Lecture_5;

import java.util.Arrays;
import java.util.Scanner;
public class ObjectArray {

    public static void main(String[] args) {

        //      Integer[] nums = new Integer[10];
        int[][] nums = new int[4][5];
        System.out.println("no of rows : "+nums.length);
        System.out.println("no of columns : "+nums[0].length);

        Scanner s = new Scanner(System.in);

        System.out.println(" please enter 20 elements in the array ");
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums[i].length; j++) {

                nums[i][j] = s.nextInt();

            }

        }

        System.out.println(Arrays.toString(nums));

    }

}

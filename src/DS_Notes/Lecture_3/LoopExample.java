package DS_Notes.Lecture_3;
import java.util.Scanner;

public class LoopExample {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int row = 0;

        while (row < n) {

            int col = 0;

            while (col < n) {

                System.out.print("* ");
                col = col + 1;
            }
            System.out.println();
            row = row + 1;
        }
    }
}

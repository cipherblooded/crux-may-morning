package Recursion;

import java.util.ArrayList;

public class Dice {

    public static void main(String[] args) {

        dice(5,3,"");
        System.out.println();
        System.out.println("Total Ways Count " + diceCount(5,3,"",0 ));
        System.out.println("Total Ways Combination" + diceList(5,3, new ArrayList<String>(),"" ));

    }

    public static void dice(int target, int faces, String processed){
        if (target == 0){
            System.out.print(processed+" ");
            return;
        }

        for (int i = 1; i <= faces && i <= target ; i++) {
            dice(target - i, faces, processed + i);
        }
    }

    public static int diceCount(int target, int faces,String processed , int count){
        if (target == 0){
            count++;
            return count;
        }

        for (int i = 1; i <= faces && i <= target ; i++) {
            count = diceCount(target - i, faces, processed + i, count);
        }
        return count;
    }

    public static ArrayList<String> diceList(int target, int faces, ArrayList<String> list, String processed){
        if (target == 0){
            list.add(processed);
            return list;
        }

        for (int i = 1; i <= faces && i <= target ; i++) {
            list = diceList(target - i, faces, list, processed + i);
        }
        return list;
    }

}

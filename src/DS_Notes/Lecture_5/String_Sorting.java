package DS_Notes.Lecture_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class String_Sorting {


    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        ArrayList<String> nums=new ArrayList<>();

        nums.add("harsh");
        nums.add("amit");
        nums.add("atal");
        nums.add("aryan");

//        selection(nums);
//        System.out.println("Selection Sort : "+nums.toString());

        bubble(nums);
        System.out.println("Bubble Sort : "+nums.toString());

    }

    public static void selection(ArrayList<String> nums){

        for (int i = 0; i < nums.size(); i++) {

            int end = nums.size() - i - 1;

            int max = maxIndexRange(nums, 0, end);

            if (nums.get(max).compareTo(nums.get(end))>=0){

                swap(nums, max, end);
            }

        }

    }

    public static int maxIndexRange(ArrayList<String> nums, int start, int end){

        int max = start;

        for (int i = start; i <= end; i++) {


            if (nums.get(max).compareTo(nums.get(i))>0){
                max = i;
            }

        }
        return max;

    }

    public static void swap(ArrayList<String> nums, int first, int second){

        Collections.swap(nums, first, second);
    }


    public static void bubble(ArrayList<String> nums){

        for (int i = 0; i < nums.size(); i++) {

            for (int j = 0; j < nums.size() - i - 1; j++) {

                if (nums.get(j).compareTo(nums.get(j+1))>=0){

                    swap(nums, j, j+1);

                }

            }

        }
    }


}



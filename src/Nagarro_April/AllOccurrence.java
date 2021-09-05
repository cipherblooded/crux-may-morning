package Nagarro_April;

import java.util.Arrays;

public class AllOccurrence {
    public static void main(String[] args) {

        int []arr = {10,30,40,10,60,10};
        int []index = allOccurrence(arr,10,0, 0);
        System.out.println(Arrays.toString(index));
    }

    private static int[] allOccurrence(int[] arr, int element, int i, int count) {
        if(i==arr.length){
            int [] index = new int[count];
            return index;
        }
        if(arr[i]==element){
            int[] index = allOccurrence(arr,element,i+1,count+1);
            index[count]=i;
            return index;
        }else {
            int[] index =  allOccurrence(arr,element,i+1,count);
            return index;
        }
    }
}

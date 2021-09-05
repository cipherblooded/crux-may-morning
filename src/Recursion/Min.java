package Recursion;

public class Min {
    public static void main(String[] args) {
        int [] arr = {5,6,1,2,8,4,3};
        System.out.println(min1(arr,0));
        System.out.println(min2(arr,0,Integer.MAX_VALUE));
    }

    private static int min1(int[] arr, int i) {
        if(i==arr.length-1){
            return arr[i];
        }
        int min = min1(arr,i+1);
        return Math.min(min,arr[i]);
    }

    private static int min2(int[] arr, int i, int minValue) {
        if(i==arr.length){
            return minValue;
        }
        minValue = Math.min(arr[i],minValue);
        return min2(arr,i+1,minValue);
    }
}

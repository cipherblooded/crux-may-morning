package Recursion;

public class Max {
    public static void main(String[] args) {
        int [] arr = {5,6,1,2,8,4,3};
        System.out.println(max1(arr,0));
        System.out.println(max2(arr,0,Integer.MIN_VALUE));
    }

    private static int max1(int[] arr, int i) {
        if(i==arr.length-1){
            return arr[i];
        }
        int max = max1(arr,i+1);
        return Math.max(max,arr[i]);
    }

    private static int max2(int[] arr, int i, int maxValue) {
        if(i==arr.length){
            return maxValue;
        }
        maxValue = Math.max(arr[i],maxValue);
        return max2(arr,i+1,maxValue);
    }
}

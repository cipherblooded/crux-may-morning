package Shikha_Bhopal;

public class BinarySearch {
    public static void main(String[] args) {

        int []arr = {1,2,3,4,6,7,8,9,10,12};
        int target = 5;
        int index = binarySearch(arr, target);
        System.out.println("index : "+index);
        System.out.println(arr[index]);
        System.out.println("-----------------------------");
        int index2 = newbinarySearch(arr, target);
        System.out.println("index : "+index2);
        System.out.println(arr[index2]);

    }

    private static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length-1;

        while (start<=end){
            int mid = start + (end-start)/2; // (2s + end -start )/2
            if(target>arr[mid]){
                start = mid+1;
            }else if (target<arr[mid]){
                end = mid-1;
            }else {
                return mid;
            }
        }
        return start;
    }

    private static int newbinarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length-1;

        while (start<=end){

            int mid = start + (end-start)/2; // ( 2start + end -start )/2
            if(target>arr[mid]){
                start = mid+1;
            }else if(target<arr[mid]) {
                end = mid-1;
            }else {
                return mid;
            }
        }
        return end;
    }

}

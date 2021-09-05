package RitikRec;

public class PrintArr {
    public static void main(String[] args) {
        int []arr = {1,2,3};
        printArr(arr, 0);
    }

    private static void printArr(int[] arr, int index) {

        if(index==arr.length){
            return;
        }
        System.out.println(arr[index]);
        printArr(arr, index+1);
        System.out.println("return : "+ arr[index]);

    }
}

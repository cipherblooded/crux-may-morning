package RitikRec;

public class SubseqOrCombination {
    
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        subSeqOrCombination(arr, 0, "");
    }

    private static void subSeqOrCombination(int[] arr, int index, String ans) {

        if(index==arr.length){
            System.out.println(ans);
            return;
        }
        // new are asking question to the element
        subSeqOrCombination(arr, index+1, ans); // mai ni aauga
        subSeqOrCombination(arr, index+1, ans+arr[index]); // mai aauga


    }
}

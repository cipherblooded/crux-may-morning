import java.util.Arrays;

public class RepeatedMissingElement {
    public static void main(String[] args) {

        int [] arr= {4,2,3,1,4};// 1,2,3,4,5
        int repeatedElement=-1;

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];

            if(arr[Math.abs(index)-1]<0){
                repeatedElement = index;
            }else {
                arr[Math.abs(index)-1] = -1*arr[Math.abs(index)-1];
            }
        }
        System.out.println(repeatedElement);
        System.out.println(Arrays.toString(arr));

    }
}

package Nagarro_April;

import java.util.Arrays;
import java.util.Stack;

public class ngr {
    public static void main(String[] args) {

        int []arr = {1,5,2,4,3,7};// {5,7,4,7,7,-1}
        Stack <Integer> stack = new Stack<>();
        int []brr = new int[arr.length];
        int pos=arr.length;

        for (int i = arr.length-1 ; i >=0 ; i--) {
            if (stack.empty()){
                brr[--pos]=-1;
            }else {
                if(arr[i]<stack.peek()){
                    brr[--pos] = stack.peek();
                }else {
                    while (!stack.empty()&&arr[i]>=stack.peek()){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        brr[--pos]=-1;
                    }else {
                        brr[--pos] = stack.peek();
                    }
                }
            }
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(brr));
    }

}

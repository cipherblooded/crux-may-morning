package Nagarro_April;

import java.util.HashSet;

public class optimal_factorial {

    public static void main(String[] args) {

        int n = 20;
        int div = 2;

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(n);


        while((div*div)<=n){
            if(n%div==0){
                hashSet.add(div);
                hashSet.add(n/div);
            }
            div++;
        }

        System.out.println(hashSet);
    }

}

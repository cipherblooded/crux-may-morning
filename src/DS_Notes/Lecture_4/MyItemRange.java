package DS_Notes.Lecture_4;

import java.util.Scanner;

public class MyItemRange {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // in order to increse the range of a data type then at last of the number we have to mention "l" in case of long and
        // "f" in case of float value
        int a= 654321;
        long b=987654321234567898l;

        //Implicit conversion
        float a1=a;
        float b1=b;
        double c1=a;
        double d1=b;
        System.out.println(" value of int in terms of float "+a1);
        System.out.println(" value of long in terms of float "+b1);
        System.out.println(" value of long in terms of double "+c1);
        System.out.println(" value of long in terms of double "+b1);

        //Explicit conversion
        a=(int)a1;
        b=(long)b1;
        int c=(int)c1;
        long d=(long)d1;

        System.out.println(" value of float in terms of int "+a);
        System.out.println(" value of float in terms of long "+b);
        System.out.println(" value of double in terms of int "+c);
        System.out.println(" value of double in terms of long "+d);

    }
}

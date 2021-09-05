import java.util.Scanner;

public class crux {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n=123456;
        int r= 5;
        int div =(int)Math.pow(10,r);
        System.out.println(n);
        System.out.println(div);

        System.out.println(n%div+""+(n/div));



//        System.out.println("1");
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j <= i; j++) {
//
//                if(j==1||j==i){
//                    System.out.print(i-1);
//                }else {
//
//                    System.out.print("0");
//                }
//
//            }
//            System.out.println();
//        }

    }
}

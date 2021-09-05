package Nagarro_April;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class temp {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String no = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < no.length(); i++) {
            if(no.charAt(i)=='0'){
                stringBuilder.append('5');
            }else {
                stringBuilder.append(no.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());

    }
}

package DS_Notes.Lecture_6;

public class BuilderExample {

    public static void main(String[] args) {

        String sample = "a";
        StringBuilder builder = new StringBuilder("a");

        long t1=System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {

            builder.append("a");

        }
        long t2=System.currentTimeMillis();

        System.out.println("Time taken by string builder : "+(t2-t1));

        for (int i = 0; i < 10000; i++) {

            sample=sample+'a';

        }
        t1=System.currentTimeMillis();

        System.out.println("Time taken by string buffer  : "+(t1-t2));

    }

}
package DS_Notes.Lecture_12;

public class Permutation {
    public static void main(String[] args) {

//        System.out.println("a".substring(1, 1));
        permuteascending("","abcd");
        System.out.println();
//        permutedescending("", "abcd");
    }

    //ascending order

    public static void permuteascending(String processed, String unprocessed){
        if (unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        for (int i = 0; i < unprocessed.length(); i++) {
            char ch = unprocessed.charAt(i);
            String first = unprocessed.substring(0, i);
            String second = unprocessed.substring(i+1);

            permuteascending(processed + ch, first + second);
        }
    }

    // descending order

    public static void permutedescending(String processed, String unprocessed){
        if (unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }


        char ch = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);

        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i);

            permutedescending(first + ch + second, unprocessed);
        }
    }

}

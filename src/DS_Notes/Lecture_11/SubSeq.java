package DS_Notes.Lecture_11;

public class SubSeq {
    public static void main(String[] args) {
        subseq("", "ab");
    }

    public static void subseq(String processed, String unprocessed){
        if (unprocessed.isEmpty()){
            if (!processed.isEmpty()) {
                System.out.println(processed);
            }
            return;
        }

        char ch = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);

        subseq(processed + ch, unprocessed);
        subseq(processed, unprocessed);

    }
}

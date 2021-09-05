package DS_Notes.Lecture_4;

public class BlockScope {

    public static void main(String[] args) {

        int outer = 44;
        {
            int inner = 7;
            {
                {
                    {
                        System.out.println(inner);
                    }
                }
            }
        }


        for (int i = 0; i < 10; i++) {

        }

        for (int i = 0; i < 10; i++) {

        }
    }
}

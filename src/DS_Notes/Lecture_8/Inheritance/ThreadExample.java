package DS_Notes.Lecture_8.Inheritance;

public class ThreadExample extends Thread {



    @Override

    public void run() {

        for (int i = 0; i < 5; i++) {

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            System.out.println("printing " + i);

        }

    }

}

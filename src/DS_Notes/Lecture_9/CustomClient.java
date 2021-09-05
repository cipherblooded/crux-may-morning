package DS_Notes.Lecture_9;

import DS_Notes.Lecture_7.oop.Human;



public class CustomClient {

    public static void main(String[] args) {

        Vehicle c = new Vehicle() {

            @Override

            public void pollution() {



            }

        };

        Human h = new Human();

    }

}
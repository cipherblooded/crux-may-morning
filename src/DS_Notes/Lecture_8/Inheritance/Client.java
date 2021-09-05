package DS_Notes.Lecture_8.Inheritance;

public class Client {

    public static void main(String[] args) {

        WonderCar c = new WonderCar();
        WonderCar.bakwas();
        WonderCar wonder  = new WonderCar();

        System.out.println(wonder.door);
        System.out.println(wonder.wheels);

        wonder.start();
        wonder.stop();
        wonder.fly();

        Car generic  = new WonderCar();

        System.out.println(generic.door);
        System.out.println(generic.wheels);

        generic.start();
        generic.stop();

        System.out.println(wonder.door);
        System.out.println(generic.door);
        System.out.println(wonder.wings);

        //        Car mycar = new Car();
        //        WonderCar wonder = (WonderCar) mycar;
        //        wonder.start();

    }

}

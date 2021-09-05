package DS_Notes.Lecture_5;
// Java program to demonstrate Autoboxing

import java.util.ArrayList;
class Dynamic_Array_Decleration
{
    public static void main(String[] args)
    {
        ArrayList<Byte> bytearr = new ArrayList<Byte>();
        ArrayList<Integer> intarr = new ArrayList<Integer>();//intarr stores only objects of integer datatype
        ArrayList<Long> longarr = new ArrayList<Long>();
        ArrayList<Float> floatarr = new ArrayList<Float>();
        ArrayList<Double> doublearr = new ArrayList<Double>();//anyarr stores only objects of any type of datatype
        ArrayList<Character> chararr = new ArrayList<Character>();
        ArrayList<Boolean> Booleanarr = new ArrayList<Boolean>();
        ArrayList anyarr = new ArrayList();
        ArrayList<String> str=new ArrayList<>();

        // Autoboxing

        bytearr.add((byte)1);
        bytearr.add((byte)2);
        bytearr.add((byte)3);

        intarr.add(4);
        intarr.add(5);
        intarr.add(6);

        longarr.add(7l);
        longarr.add(8l);
        longarr.add(9l);

        floatarr.add(10f);
        floatarr.add(11f);
        floatarr.add(12f);

        doublearr.add(13.0);
        doublearr.add(14.0);
        doublearr.add(15.0);

        chararr.add('a');
        chararr.add('b');
        chararr.add('c');

        Booleanarr.add(true);
        Booleanarr.add(false);

        anyarr.add(25);
        anyarr.add(30.0);
        anyarr.add("Aryan");

        // printing the values from object

        System.out.println(bytearr.get(0));
        System.out.println(bytearr.get(1));
        System.out.println(bytearr.get(2));

        System.out.println(intarr.get(0));
        System.out.println(intarr.get(1));
        System.out.println(intarr.get(2));

        System.out.println();

        System.out.println(longarr.get(0));
        System.out.println(longarr.get(1));
        System.out.println(longarr.get(2));

        System.out.println();

        System.out.println(floatarr.get(0));
        System.out.println(floatarr.get(1));
        System.out.println(floatarr.get(2));

        System.out.println();

        System.out.println(doublearr.get(0));
        System.out.println(doublearr.get(1));
        System.out.println(doublearr.get(2));

        System.out.println();

        System.out.println(chararr.get(0));
        System.out.println(chararr.get(1));
        System.out.println(chararr.get(2));

        System.out.println();

        System.out.println(Booleanarr.get(0));
        System.out.println(Booleanarr.get(1));

        System.out.println();

        System.out.println(anyarr.get(0));
        System.out.println(anyarr.get(1));
        System.out.println(anyarr.get(2));

    }
}
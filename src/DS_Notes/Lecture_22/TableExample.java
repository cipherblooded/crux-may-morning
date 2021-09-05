package DS_Notes.Lecture_22;

public class TableExample {
    public static void main(String[] args) {
//        TableWithLL<String, String> dict = new TableWithLL<>();
//        dict.put("apple", "a sweet red fruit");
//        dict.put("mango", "king of fruits");
//
////        System.out.println(dict.get("mango"));
////
////        dict.put("mango", "dashari aam");
////
////        System.out.println(dict.get("grapes"));
////
////        dict.remove("apple");
////        System.out.println(dict.get("mango"));
//
//        dict.remove("apple");
//
//        System.out.println(dict.get("apple"));

//        System.out.println("om".hashCode());

        CombinedHashTable<Integer, Integer> table = new CombinedHashTable<>();

        for (int i = 0; i < 1000000; i++) {
            table.put(i, i);
        }

    }

}

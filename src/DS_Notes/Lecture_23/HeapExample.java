package DS_Notes.Lecture_23;

public class HeapExample {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>();

        for (int i = 0; i < 20; i++) {
            int random = (int)(Math.random() * 10);
            heap.add(random);
        }

        while (!heap.isEmpty()){
            System.out.println(heap.remove());
        }
    }
}
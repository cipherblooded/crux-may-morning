package DS_Notes.Lecture_25;

public class Client {
    public static void main(String[] args) {
        AdjMapGraph<Character> graph = new AdjMapGraph<>();

        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');

        graph.addEdge('a', 'e', 1);
        graph.addEdge('a', 'b', 2);
        graph.addEdge('a', 'd', 3);
        graph.addEdge('e', 'd', 4);
        graph.addEdge('b', 'c', 5);
        graph.addEdge('e', 'c', 7);

        AdjMapGraph<Character> spanning = graph.minSpanningTreeGraph();

        graph.display();
        System.out.println("--------------");
        spanning.display();
    }
}

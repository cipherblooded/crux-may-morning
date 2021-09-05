package Shikha_Bhopal;

public class LL {

    public static void main(String[] args) {
        Node head = null;
        Node temp = null;

        for (int i = 0; i < 5; i++) {
            Node node = new Node(i);
            if(i==0){
                head = node;
                temp = node;
            }else {
                temp.next = node;
                temp = temp.next;
            }
        }

        temp = head;
        for (int i = 0; i < 5; i++) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        System.out.println("_______________________");

        int t = 2;
        temp = head;

        for (int i = 0; i < t-1; i++) {
            temp = temp.next;
        }

        Node temp1 = temp;

        Node temp3 = new Node(10);

        temp3.next = temp1.next;
        temp.next = temp3;

        temp = head;

        for (int i = 0; i < 6; i++) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}



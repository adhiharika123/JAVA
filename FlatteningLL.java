
import java.util.*;

public class FlatteningLL {
    public static void main(String[] args) {
        // Create a linked list with child pointers
        Node head = new Node(3);

        head.next = new Node(2);
        head.next.child = new Node(10);

        head.next.next = new Node(1);
        head.next.next.child = new Node(7);
        head.next.next.child.child = new Node(11);
        head.next.next.child.child.child = new Node(12);

        head.next.next.next = new Node(4);
        head.next.next.next.child = new Node(9);

        head.next.next.next.next = new Node(5);
        head.next.next.next.next.child = new Node(6);
        head.next.next.next.next.child.child = new Node(8);
        
        Node flattened = flattenLinkedList(head);
        System.out.println("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
    public static Node convertArrToLinkedList(ArrayList<Integer> arr) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        for (int i = 0; i < arr.size(); i++) {            
            temp.child = new Node(arr.get(i));
            temp = temp.child;
        }
        return dummyNode.child;
    }

    // Function to flatten a linked list with child pointers
    public static Node flattenLinkedList(Node head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            Node t2 = head;
            while (t2 != null) {
                arr.add(t2.data);
                t2 = t2.child;
            }
            head = head.next;
        }
        Collections.sort(arr);
        return convertArrToLinkedList(arr);
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            if(head.child != null){
                System.out.print(head.data + " -> ");
            }
            else{
                System.out.print(head.data);
            }
            head = head.child;
        }
        System.out.println();
    }
}

class Node{
    int data;
    Node next;
    Node child;

    Node(int data1, Node next1, Node child1){
        data = data1;
        next = next1;
        child = child1;
    }
    Node(int data1){
        data = data1;
        next = null;
        child = null;
    }
}
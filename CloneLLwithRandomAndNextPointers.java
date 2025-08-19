import java.util.*;
public class CloneLLwithRandomAndNextPointers{
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        //Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List with Random Pointers:");
        printLL(head);

        
        Node clonedList = copyRandomList(head);

        System.out.println("\nCloned Linked List with Random Pointers:");
        printLL(clonedList);
    }
    public static Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.data));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data);
            if(head.random != null){
                System.out.print(", " + head.random.data);
            }
            else{
                System.out.print("nullptr");
            }
            System.out.println();
            head = head.next;
        }
    }
}

class Node{
    int data;
    Node next;
    Node random;

    Node(int data1, Node next1, Node random1){
        data = data1;
        next = next1;
        random = random1;
    }
    Node(int data1){
        data = data1;
        next = null;
        random = null;
    }
}


import java.util.*;

public class InsertAtEndDoublyLL{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to insert");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements to insert :");
        Node head = null;
        Node tail = null;

        for(int i = 0 ; i < n; i++){
            int value = sc.nextInt();
            Node newNode = new Node(value);
            if(head == null){
                head = tail = newNode;
            }
            else{
                tail.next = newNode;
                newNode.prev = tail;
                tail = tail.next;
            }
        }

        System.out.println("Enter the value to be inserted at end :");
        int value = sc.nextInt();

        head = insertAtEnd(head, value);
        System.out.println("Updated LinkedList is : ");
        printLL(head);              
    }
    public static Node insertAtEnd(Node head,int val){
        Node newNode = new Node(val);
        if(head == null){
            return newNode;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
  

class Node{
    public int data;
    public Node next;
    public Node prev;

    Node(int data1, Node next1, Node prev1){
        data = data1;
        next = next1;
        prev = prev1;
    }

    Node(int data1){
        data = data1;
        next = null;
        prev = null;
    }
}
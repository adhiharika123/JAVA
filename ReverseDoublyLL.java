import java.util.*;

public class ReverseDoublyLL {
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

        head = reverseLL(head);
        System.out.println("Reversed LinkedList is : ");
        printLL(head);              
    }

    //Brute Force Appraoch - Using Two Traversals (Stack - Last In Last out [LIFO] )
    public static Node reverseLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }


    //Optimal Approch - Using Single Traversal

    /*
    public static Node reverseLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node back = null;
        Node curr = head;

        while(curr != null)
        {
            back = curr.prev;   //To store Prev Value
            curr.prev = curr.next;  //To swap Next To Prev
            curr.next = back;   //To swap Prev to Next
            curr = curr.prev;   //Move to next
        }
        return back.prev;   //To make last node as head
    }
     */

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

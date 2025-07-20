package LinkedLists;
import java.util.*;
public class DeleteAtTail {
        public static void main(String[] args){
        //User Input 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to insert : ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements : ");
        Node head = null, tail = null;
        for(int i = 0 ; i < n ; i++){
            int value = sc.nextInt();
            Node newnode = new Node(value);
            if(head == null){
                head = tail = newnode;
            }
            else{
                tail.next = newnode;
                tail = tail.next;
            }
        }

        head = deleteattail(head);

        System.out.println("Updated Linked List is :");
        printLL(head);

    }

    //Insert at Begin
    public static Node deleteattail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.println(head.data + " ");
            head = head.next;
        }
    }
}

class Node{
    public int data;
    public Node next;

    public Node(int data1, Node next1){
        data = data1;
        next = next1;
    }
    public Node(int data1){
        data = data1;
        next = null;
    }
}

//To compile : javac LinkedLists/DeleteAtTail.java
//To run : java LinkedLists/DeleteAtTail


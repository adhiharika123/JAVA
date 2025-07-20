package LinkedLists;
import java.util.Scanner;

public class InsertAtEnd{
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

        System.out.println("Enter the value to insert at end: ");
        int val = sc.nextInt();

        head = insertatend(head, val);

        System.out.println("Updated Linked List is :");
        printLL(head);

    }

    //Insert at End
    public static Node insertatend(Node head, int val){
        Node newnode = new Node(val, head);
        if(head == null){
            head = newnode;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.next = null;
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

//To compile : javac LinkedLists/InsertAtEnd.java
//To run : java LinkedLists/InsertAtEnd
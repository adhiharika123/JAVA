package LinkedLists;
import java.util.Scanner;

public class InsertAtTheHead{
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

        System.out.println("Enter the value to insert at head: ");
        int val = sc.nextInt();

        head = insertatbegin(head, val);

        System.out.println("Updated Linked List is :");
        printLL(head);

    }

    //Insert at Begin
    public static Node insertatbegin(Node head, int val){
        Node temp = new Node(val, head);
        return temp;
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

//To compile : javac LinkedLists/InsertAtTheHead.java
//To run : java LinkedLists/InsertAtTheHead
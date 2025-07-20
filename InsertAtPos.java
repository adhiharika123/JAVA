package LinkedLists;
import java.util.*;

public class InsertAtPos {
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

        System.out.println("Enter the position: ");
        int pos = sc.nextInt();
        System.out.println("Enter the value to insert at pos: ");
        int val = sc.nextInt();

        head = insertatpos(head, val, pos);

        System.out.println("Updated Linked List is :");
        printLL(head);

    }
    //Insert at Position
    public static Node insertatpos(Node head, int val, int pos){
        Node newnode = new Node(val);
        if(pos < 1){
            return head;
        }
        if(pos == 1){
            newnode.next = head;
            return newnode;
        }
        Node temp = head;
        for(int i = 0 ; i < pos - 1 ; i++){
            if(temp == null){
                break;
            } 
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.println(head.data + " ");
            head = head.next;
        }
    }
}

//To compile : javac LinkedLists/InsertAtPos
//To run : java LinkedLists/DeleteAtPos
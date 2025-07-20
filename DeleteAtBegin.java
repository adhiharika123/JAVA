package LinkedLists;
import java.util.*;

public class DeleteAtBegin {
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

        head = deleteatbegin(head);

        System.out.println("Updated Linked List is :");
        printLL(head);

    }
    //Delete at Begin
    public static Node deleteatbegin(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        head = temp.next;
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.println(head.data + " ");
            head = head.next;
        }
    }
}



//To compile : javac LinkedLists/DeleteAtBegin.java
//To run : java LinkedLists/DeleteAtBegin


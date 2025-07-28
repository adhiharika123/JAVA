/*Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input. */

import java.util.*;

public class SegregateEvenOddIndexes {
    public static void main(String args[]){
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
        Node newHead = oddEvenList(head);    
        System.out.println("The Odd and Even of LinkedList is : ");
        printLL(newHead);
    }

    public static Node oddEvenList(Node head) {
        Node evenHead = new Node(-1), evenTail = evenHead;
        Node oddHead = new Node(-1), oddTail = oddHead;
        Node curr = head;
        Node temp;
        int index = 1;  //Segregate through node positions
        while(curr != null){
            //Seperating each Node First
            temp = curr;
            curr = curr.next;
            temp.next = null;

            //Even Position Numbers are in one list
            if(index % 2 == 0){
                evenTail.next = temp;
                evenTail = temp;
            }
            //Odd Position Numbers are in one list
            else{
                oddTail.next = temp;
                oddTail = temp;
            }  
            index++;         
        }
        oddTail.next = evenHead.next;       //Adding Even Indices to Odd Indices
        return oddHead.next;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

class Node{
    int data;
    Node next;

    Node(int data1, Node next1){
        data = data1;
        next = next1;
    }
    Node(int data1){
        data = data1;
        next = null;
    }
}
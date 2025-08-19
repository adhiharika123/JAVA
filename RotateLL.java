import java.util.*;
public class RotateLL{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements : ");
        Node head = null;
        Node tail = null;
        for(int i = 0 ; i < n ; i++){
            int value = sc.nextInt();
            Node newNode = new Node(value);
            if(head == null){
                head = tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = tail.next;
            }
        }
        System.out.println("Enter k value to rotate k right times : ");
        int k = sc.nextInt();
        head = rotateRight(head,k);
        System.out.println("The Updated Linked List is : ");
        printLL(head);
    }
    //Naive Approach
    /*
    public static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        for(int i = 0 ; i < k ; i++){
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            Node end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;
    }
    */

    //Optimal Approach
    public static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        int length = 1;
        while (temp.next != null) {
            ++length;
            temp = temp.next;
        }
        temp.next = head;
        k = k % length;
        int end = length - k;
        while (end-- != 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;

        return head;
    }

    public static void printLL(Node head){
        while(head != null){
            if(head.next != null){
                System.out.print(head.data + " -> ");
            }
            else{
                System.out.print(head.data);
            }
            head = head.next;
        }
    }
}
import java.util.*;
public class ReverseLLRecursive{
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
        head = reverseList(head);
        System.out.println("The Reversed LinkedList is : ");
        printLL(head);
    }

    public static Node reverseList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newNode = reverseList(head.next);

        Node front = head.next;
        front.next = head;
        head.next = null;
        return newNode;
    }
     
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
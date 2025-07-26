import java.util.*;
public class ReverseLL{
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

    //Using Brute Force Approch
    /* 
    public ListNode reverseList(ListNode head){
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            temp.val = st.pop();
            temp = temp.next;
        }
        return head;
    }
    */

    //Optimal Approch
    public static Node reverseList(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;    // Store in temporary 
            current.next = prev;    // Point to prev
            prev = current;
            current = next;
        }
        return prev;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
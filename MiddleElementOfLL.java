import java.util.*;
public class MiddleElementOfLL{
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
                tail = tail.next;
            }
        }
        head = middleNode(head);
        System.out.print(" The middle of the linked list : ");
        printLL(head);
    }
    // Brute Force Approch 
    /*
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        int mid = (count) / 2 + 1;
        temp = head;
        while(temp != null){
            mid = mid - 1;
            if(mid == 0){
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
    */
    public static Node middleNode(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
    }
}
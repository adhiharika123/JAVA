import java.util.Scanner;

public class RemoveNthNodeFromLastLL {
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
        System.out.println("Enter the n value where to delete : ");
        int N = sc.nextInt();
        System.out.println("The Updated LinkedList is : " + removeNthFromEnd(head, N));
        printLL(head);
    }
    
    //Brute Force Approch 
    /*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getlength(head);
        int indexToRemove = length - n;
        if(indexToRemove == 0){
            return head.next;
        }
        ListNode temp = head;
        for(int i = 0 ; i < indexToRemove - 1 ; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    public static int getlength(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    */

    public static Node removeNthFromEnd(Node head, int N){
        //Two Pointers where the slow points to the node before to be deleted
        Node slow = head;
        Node fast = head;
        for(int i = 0 ; i < N ; i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        Node DelNode = slow.next;
        slow.next = slow.next.next;
        DelNode = null;
        return head;
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
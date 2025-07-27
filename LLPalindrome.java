import java.util.*;
public class LLPalindrome{
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
        System.out.println("The LinkedList is Palindrome : " + isPalindrome(head));
    }

    //Using Stack (BruteForce Approch)
    /*
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.val != st.peek()){
                return false;
            }
            st.pop();
            temp = temp.next;
        }
        return true;
    }
    */


    //Using Tortoise and Hare Algorithm
    public static boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Function to Reverse the Second Half
        Node newHead = reverseLinkedList(slow.next);
        Node first = head;
        Node second = newHead;
        while(second != null){
            if(first.data != second.data){
                reverseLinkedList(newHead);
                return false;
            }
            //Comparing to check palindromes
            first = first.next;
            second = second.next;           
        }
        //Restore Second Half to Original 
        reverseLinkedList(newHead);
        return true;
    }
    public static Node reverseLinkedList(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newHead = reverseLinkedList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
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
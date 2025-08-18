import java.util.*;
public class RemoveDuplicatesfromLL {
    public static void main(String arga[]){
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
        head = removeduplicates(head);
        System.out.println("The Updated Linked List is : ");
        printLL(head);
    }

    //Approach 1 : Naive TC : O(N) , SC : O(N)
    /* 
    public static Node removeduplicates(Node head){
        HashSet<Integer> set = new HashSet<>();
        Node temp = head;
        Node newHead = null;
        Node tail = null;

        while(temp != null){
            if(!set.contains(temp.data)){
                Node newNode = new Node(temp.data);
                if(newHead == null){
                    newHead = newNode;
                    tail = newHead;
                }
                else{
                    tail.next = newNode;
                    tail = newNode;
                }
                set.add(temp.data);
            }
            temp = temp.next;
        }
        return newHead;
    }
    */

    //Approach 2 : Optimal (Pointer)

    public static Node removeduplicates(Node head){
        Node temp = head;
        while(temp != null && temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;     
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            if(head.next != null){
                System.out.print(head.data + " -> ");
            }
            else{
                System.out.println(head.data);
            }
            head = head.next;
        }
    }
}

class Node{
    int data;
    Node next;
    
    Node(int data1,Node next1){
        data = data1;
        next = next1;
    }
    Node(int data1){
        data = data1;
        next = null;
    }
}

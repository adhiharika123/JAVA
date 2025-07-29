import java.util.*;
public class Sort0s1s2sofLL {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements to be inserted : ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements : ");
        Node head = null, tail = null;
        for(int i = 0 ; i < n ; i++){
            int value = sc.nextInt();
            Node newNode = new Node(value);
            if(head == null){
                head = tail = newNode;
            }
            tail.next = newNode;
            tail = tail.next;
        }
        head = sortedLL(head);
        System.out.println(" The Sorted LinkedList is : ");
        printLL(head);
    }

    //Using BruteForce Approch ( Sorting , TC : O(N^2))
    /*
    public static Node sortedLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        int prev = 0;
        boolean swapped;        //      For Multiple Swaps
        do{
            Node temp = head;   
            swapped = false;
            while(temp != null && temp.next != null){
            if(temp.data > temp.next.data){
                prev = temp.data;
                temp.data = temp.next.data;
                temp.next.data = prev;
                swapped = true;
            }
            temp = temp.next;
            }           
        }while(swapped);
        return head;   
    }
    */

    //Using Optimal Approch (3 pointers Algorithm - Dutch National Flag Using 3 pointers )

    public static Node sortedLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);
        Node zero = zeroDummy, one = oneDummy, two = twoDummy;
        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }
            if(temp.data == 2){
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        two.next = null;    // Pointing Last Node to null
        one.next = twoDummy.next;   // Connecting 2s to 1s
        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;    //Connecting 0s -> 1s -> 2s;
        return zeroDummy.next;

    }

    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data);
            if(head.next != null){
                System.out.print(" -> ");
            }
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

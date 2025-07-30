import java.util.*;
public class Add1toANumberRepresentedByLL{
    public static void main(String[] args) {
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
        head = addOne(head);
        System.out.println("The updated LinkedList is : " );
        printLL(head);
    }
    public static int addWithCarry(Node head){
        if(head == null){
            return 1;
        }

        int res = head.data + addWithCarry(head.next);
        head.data = res % 10;
        return res / 10;
    }
    public static Node addOne(Node head){
        int carry = addWithCarry(head);

        //If any Carry genereated then we create a new node (example : 999 => 1000)
        if(carry > 0){
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }
        return head;
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
        next = null;
    }
}
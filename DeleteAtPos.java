package LinkedLists;
import java.util.Scanner;

public class DeleteAtPos {
    public static void main(String[] args){
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

        System.out.println("Enter the position: ");
        int pos = sc.nextInt();

        head = deleteatpos(head, pos);

        System.out.println("Updated Linked List is :");
        printLL(head);
    }
    //Delete at Position
    public static Node deleteatpos(Node head,int pos){
        if(head == null || pos < 1){
            return head;
        }
        if(pos == 1){
            return head.next;
        }
        Node temp = head;
        for(int i = 0 ; i < pos - 1 ; i++){
            if(temp == null || temp.next == null){
                return head;
            } 
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.println(head.data + " ");
            head = head.next;
        }
    }
}

//To compile : javac LinkedLists/DeleteAtPos
//To run : java LinkedLists/DeleteAtPos
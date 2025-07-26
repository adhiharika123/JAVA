import java.util.Scanner;

public class DeleteAtHeadDoublyLL {
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
                newNode.prev = tail;
                tail = tail.next;
            }
        }

        
        head = deleteAtHead(head);
        System.out.println("Updated LinkedList is : ");
        printLL(head);              
    }
    public static Node deleteAtHead(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        head = temp.next;
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

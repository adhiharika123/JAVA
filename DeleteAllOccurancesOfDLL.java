import java.util.*;
public class DeleteAllOccurancesOfDLL{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to insert : ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elemnts : ");
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
                newNode.prev = tail;
                tail = tail.next;
            }
        }
        System.out.println("Enter the key value to delete its all occurances : ");
        int x = sc.nextInt();

        head = deleteall(head,x);
        System.out.println("The Updated LinkedList is : ");
        printLL(head);
    }
    public static Node deleteall(Node head, int x){
        Node curr = head;
        while(curr != null){
            if(curr.data == x){
                Node toDelete = curr;
                if(curr == head){
                    head = curr.next;
                    if(head != null){
                        head.prev = null;
                    }
                }
                else{
                    curr.prev.next = curr.next;
                    if(curr.next != null){
                        curr.next.prev = curr.prev;
                    }
                }
                curr = curr.next;
                toDelete = null;
            }
            else{
                curr = curr.next;
            }
        }
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
    Node prev;
    
    Node(int data1, Node next1, Node prev1){
        data = data1;
        next = next1;
        prev = prev1;
    }
    Node(int data1){
        data = data1;
        next = null;
        prev = null;
    }
}
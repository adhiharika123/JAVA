package LinkedLists;
import java.util.*;

public class SearchinLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + "elements ");
        Node head =null, tail = null;
        for(int i = 0 ; i < n ; i++){
            int value = sc.nextInt();
            Node newnode = new Node(value);
            if(head == null){
                head = tail = newnode ;
            }
            else{
                tail.next = newnode;
                tail = tail.next;
            }
        }
        System.out.println("Enter the value to be searched in LinkedList : ");
        int val = sc.nextInt();
        System.out.println("The value is present in the LinkedList : " + search(head, val));
    }
    public static boolean search(Node head, int val){
        if(head == null){
            return false;
        }
        Node temp = head;
        while(temp != null){
            
            if(temp.data == val){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}

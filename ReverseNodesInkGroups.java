import java.util.*;
public class ReverseNodesInkGroups{
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
        System.out.println("Enter the k value : ");
        int k = sc.nextInt();
        head = reverseKGroup(head, k);
        System.out.println("The Updated Linked List is : ");
        printLL(head);
    }
    public static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node prevLast = null;
        while(temp != null){
            Node kthNode = getkthNode(temp, k);
            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }
            Node nextNode = kthNode.next;
            kthNode.next = null;

            reverseLinkedList(temp);
            
            if(temp == head){
                head = kthNode;
            }
            else{
                prevLast.next = kthNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }
    public static Node reverseLinkedList(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node getkthNode(Node temp, int k){
        k -= 1;
        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public static void printLL(Node head){
        while(head != null){
            if(head.next != null){
                System.out.print(head.data + " -> ");
            }
            else{
                System.out.print(head.data);
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
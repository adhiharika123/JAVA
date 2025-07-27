import java.util.Scanner;

public class FindingStartingPointInLL {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements to be insertrd : ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements : ");
        Node head = null , tail = null;
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
        System.out.print("Create a cycle? (yes/no): ");
        String choice = sc.next();

        if (choice.equalsIgnoreCase("yes") && head != null && head.next != null) {
            tail.next = head.next;  // Creates a cycle by connecting last node to second node
        }
        System.out.println("The LinkedList has Cycle at index  : "  + detectCycle(head));
    }

    public static int detectCycle(Node head) {

        //Using HashSet
        /*
        if(head == null || head.next == null){
            return null;
        }
        HashSet<ListNode> map = new HashSet<>();
        ListNode temp = head;
        while(temp != null){
            if(map.contains(temp)){
                return temp;
            }
            map.add(temp);
            temp = temp.next;
        }
        return null;
        */

        //Using Tortoise and Hare Algorithm
        if(head == null || head.next == null){
            return 0;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                int index = 0;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next; 
                    index++;  
                }
                return index;
            }    
        }
        return 0;
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


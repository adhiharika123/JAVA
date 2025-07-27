import java.util.Scanner;

public class DetectLoopLL {
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
        System.out.println("The LinkedList has Cycle : "  + hasCycle(head));
        
    }
    public static boolean hasCycle(Node head) {
        // Using HashSet(That stores unique elements)
        /*
        HashSet<ListNode> map = new HashSet<>();
        ListNode temp = head;
        while(temp != null){
            if(map.contains(temp)){
                return true;
            }
            map.add(temp);
            temp = temp.next;
        }
        return false;  
        */

        //Using Tortoise and Hare(Floyd's Algorithm)
        if(head == null || head.next == null){
            return false;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast= fast.next.next;

            if(slow == fast){      
                return true;
            }
        }
        return false;
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

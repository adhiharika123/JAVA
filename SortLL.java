import java.util.*;

public class SortLL {
    public static void main(String args[]){
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
        head = sortList(head);  
        System.out.println("The Sorted LinkedList is : ");
        printLL(head);
    }
    //Using BruteForce Approch 
    /*
    public Node sortList(Node head) {
        if(head == null){
            return null;
        }
        //Convert LinkedList to Array
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        //Sort the Array
        Collections.sort(list);

        //Conevert Array Back to LinkedList
        Node newHead = new Node(list.get(0));
        Node current = newHead;
        for(int i = 1 ; i < list.size() ; i++){
            current.next = new Node(list.get(i));
            current = current.next;
        }
        return newHead;
        }
        */
    
    //Using MergeSort

    public static Node sortList(Node head){
        //Find the Middle Element
        if(head == null || head.next == null){
            return head;
        }
        Node middle = findMiddle(head);

        //Divide into two halves
        Node right = middle.next;
        middle.next = null;
        Node left = head;

        //Recursively Sort the left and right halves
        left = sortList(left);
        right = sortList(right);

        //Merge them into One
        return mergesortedlinkedlist(left, right);

    }
    public static Node findMiddle(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node mergesortedlinkedlist(Node list1, Node list2){
        Node dummynode = new Node(-1);
        Node temp = dummynode;

        while(list1 != null && list2 != null){
            if(list1.data <= list2.data){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        //If any has left 
        if(list1 != null){
            temp.next = list1;
        }
        else{
            temp.next = list2;
        }
        return dummynode.next;
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

    Node(int data1, Node next1){
        data = data1;
        next = next1;
    }

    Node(int data1){
        data = data1;
        next = null;
    }
}

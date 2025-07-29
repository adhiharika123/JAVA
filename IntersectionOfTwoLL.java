import java.util.*;

public class IntersectionOfTwoLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for first linked list
        System.out.print("Enter number of nodes in List A: ");
        int n1 = sc.nextInt();
        System.out.println("Enter " + n1 + " elements for List A:");
        ListNode headA = createLinkedList(sc, n1);

        // Input for second linked list
        System.out.print("Enter number of nodes in List B (before intersection): ");
        int n2 = sc.nextInt();
        System.out.println("Enter " + n2 + " elements for List B:");
        ListNode headB = createLinkedList(sc, n2);

        // Optionally create intersection
        System.out.print("Enter position (0-based) in List A to intersect List B (-1 for no intersection): ");
        int pos = sc.nextInt();
        if (pos >= 0) {
            ListNode intersectNode = getNodeAt(headA, pos);
            if (intersectNode != null) {
                ListNode tailB = headB;
                while (tailB.next != null) {
                    tailB = tailB.next;
                }
                tailB.next = intersectNode;
            }
        }

        Solution sol = new Solution();
        ListNode intersection = sol.getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection Node Value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }

    // Helper to create Linked List from user input
    public static ListNode createLinkedList(Scanner sc, int n) {
        ListNode head = null, tail = null;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
        return head;
    }

    // Helper to get node at given position (0-based)
    public static ListNode getNodeAt(ListNode head, int index) {
        int count = 0;
        while (head != null && count < index) {
            head = head.next;
            count++;
        }
        return head;
    }
}


class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode d1 = headA;
        ListNode d2 = headB;

        while (d1 != d2) {
            d1 = (d1 == null) ? headB : d1.next;
            d2 = (d2 == null) ? headA : d2.next;
        }

        return d1; // either intersection node or null
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

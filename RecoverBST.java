import java.util.*;

public class RecoverBST {

    static Node first = null, middle = null, last = null, prev = null;

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.right = new Node(2);

        recoverTree(root);

        printInorder(root);
    }

    public static void recoverTree(Node root) {
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);

        inorder(root);

        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);

        // Detect violation
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }

    public static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
    Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

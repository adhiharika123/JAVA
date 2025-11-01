import java.util.*;
public class SearchInABST{
    public static void main(String args[]){
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.left.right.left = new Node(6);
        root.right.right.left = new Node(13);

        //int val = 10;
        int val = 5;

        Node found = searchBST(root, val);
        printOrder(found);
    }
    public static Node searchBST(Node root, int val) {
        while(root != null && root.val != val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
    public static void printOrder(Node root){
        if(root == null){
            return;
        }
        printOrder(root.left);
        System.out.print(root.val + " ");
        printOrder(root.right);
    }
}

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
    }
    Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
import java.util.*;
public class LCAForTwoNodes{
    public static void main(String[] args) {
        // Construct the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        // Target node value
        Node x = root.left.left;
        Node y = root.left.right;

        Node res = lowestCommonAncestor(root, x, y);
        System.out.println("The lowest common ancestor for two nodes " + x.data + " and " + y.data + " is : " + res.data);
    }
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null || root == p || root == q){
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }

    Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
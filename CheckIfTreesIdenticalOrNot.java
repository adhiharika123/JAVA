import java.util.*;

public class CheckIfTreesIdenticalOrNot{
    public static void main(String args[]){
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.right.left = new Node(4);
        root1.right.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.right.left = new Node(6);
        root2.right.right = new Node(5);

        boolean result = isSameTree(root1, root2);
        System.out.println("Two Trees are Identical : " + result);
    }

    public static boolean isSameTree(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return((root1.data == root2.data) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right));
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
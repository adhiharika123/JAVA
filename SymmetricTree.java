/* Given a Binary Tree, determine whether the given tree is symmetric or not.
A Binary Tree would be Symmetric, when its mirror image is exactly the 
same as the original tree. If we were to draw a vertical line through 
the centre of the tree, the nodes on the left and right side would be 
mirror images of each other. */

import java.util.*;
public class SymmetricTree {
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(5);
        root.right.right = new Node(4);



        boolean result = isSymmetric(root);
        System.out.println("Two Trees are Identical : " + result);
    }
    public static boolean isSymmetric(Node root) {
        if(root == null){
            return true;
        }
        return isSymmetricUtil(root.left, root.right);
    }
    public static boolean isSymmetricUtil(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        return ((root1.data == root2.data) && isSymmetricUtil(root1.left, root2.right) && isSymmetricUtil(root1.right, root2.left)); 
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

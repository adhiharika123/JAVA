import java.util.*;

import javax.swing.tree.TreeNode;
public class CheckTreeBalancedOrNot {
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);

        boolean result = isBalanced(root);
        System.out.println("Tree is Balanced : " + result );
    }
    //Brute Force 
    /*
    public static boolean isBalanced(Node root) {
        if(root == null) return true;
        int lheight = getHeight(root.left);
        int rheight = getHeight(root.right);

        if(Math.abs(lheight - rheight) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }

    public static int getHeight(Node root){
        if(root == null) return 0;
        int leftheight = getHeight(root.left);
        int rightheight = getHeight(root.right);

        return Math.max(leftheight, rightheight) + 1;
    }
    */

    //Optimal Approach (POSTORDER TRAVERSAL)

    public static boolean isBalanced(Node root){
        return dfsHeight(root) != -1;
    }
    public static int dfsHeight(Node root){
        if(root == null) return 0;
        int leftHeight = dfsHeight(root.left);
        if(leftHeight == -1){
            return -1;
        }

        int rightHeight = dfsHeight(root.right);
        if(rightHeight == -1){
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
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

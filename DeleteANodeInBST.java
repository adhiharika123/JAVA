import java.util.*;

import javax.swing.tree.TreeNode;
public class DeleteANodeInBST{
    public static void main(String args[]){
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(14);

        int key = 3;
        Node value = deleteNode(root, key);
        printInorder(value); 
    }
    public static Node deleteNode(Node root, int key) {
        if(root == null) return root;
        if(root.data > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.data < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            Node succ = getSuccessor(root);
            root.data = succ.data;
            root.right = deleteNode(root.right, succ.data);
        }
        return root;
    }
    public static Node getSuccessor(Node curr){
        curr = curr.right;
        while(curr != null && curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
    public static void printInorder(Node root){
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
    Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
import java.util.*;

import javax.swing.tree.TreeNode;
public class HeightOfABinaryTree {
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);

        int depth = maxDepth(root);
        System.out.println("The Height of a Binary Tree is : " + depth);
    }
    public static int maxDepth(Node root) {

        //Brute Force Approach 

        /*
        if(root == null) return 0;
        int lheight = maxDepth(root.left);
        int rheight = maxDepth(root.right);
        int depth = Math.max(lheight , rheight) + 1;
        return depth;
        */

        //Optimal Approach 
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node node = q.poll();       //q.poll() -> removes the head(root) of queue
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
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

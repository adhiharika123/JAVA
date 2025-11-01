import java.util.*;

import javax.swing.tree.TreeNode;
public class KthSmallestInBST {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        int key = 3;
        int kthSmallest = kthSmallest(root, key);
        System.out.println("Kth Smallest element in BST is : " + kthSmallest);
    }
    /*
    public static int kthSmallest(Node root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        int kthSmallest = arr.get(k-1);
        return kthSmallest;
    }
    public static void inorder(Node root, List<Integer> arr){
        if(root == null){
            return;
        }
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }
    */
    public static int kthSmallest(Node root, int k) {
        int[] kSmallest = new int[1];
        int[] counter = new int[1];
        inorder(root, counter, k, kSmallest);
        return kSmallest[0];
    }
    public static void inorder(Node root, int[] counter, int k, int[] kSmallest){
        if(root == null || counter[0] > k){
            return;
        }
        inorder(root.left, counter, k, kSmallest);
        counter[0]++;
        if(counter[0] == k){
            kSmallest[0] = root.data;
            return;
        }
        inorder(root.right, counter, k, kSmallest);
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
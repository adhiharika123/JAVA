import java.util.*;
public class KthLargestInBST {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        int key = 2;
        int kthLargest = kthLargest(root, key);
        System.out.println("Kth Largest element in BST is : " + kthLargest);
    }
    /*
    public static int kthLargest(Node root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        int kthLargest = arr.get(arr.size() - k);
        return kthLargest;
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

    public static int kthLargest(Node root, int k) {
        int[] kLargest = new int[1];
        int[] counter = new int[1];
        reverseinorder(root, counter, k, kLargest);
        return kLargest[0];
    }
    public static void reverseinorder(Node root, int[] counter, int k, int[] kLargest){
        if(root == null || counter[0] > k){
            return;
        }
        reverseinorder(root.right, counter, k, kLargest);
        counter[0]++;
        if(counter[0] == k){
            kLargest[0] = root.data;
            return;
        }
        reverseinorder(root.left, counter, k, kLargest);
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
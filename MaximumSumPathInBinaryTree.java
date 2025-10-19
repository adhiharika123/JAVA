import java.util.*;


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
public class MaximumSumPathInBinaryTree{
    public static void main(String args[]){
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        Solution solution = new Solution();

        int result = solution.maxPathSum(root);
        System.out.println("The Maximum Sum Path In Binary Tree is : " + result);
    }
}

class Solution{
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(Node root) {
        dfs(root);      //Recursive Function to count maxSum of both leftSubtree and rightSubtree
        return maxSum;
    }
    public int dfs(Node root){
        if(root == null){
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        maxSum = Math.max(maxSum, left+right+root.data);

        return Math.max(left, right) + root.data;
    } 
}
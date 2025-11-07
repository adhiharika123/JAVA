import javax.swing.tree.TreeNode;

public class MaxSumBST {
    static int maxSum = 0;
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.right = new Node(7);

        int sumValues = maxSumBST(root);
        System.out.println("The sum of nodes in largest BST is : " + sumValues);
    }
    /*
    public int maxSumBST(TreeNode root) {
        if(root == null) return 0;
        if(isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            return Math.max(0,sumValues(root));
        }
        else{
            int left = maxSumBST(root.left);
            int right = maxSumBST(root.right);
            return Math.max(0, Math.max(left, right));
        }
    }
    public boolean isValidBST(TreeNode root, int minVal, int maxVal){
        if(root == null) return true;
        if(root.val >= maxVal || root.val <= minVal){
            return false;
        }
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
    public static int sumValues(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.val + sumValues(root.left) + sumValues(root.right);
    }
    */
    public static int maxSumBST(Node root){
        maxSumBSTHelper(root);
        return maxSum;
    }
    
    private static NodeValue maxSumBSTHelper(Node root){
        
        if(root == null){
            return  new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = maxSumBSTHelper(root.left);
        NodeValue right = maxSumBSTHelper(root.right);
        
        if(left.maxNode < root.data && root.data < right.minNode){
            int currentSum = left.sum + right.sum + root.data;
            maxSum = Math.max(maxSum, currentSum);
            return new NodeValue(Math.min(root.data, left.minNode),
            Math.max(root.data, right.maxNode), currentSum);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,0);
    }
}

class NodeValue {
    int minNode, maxNode, sum;

    NodeValue(int minNode, int maxNode, int sum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;        
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
    Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

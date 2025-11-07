public class LargestBST {
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.right = new Node(7);

        int countNodes = largestBst(root);
        System.out.println("The number of nodes in largest BST is : " + countNodes);
    }
    /*
    // Return the size of the largest sub-tree which is also a BST
    public static int largestBst(Node root) {
        if(root == null) return 0;
        if(isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            return countNodes(root);
        }
        else{
            int left = largestBst(root.left);
            int right = largestBst(root.right);
            return Math.max(left, right);
        }
    }
    public static boolean isValidBST(Node root, int minVal, int maxVal){
        if(root == null) return true;
        if(root.data >= maxVal || root.data <= minVal){
            return false;
        }
        return isValidBST(root.left, minVal, root.data) && isValidBST(root.right, root.data, maxVal);
    }
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }



    */

    public static int largestBst(Node root) {
        return largestSubtreeHelper(root).maxSize;
    }
    private static  NodeValue largestSubtreeHelper(Node root){
        if(root == null){
            return  new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = largestSubtreeHelper(root.left);
        NodeValue right = largestSubtreeHelper(root.right);
        if(left.maxNode < root.data && root.data < right.minNode){
            return new NodeValue(Math.min(root.data, left.minNode),
            Math.max(root.data, right.maxNode), left.maxSize + right.maxSize + 1);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,Math.max(left.maxSize , right.maxSize));
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
class NodeValue{
    int maxNode, minNode, maxSize;
    NodeValue(int minNode, int maxNode, int maxSize){
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}
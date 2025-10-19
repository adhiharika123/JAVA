import java.util.*;
public class Right_and_LeftViewOfBinaryTree{
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        // Get the right view traversal
        List<Integer> rightSideView = rightSideView(root);

        // Print the result
        System.out.println("RightSide View : ");
        for (int node : rightSideView) {
            System.out.print(node + " ");
        }
        System.out.println();

        // Get the left view traversal
        List<Integer> leftSideView = leftSideView(root);

        // Print the result
        System.out.println("LeftSide View: ");
        for (int node : leftSideView) {
            System.out.print(node + " ");
        }
    }
    public static List<Integer> rightSideView(Node root) {
        List<Integer> res = new ArrayList<>();
        recursiveRight(root, 0, res);
        return res;
    }
    public static List<Integer> leftSideView(Node root) {
        List<Integer> res = new ArrayList<>();
        recursiveLeft(root, 0, res);
        return res;
    }
    private static void recursiveRight(Node root, int level, List<Integer> res){
        if(root == null) return;
        if(res.size() == level){
            res.add(root.data);
        }

        recursiveRight(root.right, level+1, res);
        recursiveRight(root.left, level+1, res);
    }
    private static void recursiveLeft(Node root, int level, List<Integer> res){
        if(root == null) return;
        if(res.size() == level){
            res.add(root.data);
        }

        recursiveLeft(root.left, level+1, res);
        recursiveLeft(root.right, level+1, res);
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
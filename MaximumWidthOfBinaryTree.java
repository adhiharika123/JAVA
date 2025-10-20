import java.util.*;

import javax.swing.tree.TreeNode;
public class MaximumWidthOfBinaryTree{
    public static void main(String[] args) {

        // Create the tree
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);
        // Call the function and print result
        System.out.println("Maximum width: " +  widthOfBinaryTree(root));
    }
    public static int widthOfBinaryTree(Node root) {
        if(root == null) return 0;
        int maxWidth = 0;
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int minIndex = q.peek().getValue();
            int first = 0;
            int last = 0;
            for(int i = 0; i < size; i++){
                Pair<Node, Integer> pair = q.poll();
                Node node = pair.getKey();
                int currIndex = pair.getValue() - minIndex;
                if(i == 0){
                    first = currIndex;
                }
                if(i == size - 1){
                    last = currIndex;
                }
                if(node.left != null){
                    q.offer(new Pair<>(node.left, 2*currIndex+1));
                }
                if(node.right != null){
                    q.offer(new Pair<>(node.right, 2*currIndex+2));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
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
class Pair<U, V>{
    U key;
    V value;

    Pair(U key, V value){
        this.key = key;
        this.value = value;
    }

    public U getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
}
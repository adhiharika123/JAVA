import java.util.*;
public class MorrisInorderTraversalOfABinaryTree{
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        List<Integer> inorder = getInorder(root);

        System.out.print("Binary Tree Morris Inorder Traversal: ");
        for (int i = 0; i < inorder.size(); i++) {
            System.out.print(inorder.get(i) + " ");
        }
        System.out.println();
    }
    public static List<Integer> getInorder(Node root) {
        // code here
        List<Integer> inorder = new ArrayList<>();
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                inorder.add(curr.data);
                curr = curr.right;
            }
            else{
                Node predecessor = curr.left;
                while(predecessor.right != null && predecessor.right != curr){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = curr;
                    curr = curr.left;
                }
                else{
                    predecessor.right = null;
                    inorder.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
}
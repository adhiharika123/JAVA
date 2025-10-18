import java.util.ArrayList;
import java.util.Stack;

public class IterativePreorderTraversal {
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Call preOrder and store result
        ArrayList<Integer> list = preOrder(root);

        // Print the preorder list
        printList(list);
    }

    public static void printList(ArrayList<Integer> list){
        for(int num : list){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        if(root == null){
            return preorder;
        }

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            root = st.pop();
            preorder.add(root.data);

            // Push right child first so that left is processed first
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return preorder;
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

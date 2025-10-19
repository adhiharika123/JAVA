import java.util.*;
public class ZigZagTraversalOfABinaryTree {
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> result = zigzagLevelOrder(root);
        for(List<Integer> level : result){
            printList(level);
        }
    }
    public static void  printList(List<Integer> list){
        for(int num : list){
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node node = q.poll();
                int index = leftToRight ? i : (size - 1 - i);
                if(leftToRight){
                    row.add(node.data);  // add at the end
                } 
                else {
                    row.add(0, node.data);  // add at the beginning
                }

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            leftToRight = !leftToRight;
            ans.add(row);
        }
        return ans;
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
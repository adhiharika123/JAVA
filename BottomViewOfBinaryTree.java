import java.util.*;
public class BottomViewOfBinaryTree{
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        // Get the top view traversal
        List<Integer> topView = bottomView(root);

        // Print the result
        System.out.println("Vertical Traversal: ");
        for (int node : topView) {
            System.out.print(node + " ");
        }
    }
    public static List<Integer> bottomView(Node root) {
        // code here
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        while(!q.isEmpty()){
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue();

            map.put(line, node.data);
            
            if(node.left != null){
                q.add(new Pair<>(node.left, line-1));
            }
            if(node.right != null){
                q.add(new Pair<>(node.right, line+1));
            }
        }
        for(int value : map.values()){
            ans.add(value);
        }
        return ans;
    }
}
class Pair<U, V> {
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
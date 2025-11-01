/* Given a Binary Search Tree and a key, return the ceiling of the given key in the Binary Search Tree.
Ceiling of a value refers to the value of the smallest node in the Binary Search Tree that is greater than or equal to the given key. 
If the ceiling node does not exist, return nullptr. */

import java.util.*;
public class FloorInABST{
    public static void main(String args[]){
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        /*
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.left.right.left = new Node(6);
        root.right.right.left = new Node(13);
        */

        //int val = 10;
        int x = 7;

        int val = findFloor(root, x);
        System.out.print("The Ceil In Binary Search Tree is : " + val);
    }
    public static int findFloor(Node root, int x) {
        // code here
        int floor = -1;
        while(root != null){
            if(root.data == x){
                floor = root.data;
                return floor;
            }
            if(x > root.data){
                floor = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return floor;
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
import java.util.*;
public class FindPairsWithGivenSumInDLL {
    public static void main(String arga[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements : ");
        Node head = null;
        Node tail = null;
        for(int i = 0 ; i < n ; i++){
            int value = sc.nextInt();
            Node newNode = new Node(value);
            if(head == null){
                head = tail = newNode;
            }
            else{
                tail.next = newNode;
                newNode.prev = tail;
                tail = tail.next;
            }
        }
        System.out.println("Enter the target value : ");
        int target = sc.nextInt();

        System.out.println("The Pairs with given sum are : ");
        ArrayList<ArrayList<Integer>> pairs = findpairs(head,target);
        if(pairs.isEmpty()){
            System.out.println("No Pairs Found");
        }
        else{
            for(ArrayList<Integer> paired : pairs){
                System.out.println(paired.get(0) + " " + paired.get(1));
            }
        }
        //printLL(head);
    }
    
    //Approach 1 : Naive/Brute Force   TC: O(N) SC : O(N)
    /* 
    public static ArrayList<ArrayList<Integer>>  findpairs(Node head, int target){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Node curr = head;
        while(curr != null){
            int x = curr.data;
            int complement = target - curr.data;
            if(set.contains(complement)){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(complement);
                pair.add(x);
                ans.add(pair);
            }
            set.add(curr.data);
            curr = curr.next;
        }
        Collections.sort(ans,(a,b) -> a.get(0).compareTo(b.get(0)));
        return ans;
    }
    */

    //Approach 2 : Two Pointer(Optimal)

    public static ArrayList<ArrayList<Integer>>  findpairs(Node head, int target){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node start = head;
        Node end = head;
        while(end.next != null){
            end = end.next;
        }
        while(start != end  && end.next != start){
            if(start.data + end.data == target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(start.data);
                pair.add(end.data);
                ans.add(pair);

                start = start.next;
                end = end.prev;
            }
            else if(start.data + end.data < target){
                start = start.next;
            }
            else{
                end = end.prev;
            }            
        }
        return ans;
    } 
}

class Node{
    int data;
    Node next;
    Node prev;

    Node(int data1, Node next1, Node prev1){
        data = data1;
        next = next1;
        prev = prev1;
    }
    Node(int data1){
        data = data1;
        next = null;
        prev = null;
    }
}
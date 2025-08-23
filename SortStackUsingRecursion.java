import java.util.*;
import java.util.Stack;
public class SortStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(11);
        s.push(2);
        s.push(32);
        s.push(1);
        s.push(41);

        sort(s);

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }
    public static void sort(Stack<Integer> s){
        if(!s.isEmpty()){
            int x = s.pop();
            sort(s);
            insertSorted(s,x);
        }
    }
    public static void insertSorted(Stack<Integer> s , int x){
        // x > s.peek() = > Descending order
        // x < s.peek() = > Ascending order
        if(s.isEmpty() || x  > s.peek()){
            s.push(x);
            return;
        }
        int temp = s.pop();
        insertSorted(s,x);
        s.push(temp);
    }
}

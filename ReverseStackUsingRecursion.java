import java.util.*;
public class ReverseStackUsingRecursion {
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(11);
        s.push(2);
        s.push(31);
        s.push(4);
        s.push(41);
        reverse(s);
        System.out.println("The Reversed Stack is :");
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }
    public static void reverse(Stack<Integer> s){
        if(!s.isEmpty()){
            int x = s.pop();
            reverse(s);
            insertAtBottom(s,x);
        }        
    }
    public static void insertAtBottom(Stack<Integer> s, int x){
        if(s.isEmpty()){
            s.push(x);
        }
        else{
            int y = s.pop();
            insertAtBottom(s, x);
            s.push(y);
        }
    }
}

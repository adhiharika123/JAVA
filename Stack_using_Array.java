import java.util.*;
public class Stack_using_Array{
    public static void main(String args[]){
        stack s = new stack();
        s.push(6);
        s.push(10);
        s.push(9);
        System.out.println("The top element of stack is : " + s.top());
        System.out.println("The size of stack is : " + s.size());
        System.out.println("The popped element from stack is : " + s.pop());
        System.out.println("The top element of stack is : " + s.top());
        System.out.println("The size of stack is : " + s.size());
    }
}
class stack{
    int size = 10000;
    int arr[] = new int[size];
    int top = -1;
    void push(int x){
        top++;
        arr[top] = x;
    }
    int pop(){
        int x = arr[top];
        top--;
        return x;
    }
    int top(){
        return arr[top];
    }
    int size(){
        return top+1;
    }
}
import java.util.*;
public class MinStack {
    public static void main(String[] args) {
        stack s = new stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("The size of stack is : " + s.size());
        System.out.println("The minimum element from stack is : " + s.getMin());
        System.out.println("The top element s : " + s.top());
        System.out.println("The size of stack is : " + s.size());
    }
}
class stack {
    //Using Two Stacks
    private Stack<Integer> st;
    private Stack<Integer> minst;
    public stack() {
        st = new Stack<>();
        minst = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty()){
            minst.push(val);
        }
        else{
            minst.push(Math.min(val, minst.peek()));
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
            minst.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }

    public int size(){
        return st.size();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
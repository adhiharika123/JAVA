import java.util.Queue;
import java.util.LinkedList;
public class Stack_using_Queues {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: " + s.top());
        System.out.println("Size of the stack before removing element: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack after removing element: " + s.top());
        System.out.println("Size of the stack after removing element: " + s.size());
    }
}

//Naive Approach - Using Two Queues
/* 
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        if(q1.isEmpty()){
            return -1;
        }
        while(q1.size() > 1){
            q2.add(q1.remove());
        }
        int popped = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return popped;
    }
    
    public int top() {
        if(q1.isEmpty()){
            return -1;
        }
        while(q1.size() > 1){
            q2.add(q1.remove());
        }
        int top = q1.peek();
        q2.add(q1.remove());

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
    public int size(){
        return q1.size();
    }
}*/

//Optimal Approach - Usin One Queue Only
class MyStack{
    Queue<Integer> q = new LinkedList<>();
    public void push(int x){
        q.add(x);
        for(int i = 0; i < q.size()-1; i++){
            q.add(q.remove());
        }
    }
    public int pop(){
        return q.remove();
    }
    public int top(){
        return q.peek();
    }
    public int size(){
        return q.size();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

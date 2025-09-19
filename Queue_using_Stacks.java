import java.util.Stack;
public class Queue_using_Stacks {
    public static void main(String args[]) {
        MyQueue q = new MyQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());
    }
}
/* 
class MyQueue {
    
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        //Push everthing from input to output
        while(input.empty() == false){
            output.push(input.peek());
            input.pop();
        }
        //Push new element into input
        input.push(x);

    //Push again from output to input to ensure the front of queue is at top of the the input stack 
        while(output.empty() == false){
            input.push(output.peek());
            output.pop();
        }
    }
    
    public int pop() {
        if(input.empty()){
            System.out.println("The Stack is Empty ");
        }
        int value = input.peek();
        input.pop();
        return value;
    }
    
    public int peek() {
        if(input.empty()){
            System.out.println("The Stack is Empty ");
        }
        int value = input.peek();
        return value;
    }
    
    public boolean empty() {
        return input.isEmpty();
    }

    public int size(){
        return input.size();
    }
}
*/

class MyQueue {
    
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        //Push everthing
        input.push(x);
    }
    
    public int pop() {
        if(output.empty()){
            while(input.empty() == false){
                output.push(input.peek());
                input.pop();
            }
        }
        int value = output.peek();
        output.pop();
        return value;
    }
    
    public int peek() {
        if(output.empty()){
            while(input.empty() == false){
                output.push(input.peek());
                input.pop();
            }
        }
        int value = output.peek();
        return value;
    }
    
    public boolean empty() {
        return input.isEmpty();
    }

    public int size(){
        return input.size() + output.size();
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

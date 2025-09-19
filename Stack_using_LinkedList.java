import java.util.*;
public class Stack_using_LinkedList {
    public static void main(String[] args) {
        stack s = new stack();
        s.stackPush(10);
        s.stackPush(20);
        s.stackPush(30);
        System.out.println("The top of the stack element is : " + s.stackTop());
        System.out.println("The size of the stack : " + s.stackSize());
        System.out.println("The popped element of stack is : " + s.stackPop());
        System.out.println("The size of the stack : " + s.stackSize());
        System.out.println("The top of the stack element is : " + s.stackTop());
        System.out.println("The popped element of stack is : " + s.stackPop());
        System.out.println("The size of the stack : " + s.stackSize());
    }
}
class stack{
    private class stackNode{
        int data;
        stackNode next;
        stackNode(int data1){
            data = data1;
            next = null;
        }
    }
    stackNode top;
    int size;
    stack() {
        this.top = null;
        this.size = 0;
    }
    public void stackPush(int x){
        stackNode element = new stackNode(x);
        element.next = top;
        top = element;
        System.out.println("The element pushed is : " + top.data);
        size++;
    }
    public int stackPop(){
        if(top == null) return -1;
        int topData = top.data;
        stackNode temp = top;
        top = top.next;
        size--;
        return topData;
    }
    public int stackTop(){
        if(top == null) return -1;
        int topData = top.data;
        return topData;
    }
    public int stackSize(){
        return size;
    }
}

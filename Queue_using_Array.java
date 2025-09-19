import java.util.*;
public class Queue_using_Array{
    public static void main(String[] args){
        Queue q = new Queue(5);
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        System.out.println("The peek element is : " + q.peek());
        System.out.println("The size of Queue is : " + q.size());
        System.out.println("The popped element is : " + q.pop());
        System.out.println("The peek element is : " + q.peek());
        System.out.println("The size of Queue is : " + q.size());
    }
}
class Queue{
    private int arr[];
    private int start, end, currSize, maxSize;
    public Queue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        start = 0;
        end = -1;
        currSize = 0;
    }
    public void push(int newElement){
        if(currSize == maxSize){
            System.out.println("Queue is full ");
            return;
        }
        end++;
        arr[end] = newElement;
        currSize++;
    }
    public int pop(){
        if(currSize == 0){
            System.out.println("Queue is Empty ");
            return -1;
        }
        int popped = arr[start];
        start++;
        currSize--;
        return popped;
    }
    public int peek(){
        if(currSize == 0){
            System.out.println("Queue is Empty ");
            return -1;
        }
        return arr[start];
    }
    public int size(){
        return currSize;
    }
}
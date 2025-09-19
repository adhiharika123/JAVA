import java.util.*;
public class Queue_using_LinkedList {
    public static void main(String args[]){
        Queue Q = new Queue();
        Q.enqueue(10);
        Q.enqueue(20);
        Q.enqueue(30);
        System.out.println("The size of Queue is : " + Q.size());
        Q.dequeue();
        System.out.println("The size of Queue is : " + Q.size());
        System.out.println("The peek element is : " + Q.peek());
    }
}
class QueueNode{
    int data;
    QueueNode next;
    QueueNode(int data1){
        data = data1;
        next = null;
    }   
}
class Queue{
    QueueNode Front = null;
    QueueNode Rare = null;
    int size = 0;

    public boolean Empty(){
        return Front == null; 
    }
    public int peek(){
        if(Empty()){
            System.out.println("The Queue is Empty ");
            return -1;
        }
        else{
            return Front.data;
        }
    }
    public void enqueue(int data){
        QueueNode Temp = new QueueNode(data);
        if(Temp == null){
            System.out.println("The Queue is Full ");
        }
        else{
            if(Front == null){
                Front = Temp;
                Rare = Temp;
            }
            else{
                Rare.next = Temp;
                Rare = Temp;
            }
            System.out.println(data + " element is inserted ");
            size++;
        }
    }
    public void dequeue(){
        if(Front == null){
            System.out.println("The Queue is Empty ");
        }
        System.out.println("The value popped is : " + Front.data);
        QueueNode Temp = Front;
        Front = Front.next;
        size--;
    }
    public int size(){
        return size;
    }
}

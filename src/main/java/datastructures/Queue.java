package datastructures;

import java.util.EmptyStackException;

/*
 A Queue is reversely linked from front to rear:-
       
        rear<-<-<-<-front

 */

class QueueException extends Exception{
    public QueueException(String msg){
        super(msg);
    }    
}
 
public class Queue<T> {
    Node<T> front=null,rear=null;
    public Queue(){
        front=null;
        rear=null;
    }
    public Queue(Queue<T> q2){ // copy constructor
        if(q2.isEmpty())    return;

        Node<T> temp1=q2.front,temp2;
        
        temp2=new Node<T>(temp1.data);
        this.front=temp2;
        temp1=temp1.next;
        
        while(temp1!=null){
            temp2.next=new Node<T>(temp1.data);
            temp1=temp1.next;
            temp2=temp2.next;
        }
        this.rear=temp2;
    }
    public boolean isEmpty(){
        return front==null;
    }
    public void enqueue(T val){
        Node<T> temp=new Node<T>(val);
        if(front==null){
            front=temp;
            rear=front;
        }
        else{
            rear.next=temp;
            rear=temp;
        }
    }
    public T dequeue() throws QueueException{
        if (isEmpty()) throw new QueueException("Queue is Empty");
        T val;
        val=front.data;
        front=front.next;
        if(front==null) rear=null;
        return val;
    }
    public T peek() throws QueueException{
        if (isEmpty()) throw new QueueException("Queue is Empty");
        return front.data;
    }
    public String toString(){
        String s="";
        Node<T> temp=front;
        while(temp!=null){
            s+=temp.data;
            temp=temp.next;
            if(temp!=null) 
                s+="->";
        }
        return s;
    }
    public void print(){
        System.out.println(toString());
    }
    public static void main(String args[]) throws QueueException{
        Queue<Integer> q1=new Queue<>();
        // q1.print();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        q1.print();
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        q1.print();
    }
}

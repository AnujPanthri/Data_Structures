package datastructures;

/*
 A Queue is reversely linked from front to rear:-
       
        rear<-<-<-<-front

 */

public class Queue<T> {
    Node<T> front=null,rear=null;
    public Queue(){
        front=null;
        rear=null;
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
    public T dequeue(){
        T val;
        val=front.data;
        front=front.next;
        if(front==null) rear=null;
        return val;
    }
    public T peek(){
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
    public static void main(String args[]){
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

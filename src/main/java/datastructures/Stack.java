package datastructures;

public class Stack<T> {
    public Node<T> top=null;
    public Stack(){
        top=null;
    }
    public Stack(Stack<T> s2){ // copy constructor
        if(s2.isEmpty())    return;

        Node<T> temp1=s2.top,temp2;
        
        temp2=new Node<T>(temp1.data);
        top=temp2;
        temp1=temp1.next;
        
        while(temp1!=null){
            temp2.next=new Node<T>(temp1.data);
            temp1=temp1.next;
            temp2=temp2.next;
        }

    }
    public boolean isEmpty(){
        return top==null;
    }
    public void push(T val){
        Node<T> temp=new Node<T>(val);
        temp.next=top;
        top=temp;
    }
    public T pop(){
        T val=top.data;
        top=top.next;
        return val;
    }
    public T peek(){
        return top.data;
    }
    public String toString(){
        String s="";
        Node<T> temp=top;
        while(temp!=null){
            s+=temp.data;
            temp=temp.next;
            if(temp!=null) s+="->";
        }
        return s;
    }
    public void print(){
        System.out.println(toString());
    }
    public static void main(String args[]){
        Stack<Integer> s1=new Stack<Integer>(),s2;
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.print();
        s1.pop();
        s1.print();
        s2=new Stack<Integer>(s1);
        s2.print();
    }    
}

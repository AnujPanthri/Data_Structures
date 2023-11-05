package datastructures;

import java.lang.IndexOutOfBoundsException;
class Node<T>{
    T data;
    Node<T> next;
    public Node(T val){
        this.data=val;
        this.next=null;
    }
}
public class LinkedList<T>{
    public Node<T> head=null;
    public LinkedList(){
        head=null;
    }
    public LinkedList(LinkedList<T> l2){
        // copy constructor
        if(l2.isEmpty())    return;

        Node<T> temp1=l2.head,temp2;
        
        temp2=new Node<T>(temp1.data);
        head=temp2;
        temp1=temp1.next;
        
        while(temp1!=null){
            temp2.next=new Node<T>(temp1.data);
            temp1=temp1.next;
            temp2=temp2.next;
        }
    }
    public boolean isEmpty(){
        return head==null;
    }
    
    public void insertBeg(T val){
        Node<T> temp=new Node<T>(val);
        temp.next=head;
        head=temp;
    }
    public void insertEnd(T val){
        Node<T> temp=head;
        if (isEmpty()){
            head=new Node<T>(val);
        }
        else{
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=new Node<T>(val);
        }

    }
    public void insertNth(int idx,T val){
        Node<T> temp;
        
        if (idx==0){
            temp=new Node<T>(val);
            temp.next=head;
            head=temp;
            return;
        }
    
        temp=head;
        while((temp!=null)&&(idx>1)){
            temp=temp.next;
            idx--;
        }
        if((temp==null)||(idx<1)){
            throw new IndexOutOfBoundsException("invalid index");
        }
        else{
            Node<T> newNode=new Node<T>(val);
            newNode.next=temp.next;
            temp.next=newNode;
        }
    

    }
    public T deleteEnd(){
        if(isEmpty())   throw new IndexOutOfBoundsException("can't delete from empty LinkedList");
        T val;
        Node<T> temp=head;
        if (temp.next==null){
            val=head.data;
            head=null;
        }
        else{
            while(temp.next.next!=null){
                temp=temp.next;
            }
            val=temp.next.data;
            temp.next=null;
        }
        return val;
    }
    public T deleteBeg(){
        if(isEmpty())   throw new IndexOutOfBoundsException("can't delete from empty LinkedList");
        T val;
        val=head.data;
        head=head.next;
        return val;
    }
    public T deleteNth(int idx){
        T val;
        Node<T> temp=head;
        
        if (idx==0){
            val=head.data;
            head=head.next;
            return val;
        }
        
        while(temp!=null && idx>1){
            temp=temp.next;
            idx--;
        }
        if( (temp==null) || (temp.next==null) || (idx<1) ){
            throw new IndexOutOfBoundsException("linked list is empty or invalid index");
        }
        else{
            val=temp.next.data;
            temp.next=temp.next.next;
            return val;
        }
        
    }
    public String toString(){
        String s="";
        Node<T> temp=head;
        if(!isEmpty()){
            
            while(temp.next!=null){
                s+=temp.data+"->";
                temp=temp.next;
            }
            s+=temp.data;
        }
        return s;
    }
    public void print(){
        System.out.println(this.toString());
    }

    public static void main(String args[]){
        LinkedList<Integer> l1=new LinkedList<Integer>();
        System.out.println(l1);
        l1.insertEnd(1);
        l1.insertEnd(2);
        l1.insertEnd(3);
        l1.insertEnd(4);
        System.out.println(l1);
        l1.insertBeg(0);
        System.out.println(l1);
        l1.deleteEnd();
        System.out.println(l1);
        // l1.deleteBeg();
        // l1.deleteBeg();
        // l1.deleteBeg();
        // l1.deleteEnd();
        // l1.deleteEnd();
        // l1.deleteEnd();
        // l1.deleteBeg();
        // l1.deleteBeg();
        System.out.println(l1);

        l1.insertNth(4,5);
        l1.insertNth(1,6);
        l1.insertNth(2,7);
        l1.insertNth(2,6);
        
        l1.insertNth(3,10);
        System.out.println(l1);
        System.out.println(l1.deleteNth(4)+" deleted.");
        System.out.println(l1);
        // LinkedList<Integer> l2=new LinkedList<Integer>(l1);
        // // l2.print();
        // l2.deleteEnd();
        // l2.deleteEnd();
        // l1.print();
        // l2.print();
        // System.out.println(l1.size()+","+l2.size());
    }
}
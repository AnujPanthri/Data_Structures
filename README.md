# Data Structures 

Implementing data stuctures using java.

## List of Implemented Data Stuctures and their methods:-
1. **LinkedList**
    - isEmpty() 
    - insertBeg(T val)
    - insertEnd(T val)
    - insertNth(int idx,T val)
    - deleteBeg()
    - deleteEnd()
    - deleteNth(int idx)
    - toString()
    - print()
2. **Stack**
    - isEmpty()
    - push()
    - pop()
    - peek()
    - toString()
    - print()
3. **Queue**
    - isEmpty()
    - enqueue(T val)
    - dequeue()
    - peek()
    - toString()
    - print()
4. **BinaryTree**
    - addNode(BinaryNode<T> node,boolean insertLeft)
    - preorder(BinaryNode<T> node)
    - postorder(BinaryNode<T> node)
    - inorder(BinaryNode<T> node)
    - preorder_traversal(BinaryNode<T> node) :- iterative approach
    - postorder_traversal(BinaryNode<T> node) :- iterative approach
    - inorder_traversal(BinaryNode<T> node) :- iterative approach


## Code example :-

```java
    import datastructures.*;
    class Demo{
        public static void main(String args[]){
            LinkedList<Integer> l1 = new LinkedList<Integer>();
            l1.insertEnd(1);
            l1.insertEnd(2);
            l1.insertEnd(3);
            l1.print();
        }
    }

```
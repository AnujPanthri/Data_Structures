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
    - createNode(T val)
    - addNode(BinaryNode<T> node,boolean insertLeft)
    - preorder(BinaryNode<T> node,boolean recursive)
    - postorder(BinaryNode<T> node,boolean recursive)
    - inorder(BinaryNode<T> node,boolean recursive)
    - getHeight()
    - printTree()
    - isFull()
    - isDegenerate()
    - isLeftSkewed()
    - isRightSkewed()
    
1. **BinarySearchTree**
    - insert(BinaryNode<Integer> root,Integer val)
    - search(int val)
    - delete(int val)

1. **AVLTree**
    - insert(Integer val)
    - search(int val)


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
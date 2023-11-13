package datastructures;

public class AVLTree extends BinaryTree<Integer>{
    /* 
        AVL Tree is a self balancing BST(Binary Search Tree).
    */ 
    public AVLTree(){
        super();
    }
    public void insert(int val){
        BinaryNode<Integer> temp=root;
        while(temp!=null){
            
            if(val<temp.data){
                if(temp.left==null){
                    temp.left=createNode(val);
                    break;
                }
                temp=temp.left;   // search in left subtree
            }
            else{
                if(temp.right==null){
                    temp.right=createNode(val);
                    break;
                }
                temp=temp.right;  // search in right subtree
            }
            
        }
        // if tree is empty
        if(temp==null){ 
            root=createNode(val);
            return;  
        }
        
        // after inserting checking if the tree is balanced

        Stack<BinaryNode<Integer>> s1=new Stack<BinaryNode<Integer>>();
        Stack<Integer> heights=new Stack<Integer>();    // stores left/right heights of subtrees
        BinaryNode<Integer> prev=null,parent;
        int leftheight,rightheight,currheight,currdepth;

        // postorder traversal (left, right, root)
        temp=root;
        while(!s1.isEmpty() || temp!=null){
            if(temp!=null){
                s1.push(temp);
                temp=temp.left;
            }
            else{
                temp=s1.peek();

                // if temp is a leaf node or we have explored the right subtrees and we are backtracking
                if(temp.right==null || temp.right==prev){
                    temp=s1.pop();
                    // main logic start
                    if(temp.right==null)
                        rightheight=0;
                    else
                        rightheight=heights.pop();
                    
                    if(temp.left==null)
                        leftheight=0;
                    else
                        leftheight=heights.pop();

                    currheight=Math.max(leftheight,rightheight);
                    currdepth=Math.abs(leftheight-rightheight);
                    heights.push(currheight+1);
                    
                    // if temp subtree needs to be balanced we can do it in O(1)
                    if(currdepth>1){
                        parent=root;
                        
                        if (!s1.isEmpty()){
                            if(s1.peek().left==temp || s1.peek().right==temp)
                                parent=s1.peek();
                        }
                            

                        if(leftheight>rightheight){
                            if(temp==root)
                                root=rightRotate(root); // modify the root itself
                            else if(parent.left==temp)
                                parent.left=rightRotate(temp);  // rotate subtree and assign to the parent's left
                            else
                                parent.right=rightRotate(temp);  // rotate subtree and assign to the parent's right
                        }
                        else{
                            if(temp==root)
                                root=leftRotate(root);   // modify the root itself
                            else if(parent.left==temp)
                                parent.left=leftRotate(temp);  // rotate subtree and assign to the parent's left
                            else
                                parent.right=leftRotate(temp);  // rotate subtree and assign to the parent's right
                        }
                        break;  // we should stop postorder traversal after we have done rebalancing
                    }

                    
                    // main logic end
                    prev=temp;
                    temp=null;
                }
                else{
                    temp=temp.right;
                }
            }
        }

        
    }
    public void delete(int val){

    }
    public static void main(String args[]) throws QueueException{
        AVLTree t1=new AVLTree();
        // t1.insert(5);
        // t1.insert(2);
        // t1.insert(8);
        // t1.insert(10);
        // t1.insert(15);
        // t1.insert(17);

        t1.insert(2);
        t1.printTree();
        t1.insert(4);
        t1.printTree();
        t1.insert(5);
        t1.printTree();
        // t1.insert(6);
        // t1.printTree();
    }
}

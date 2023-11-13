package datastructures;
import java.util.List;
import java.util.ArrayList;

// class BinaryNode<T>{
//     T data;
//     BinaryNode<T> left;
//     BinaryNode<T> right;
//     public BinaryNode(T val){
//         data=val;
//         left=null;
//         right=null;
//     }
// }
public class BinarySearchTree extends BinaryTree<Integer> {
    public BinarySearchTree(){
        super();
    }

    public BinaryNode<Integer> insert(BinaryNode<Integer> root,Integer val){
        if(root==null){
            return new BinaryNode<Integer>(val);
        }
        BinaryNode<Integer> temp=root;
        while(temp!=null){
            if(val < temp.data){
                if(temp.left==null){
                    temp.left=new BinaryNode<Integer>(val);
                    return temp.left;
                }
                else{
                    temp=temp.left;
                }
            }
            else{
                if(temp.right==null){
                    temp.right=new BinaryNode<Integer>(val);
                    return temp.right;
                }
                else{
                    temp=temp.right;
                }
            }
        }
        return temp;
    }

    public boolean search(int val){
        BinaryNode<Integer> curr=root;
        while(curr!=null && curr.data!=val){
            if(val<curr.data)
                curr=curr.left;
            else
                curr=curr.right;
        }
        return curr!=null;
    }
    
    public void delete(int val){
        BinaryNode<Integer> curr=root,prev=null,child=null;
        
        // search for node with node.data=val
        while(curr!=null && curr.data!=val){
            prev=curr;
            if(val<curr.data)
                curr=curr.left;
            else
                curr=curr.right;
        }

        // node not found
        if(curr==null){
            return;
        }

        // if node has one child or no child but not 2 childs
        if(!(curr.left!=null && curr.right!=null)){
            if(curr.left!=null)
                child=curr.left;
            else
                child=curr.right;
            
            if(prev==null){
                root=child;
                return;
            }

            else if(prev.left==curr){
                prev.left=child;
            }
            else
                prev.right=child;
        }

        // if node has 2 childs
        else{
            // traverse to right once and then to the left most node of the current node
            // to get the minimum value of the right sub tree of curr node

            // curr>prev>child
            prev=curr;
            child=curr.right;
            while(child.left!=null){
                prev=child;
                child=child.left;
            }

            // preserving the data of the node we are about to delete
            curr.data=child.data;

            // preserving the right subtree of the child node we are about to delete
            if(prev.left==child){
                prev.left=child.right;
            }
            else{
                prev.right=child.right;
            }
        }
    
        
    }

    public static void main(String args[]) throws QueueException{
        BinarySearchTree bt1=new BinarySearchTree();
        bt1.root=bt1.insert(bt1.root,50);
        bt1.insert(bt1.root,30);
        bt1.insert(bt1.root,20);
        bt1.insert(bt1.root,40);
        bt1.insert(bt1.root,70);
        bt1.insert(bt1.root,60);
        bt1.insert(bt1.root,80);
        
        bt1.print_list(bt1.preorder(bt1.root,true));
        bt1.print_list(bt1.postorder(bt1.root,true));
        bt1.print_list(bt1.inorder(bt1.root,true));
        
        // bt1.delete(35);
        // bt1.delete(50);
        bt1.print_list(bt1.inorder(bt1.root,true));
        
        bt1.printTree(bt1.root);
        
        bt1.root=bt1.rightRotate(bt1.root);
        bt1.printTree(bt1.root);

        bt1.root=bt1.rightRotate(bt1.root);
        bt1.printTree(bt1.root);
        

    }
}

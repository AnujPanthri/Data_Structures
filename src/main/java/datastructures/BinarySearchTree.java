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
    BinaryNode<Integer> root=null;
    public BinarySearchTree(){
        root=null;
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
    
    public void delete(int val){

    }

    public static void main(String args[]){
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
        
        // bt1.postorder(bt1.root);
        // System.out.println();
        // bt1.postorder_traversal(bt1.root);
        // System.out.println();
        // bt1.inorder(bt1.root);
        // System.out.println();
        // bt1.inorder_traversal(bt1.root);
        

    }
}

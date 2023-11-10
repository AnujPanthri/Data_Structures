package datastructures;
import java.util.List;
import java.util.ArrayList;

class BinaryNode<T>{
    T data;
    BinaryNode<T> left;
    BinaryNode<T> right;
    public BinaryNode(T val){
        data=val;
        left=null;
        right=null;
    }
}
public class BinaryTree<T> {
    BinaryNode<T> root=null;
    public BinaryTree(){
        root=null;
    }
    public BinaryNode<T> createNode(T val){
        return new BinaryNode<T>(val);
    }
    public void addNode(BinaryNode<T> temp,T val,boolean insertLeft){
        if(temp!=null){
            if(insertLeft)
                temp.left=new BinaryNode<T>(val);
            else
                temp.right=new BinaryNode<T>(val);
        }
    }
    public List<T> preorder(BinaryNode<T> temp,boolean recursive){
        List<T> out=new ArrayList<T>();
        if (recursive)
            preorder_recursive(temp,out);
        else
            preorder_iterative(temp,out);
        
        return out;
    }
    public void preorder_recursive(BinaryNode<T> temp,List<T> out){
        if (temp==null) return;
        out.add(temp.data);
        preorder_recursive(temp.left,out);
        preorder_recursive(temp.right,out);
    }
    public void preorder_iterative(BinaryNode<T> temp,List<T> out){
        // dfs implementation
        Stack<BinaryNode<T>> s1=new Stack<BinaryNode<T>>();
        BinaryNode<T> tempnode;
        s1.push(temp);
        while(!s1.isEmpty()){
            tempnode=s1.pop();
            out.add(tempnode.data);
            if(tempnode.right!=null){
                s1.push(tempnode.right);
            }
            if(tempnode.left!=null){
                s1.push(tempnode.left);
            }
        }
    }
    public List<T> postorder(BinaryNode<T> temp,boolean recursive){
        List<T> out=new ArrayList<T>();
        if (recursive)
            postorder_recursive(temp,out);
        else
            postorder_iterative(temp,out);
        
        return out;
    }
    public void postorder_recursive(BinaryNode<T> temp,List<T> out){
        if (temp==null) return ;
        postorder_recursive(temp.left,out);
        postorder_recursive(temp.right,out);
        out.add(temp.data);
    }

    public void postorder_iterative(BinaryNode<T> temp,List<T> out){
        // using 2 stacks
        Stack<BinaryNode<T>> s1 = new Stack<BinaryNode<T>>();
        Stack<BinaryNode<T>> s2 = new Stack<BinaryNode<T>>();
        BinaryNode<T> node;
        node=temp;
        while((node!=null)||!s1.isEmpty()){
            if(node!=null){
                s1.push(node);
                node=node.left;
            }
            else{
                
                node=s1.pop();
                if(node.right==null){// leaf node only
                    out.add(node.data); 
                    
                    if(!s2.isEmpty() && s2.peek().right==node){
                        while(!s2.isEmpty()){
                            out.add(s2.pop().data);
                        }
                    }
                }
                else{   // intermediate nodes
                    s2.push(node);
                }
                
                node=node.right;
            
            }
            
        
        }
    }
    public List<T> inorder(BinaryNode<T> temp,boolean recursive){
        List<T> out=new ArrayList<T>();
        if (recursive)
            inorder_recursive(temp,out);
        else
            inorder_iterative(temp,out);
        
        return out;
    }
    public void inorder_recursive(BinaryNode<T> temp,List<T> out){
        if (temp==null) return;
        inorder_recursive(temp.left,out);
        out.add(temp.data);
        inorder_recursive(temp.right,out);
    }

    public void inorder_iterative(BinaryNode<T> temp,List<T> out){
        Stack<BinaryNode<T>> s1 = new Stack<BinaryNode<T>>();
        BinaryNode<T> node;
        node=temp;
        while((node!=null) || !s1.isEmpty() ){
            if(node!=null){
                s1.push(node);
                node=node.left;
            }
            else{
                node=s1.pop();
                out.add(node.data);
                node=node.right;
            }
        }
    }

    public void print_list(List<Integer> l1){
        
        for(int val :l1){
            System.out.print(val+",");
        }
        System.out.println();
    }
    
    public List<T> dfs(BinaryNode<T> temp){
        return preorder(temp, true);
    }
    public List<T> bfs(BinaryNode<T> temp) throws QueueException{
        // breath first search
        BinaryNode<T> node;
        List<T> out=new ArrayList<T>();
        Queue<BinaryNode<T>> q1=new Queue<BinaryNode<T>>();
        q1.enqueue(temp);

        while(!q1.isEmpty()){
            node=q1.dequeue();
            out.add(node.data);
            if(node.left!=null)
                q1.enqueue(node.left);
            if(node.right!=null)
                q1.enqueue(node.right);
        }

        return out;
    }
    public static void main(String args[]){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        bt1.root=new BinaryNode<Integer>(1);
        bt1.addNode(bt1.root,2,true);
        bt1.addNode(bt1.root,3,false);
        bt1.addNode(bt1.root.left,4,true);
        bt1.addNode(bt1.root.left,5,false);

        // bt1.preorder(bt1.root,true);
        // System.out.println();
        // bt1.preorder_traversal(bt1.root);
        // System.out.println();
        // bt1.postorder(bt1.root);
        // System.out.println();
        // bt1.postorder_traversal(bt1.root);
        // System.out.println();
        // bt1.inorder(bt1.root);
        // System.out.println();
        // bt1.inorder_traversal(bt1.root);
        

    }
}

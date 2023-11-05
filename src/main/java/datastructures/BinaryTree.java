package datastructures;

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
    public void addNode(BinaryNode<T> temp,T val,boolean insertLeft){
        if(temp!=null){
            if(insertLeft)
                temp.left=new BinaryNode<T>(val);
            else
                temp.right=new BinaryNode<T>(val);
        }
    }
    public void preorder(BinaryNode<T> temp){
        if (temp==null) return;
        System.out.print(temp.data+",");
        preorder(temp.left);
        preorder(temp.right);
    }
    public void preorder_traversal(BinaryNode<T> temp){
        // dfs implementation
        Stack<BinaryNode<T>> s1=new Stack<BinaryNode<T>>();
        BinaryNode<T> tempnode;
        s1.push(temp);
        while(!s1.isEmpty()){
            tempnode=s1.pop();
            System.out.print(tempnode.data+",");
            if(tempnode.right!=null){
                s1.push(tempnode.right);
            }
            if(tempnode.left!=null){
                s1.push(tempnode.left);
            }
        }
    }
    public void postorder(BinaryNode<T> temp){
        if (temp==null) return;
        postorder(temp.left);
        postorder(temp.right);
        System.out.print(temp.data+",");
    }
    public void postorder_traversal(BinaryNode<T> temp){
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
                s2.push(node);
                node=node.right;
                if(node==null){
                    while(!s2.isEmpty()){
                        System.out.print(s2.pop().data+",");
                    }
                }   
            }
        }
    }
    public void inorder(BinaryNode<T> temp){
        if (temp==null) return;
        inorder(temp.left);
        System.out.print(temp.data+",");
        inorder(temp.right);
    }
    public void inorder_traversal(BinaryNode<T> temp){
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
                System.out.print(node.data+",");
                node=node.right;
            }
        }
    }

    public static void main(String args[]){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        bt1.root=new BinaryNode<Integer>(1);
        bt1.addNode(bt1.root,2,true);
        bt1.addNode(bt1.root,3,false);
        bt1.addNode(bt1.root.left,4,true);
        bt1.addNode(bt1.root.left,5,false);

        bt1.preorder(bt1.root);
        System.out.println();
        bt1.preorder_traversal(bt1.root);
        System.out.println();
        bt1.postorder(bt1.root);
        System.out.println();
        bt1.postorder_traversal(bt1.root);
        System.out.println();
        bt1.inorder(bt1.root);
        System.out.println();
        bt1.inorder_traversal(bt1.root);
        

    }
}

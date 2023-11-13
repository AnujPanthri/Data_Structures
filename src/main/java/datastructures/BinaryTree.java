package datastructures;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

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
        
        if(temp!=null) 
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
        BinaryNode<T> node,prev=null;
        node=temp;
        while((node!=null)||!s1.isEmpty()){
            if(node!=null){
                s1.push(node);
                node=node.left;
            }
            else{
                
                node=s1.peek();
                if(node.right==null || node.right==prev){
                    /* leaf node or node.right==last
                     
                          node
                            \
                            last
                    */
                    node=s1.pop(); 
                    
                    out.add(node.data);


                    prev=node;
                    node=null;
                }
                else{   
                    node=node.right;
                }      
            
            }
            
        
        }
    }
    // public void postorder_iterative(BinaryNode<T> temp,List<T> out){
    //     // using 2 stacks
    //     Stack<BinaryNode<T>> s1 = new Stack<BinaryNode<T>>();
    //     Stack<BinaryNode<T>> s2 = new Stack<BinaryNode<T>>();
    //     BinaryNode<T> node;
    //     node=temp;
    //     while((node!=null)||!s1.isEmpty()){
    //         if(node!=null){
    //             s1.push(node);
    //             node=node.left;
    //         }
    //         else{
                
    //             node=s1.pop();
    //             if(node.right==null){// leaf node only
    //                 out.add(node.data); 
                    
    //                 if(!s2.isEmpty() && s2.peek().right==node){
    //                     while(!s2.isEmpty()){
    //                         out.add(s2.pop().data);
    //                     }
    //                 }
    //             }
    //             else{   // intermediate nodes
    //                 s2.push(node);
    //             }
                
    //             node=node.right;
            
    //         }
            
        
    //     }
    // }

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
    
    public List<T> dfs(){return dfs(root);}
    public List<T> dfs(BinaryNode<T> temp){
        return preorder(temp, false);
    }

    public List<T> bfs() throws QueueException{return bfs(root);}
    public List<T> bfs(BinaryNode<T> temp) throws QueueException{
        // breath first search
        BinaryNode<T> node;
        List<T> out=new ArrayList<T>();
        Queue<BinaryNode<T>> q1=new Queue<BinaryNode<T>>();
        if(temp!=null)
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
    // public int Max(int a,int b){
    //     if(a>b) return a;
    //     else    return b;
    // }
    
    public int getHeight(){return getHeight(root);}
    public int getHeight(BinaryNode<T> root){
        if (root==null)
        return 0;
        return 1+Math.max(this.getHeight(root.left),this.getHeight(root.right));
    }
    
    public int getHeightIterative(){return getHeightIterative(root);}
    public int getHeightIterative(BinaryNode<T> root){
        int currheight=0,maxheight=0;
        BinaryNode<T> curr=null;
        Stack<BinaryNode<T>> s1=new Stack<BinaryNode<T>>();
        
        // dfs or preorder traversal
        if(root!=null)
            s1.push(root);
        while(!s1.isEmpty()){
            curr=s1.pop();
            currheight+=1;

            if(currheight>maxheight) maxheight=currheight;
            
            // decrease height by one if backtracking
            if(curr.left==null && curr.right==null) currheight-=1;

            if(curr.right!=null) s1.push(curr.right);
            if(curr.left!=null) s1.push(curr.left);

            
        }
        return maxheight;
    }
    public void printTree() throws QueueException{ printTree(root);}
    public void printTree(BinaryNode<T> root) throws QueueException{
        BinaryNode<T> curr;
        Queue<BinaryNode<T>> q1=new Queue<BinaryNode<T>>();
        List<T> bfs_list=new ArrayList<T>();
        int height=getHeight(root);
        int num_of_nodes=(int)Math.pow(2.0,(double)height)-1;
        int curr_node_num=0;
        if(root!=null)
            q1.enqueue(root);
        while(!q1.isEmpty() && curr_node_num<num_of_nodes){
            curr=q1.dequeue();
            curr_node_num+=1;
            if(curr==null){
                bfs_list.add(null);
                q1.enqueue(null);
                q1.enqueue(null);
            }
            else{
                bfs_list.add(curr.data);
                q1.enqueue(curr.left);
                q1.enqueue(curr.right);
            }       
        }
        System.out.println();
        
        int curr_level=0;
        for(int i=0;i<bfs_list.size();i++){
            if(i==(int)Math.pow(2.0,(double)curr_level)-1){
                System.out.println();
                for(int j=0;j<(int)(Math.pow(2.0,(double)height-curr_level)/2-1);j++)
                    System.out.print(" ");
                
                curr_level+=1;
            }
            if(bfs_list.get(i)!=null)
                System.out.print(bfs_list.get(i));
            else
                System.out.print("-");
            for(int j=0;j<(int)(Math.pow(2.0,(double)height-curr_level+2)/2-1);j++)
                System.out.print(" ");   
            
        }
    }
    
    public boolean isFull(){return isFull(root);}
    public boolean isFull(BinaryNode<T> root){
        /* A full binary tree in which each node
            has either 2 children or no childs.
            
            No node should have only one child
        */
        Stack<BinaryNode<T>> s1=new Stack<BinaryNode<T>>();
        BinaryNode<T> temp;
        if(root!=null)
            s1.push(root);
        while(!s1.isEmpty()){
            temp=s1.pop();
            
            // return false if temp has only one child 
            if(temp.left!=null ^ temp.right!=null)
                return false;

            if(temp.right!=null)
                s1.push(temp.right);
            if(temp.left!=null)
                s1.push(temp.left);
        }
        return true;
    }
    public boolean isDegenerate(){return isDegenerate(root);}
    public boolean isDegenerate(BinaryNode<T> root){
    // A binary tree is Degenerate tree if every node has only one child or no child
        BinaryNode<T> temp=root;
        while(temp!=null){
            if(temp.left!=null){    // if left child exists
                if(temp.right!=null)    // but right child also exists
                    return false;
                temp=temp.left;
            }
            else if(temp.right!=null){    // if right child exists
                if(temp.left!=null)    // but left child also exists
                    return false;
                temp=temp.right;
            }
            else    // temp is a leaf node
                break;
        }
        return true;
    }
    public boolean isLeftSkewed(){return isSkewed(root,true);}
    public boolean isRightSkewed(){return isSkewed(root,false);}
    public boolean isSkewed(boolean check_left){return isSkewed(root,check_left);}
    public boolean isLeftSkewed(BinaryNode<T> root){return isSkewed(root,true);}
    public boolean isRightSkewed(BinaryNode<T> root){return isSkewed(root,false);}
    public boolean isSkewed(BinaryNode<T> root,boolean check_left){
        // an degenerate tree which is either only left skewed or right skewed
        BinaryNode<T> temp=root;
        while(temp!=null){
            
            if(temp.left!=null){    // if left child exists
                if(!check_left)  return false;   // if we were checking for right skewed
                if(temp.right!=null)    // but right child also exists
                    return false;
                temp=temp.left;
            }
            else if(temp.right!=null){    // if right child exists
                if(check_left)  return false;   // if we were checking for left skewed
                if(temp.left!=null)    // but left child also exists
                    return false;
                temp=temp.right;
            }
            else    // temp is a leaf node
                break;
        }

        return true;
    }
    
    public boolean isBalanced(){ return isBalanced(root);}
    public boolean isBalanced(BinaryNode<T> root){
        // using 2 stacks
        Stack<BinaryNode<T>> s1 = new Stack<BinaryNode<T>>();
        Stack<Integer> heights = new Stack<Integer>();   // for storing left/right subtree heights
        BinaryNode<T> temp,prev=null;
        int leftheight=0,rightheight=0,currheight=0,currdepth=0;
	    
        temp=root;

        // postorder traversal (left,right,root) 
        while(!s1.isEmpty() || temp!=null){
            if(temp!=null){
                s1.push(temp);
                temp=temp.left;
            }
            else{
                temp=s1.peek();
                
                // if temp is a leaf node or we are backtracking 
                if(temp.right==null || temp.right==prev){
                    temp=s1.pop();
                    //  write core logic begin
                    
                    // order matters! we need to first pop rightheight then leftheight 
                    // cuz we are inserted in leftheight then rightheight in a stack
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

                    // System.out.print("\nnode:"+temp.data
                    //     +"\tleftheight,rightheight: "+leftheight+","+rightheight
                    //     +"\tcurrdepth: "+currdepth);
                    
                    if(currdepth>1) return false;

                    heights.push(currheight+1);  // currheight+1 will be the left/right height for the parent node
                    // write core logic end
                    prev=temp;
                    temp=null;
                }
                else{
                    temp=temp.right;
                }
            }   
        }
        return true;
    }

    public BinaryNode<T> rightRotate(BinaryNode<T> root){
        BinaryNode<T> leftchild;
        if(root==null)  return root;
        leftchild=root.left;
        if(leftchild==null) return root;    // rotation not possible

        root.left=leftchild.right;  // leftchild's right subtree is always smaller than root
        leftchild.right=root;   // root is larger than its previously called left child
        
        return leftchild;
    }

    public BinaryNode<T> leftRotate(BinaryNode<T> root){
        BinaryNode<T> rightchild;
        if(root==null)  return root;
        rightchild=root.right;
        if(rightchild==null) return root;    // rotation not possible

        root.right=rightchild.left;  // rightchild's left subtree is always larger than root
        rightchild.left=root;   // root is smaller than its previously called right child
        
        return rightchild;
    }
    public static void main(String args[]) throws QueueException{
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        bt1.root=new BinaryNode<Integer>(1);
        bt1.root.left=bt1.createNode(2);
        bt1.root.right=bt1.createNode(3);
        bt1.root.left.left=bt1.createNode(4);
        // bt1.root.left.right=bt1.createNode(5);
        
        bt1.root.left.right=bt1.createNode(5);
          
        bt1.printTree(bt1.root);
        System.out.println("\n");
        bt1.print_list(bt1.preorder(bt1.root,true));
        bt1.print_list(bt1.postorder(bt1.root,true));
        bt1.print_list(bt1.inorder(bt1.root,true));
        // System.out.println("Height:"+bt1.getHeight(bt1.root));
        // System.out.println("Height:"+bt1.getHeightIterative(bt1.root));
        
        bt1.printTree(bt1.root);
        bt1.root=bt1.rightRotate(bt1.root);
        bt1.printTree(bt1.root);
        bt1.root=bt1.rightRotate(bt1.root);

        bt1.root.left=bt1.createNode(7);
        bt1.root.left.right=bt1.createNode(8);
        // bt1.root.left.left=bt1.createNode(6);
        // bt1.root.left.right.right=bt1.createNode(9);
        bt1.root.right.right.right=null;
        bt1.printTree(bt1.root);

        // bt1.root=bt1.leftRotation(bt1.root);
        // bt1.printTree();
        // bt1.root=bt1.leftRotation(bt1.root);
        // bt1.printTree();

        
        System.out.println();
        // bt1.isBalanced(bt1.root);
    }
}

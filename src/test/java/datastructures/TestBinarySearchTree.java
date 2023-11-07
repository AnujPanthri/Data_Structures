package datastructures;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestBinarySearchTree {
    
    @Test
    public void testinsert(){
        BinarySearchTree bt1=new BinarySearchTree();
        bt1.root=bt1.insert(bt1.root,50);
        bt1.insert(bt1.root,30);
        bt1.insert(bt1.root,20);
        bt1.insert(bt1.root,40);
        bt1.insert(bt1.root,70);
        bt1.insert(bt1.root,60);
        bt1.insert(bt1.root,80);

        /*
                        50
                     /     \
                  /           \ 
                30              70
              /    \          /    \
            20      40      60      80
        */
        
        List<Integer> pre=new ArrayList<Integer>(List.of(50,30,20,40,70,60,80));   // preorder
        List<Integer> post=new ArrayList<Integer>(List.of(20,40,30,60,80,70,50));   // postorder
        List<Integer> in=new ArrayList<Integer>(List.of(20,30,40,50,60,70,80));   // inorder
        
        Assert.assertArrayEquals(pre.toArray(),bt1.preorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(post.toArray(),bt1.postorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
    }    

    @Test
    public void testinsert2(){
        BinarySearchTree bt1=new BinarySearchTree();
        bt1.root=bt1.insert(bt1.root,8);
        bt1.insert(bt1.root,3);
        bt1.insert(bt1.root,10);
        bt1.insert(bt1.root,14);
        bt1.insert(bt1.root,13);
        bt1.insert(bt1.root,1);
        bt1.insert(bt1.root,6);
        bt1.insert(bt1.root,4);
        bt1.insert(bt1.root,7);


        /*
                        8
                      /   \
                    3      10 
                   / \       \
                  1   6       14
                     / \      /
                    4   7   13
        */
        
        List<Integer> pre=new ArrayList<Integer>(List.of(8,3,1,6,4,7,10,14,13));   // preorder
        List<Integer> post=new ArrayList<Integer>(List.of(1,4,7,6,3,13,14,10,8));   // postorder
        List<Integer> in=new ArrayList<Integer>(List.of(1,3,4,6,7,8,10,13,14));   // inorder
        
        Assert.assertArrayEquals(pre.toArray(),bt1.preorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(post.toArray(),bt1.postorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
    }    
}

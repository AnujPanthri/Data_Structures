package datastructures;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestBinarySearchTree {
    
    public BinarySearchTree get_bst2(){
      BinarySearchTree bst= new BinarySearchTree();
      
      bst.root=bst.insert(bst.root,8);
      bst.insert(bst.root,3);
      bst.insert(bst.root,10);
      bst.insert(bst.root,14);
      bst.insert(bst.root,13);
      bst.insert(bst.root,1);
      bst.insert(bst.root,6);
      bst.insert(bst.root,4);
      bst.insert(bst.root,7);


      /*
                      8
                    /   \
                  3      10 
                  / \       \
                1   6       14
                    / \      /
                  4   7   13
      */
      return bst;
    }
    
    public BinarySearchTree get_bst1(){
        BinarySearchTree bst=new BinarySearchTree();
        bst.root=bst.insert(bst.root,50);
        bst.insert(bst.root,30);
        bst.insert(bst.root,20);
        bst.insert(bst.root,40);
        bst.insert(bst.root,70);
        bst.insert(bst.root,60);
        bst.insert(bst.root,80);

        /*
                        50
                     /     \
                  /           \ 
                30              70
              /    \          /    \
            20      40      60      80
        */
        return bst;
    }
        
    public void testinsert(){
        BinarySearchTree bt1=get_bst1();

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
        BinarySearchTree bt1=get_bst2();

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
    
    @Test
    public void search(){
      BinarySearchTree bt1 = get_bst2();
      /*
                      8
                    /   \
                   3      10 
                  / \       \
                 1   6       14
                    / \      /
                   4   7   13
      */
      
      Assert.assertEquals(true, bt1.search(8));
      Assert.assertEquals(true, bt1.search(3));
      Assert.assertEquals(true, bt1.search(14));
      Assert.assertEquals(true, bt1.search(1));
      Assert.assertEquals(true, bt1.search(6));
      Assert.assertEquals(true, bt1.search(4));
      Assert.assertEquals(true, bt1.search(7));
      Assert.assertEquals(true, bt1.search(13));
      Assert.assertEquals(false, bt1.search(15));
      Assert.assertEquals(false, bt1.search(-1));
      Assert.assertEquals(false, bt1.search(9));
    }

    @Test 
    public void testdelete(){
      BinarySearchTree bt1 = get_bst2();
      /*
                      8
                    /   \
                   3      10 
                  / \       \
                 1   6       14
                    / \      /
                   4   7   13
      */
      
      bt1.delete(6);
      List<Integer> in=new ArrayList<Integer>(List.of(1,3,4,7,8,10,13,14));   // inorder
      Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
      
      // deleting middle element
      bt1=get_bst2();
      bt1.delete(3);
      in=new ArrayList<Integer>(List.of(1,4,6,7,8,10,13,14));   // inorder
      Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
      
      // deleting middle element
      bt1=get_bst2();
      bt1.delete(10);
      in=new ArrayList<Integer>(List.of(1,3,4,6,7,8,13,14));   // inorder
      Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
      
      // deleting root element
      bt1=get_bst2();
      bt1.delete(8);
      in=new ArrayList<Integer>(List.of(1,3,4,6,7,10,13,14));   // inorder
      Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
      
      // deleting last element
      bt1=get_bst2();
      bt1.delete(1);
      in=new ArrayList<Integer>(List.of(3,4,6,7,8,10,13,14));   // inorder
      Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
      
      // deleting last element
      bt1=get_bst2();
      bt1.delete(4);
      in=new ArrayList<Integer>(List.of(1,3,6,7,8,10,13,14));   // inorder
      Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
      
      // deleting last element
      bt1=get_bst2();
      bt1.delete(7);
      in=new ArrayList<Integer>(List.of(1,3,4,6,8,10,13,14));   // inorder
      Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
      
      // deleting last element
      bt1=get_bst2();
      bt1.delete(14);
      in=new ArrayList<Integer>(List.of(1,3,4,6,7,8,10,13));   // inorder
      bt1.print_list(bt1.inorder(bt1.root,true));
      Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
    }
    @Test 
    public void testdelete2(){
      BinarySearchTree bt1 = new BinarySearchTree();
      bt1.delete(1);
      List<Integer> in=new ArrayList<Integer>(List.of());   // inorder
      // bt1.print_list(bt1.inorder(bt1.root,true));
      Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
      
      bt1.root=bt1.insert(bt1.root, 1);
      bt1.delete(1);
      in=new ArrayList<Integer>(List.of());   // inorder
      Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
     
    }
}

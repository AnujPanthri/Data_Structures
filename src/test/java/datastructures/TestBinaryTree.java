package datastructures;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestBinaryTree {
    
    @Test
    public void testaddNode(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        bt1.root=new BinaryNode<Integer>(1);
        bt1.addNode(bt1.root, 2, true);
        bt1.addNode(bt1.root, 3, false);

        Assert.assertEquals((Integer)(1), bt1.root.data);
        Assert.assertEquals((Integer)(2), bt1.root.left.data);
        Assert.assertEquals((Integer)(3), bt1.root.right.data);
    }  
    
    @Test
    public void testpreorder(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        
        List<Integer> result=new ArrayList<Integer>(List.of());   // dfs
        Assert.assertArrayEquals(result.toArray(),bt1.preorder(bt1.root,false).toArray());
        
        bt1.root=new BinaryNode<Integer>(1);
        bt1.addNode(bt1.root, 2, true);
        bt1.addNode(bt1.root.left, 3, true);
        bt1.addNode(bt1.root.left, 4, false);
        bt1.addNode(bt1.root.left.right, 5, true);
        bt1.addNode(bt1.root.left.right, 6, false);
        
        result=new ArrayList<Integer>(List.of(1,2,3,4,5,6));
        // List<Integer> result=new ArrayList<Integer>(List.of(3,5,6,4,2,1));   // postorder
        
        Assert.assertArrayEquals(result.toArray(),bt1.preorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(result.toArray(),bt1.preorder(bt1.root, false).toArray());
    }
    
    @Test
    public void testpostorder(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();

        List<Integer> result=new ArrayList<Integer>(List.of());   // dfs
        Assert.assertArrayEquals(result.toArray(),bt1.postorder(bt1.root,false).toArray());

        bt1.root=new BinaryNode<Integer>(1);
        bt1.addNode(bt1.root, 2, true);
        bt1.addNode(bt1.root.left, 3, true);
        bt1.addNode(bt1.root.left, 4, false);
        bt1.addNode(bt1.root.left.right, 5, true);
        bt1.addNode(bt1.root.left.right, 6, false);
        
        result=new ArrayList<Integer>(List.of(3,5,6,4,2,1));   // postorder
        
        // Assert.assertArrayEquals(result.toArray(),result.toArray());
        Assert.assertArrayEquals(result.toArray(),bt1.postorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(result.toArray(),bt1.postorder(bt1.root, false).toArray());
    }
    
    @Test
    public void testpostorder2(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        bt1.root=new BinaryNode<Integer>(1);
        bt1.addNode(bt1.root, 2, true);
        bt1.addNode(bt1.root, 3, false);
        bt1.addNode(bt1.root.left, 4, true);
        bt1.addNode(bt1.root.left, 5, false);
        bt1.addNode(bt1.root.right, 6, true);
        bt1.addNode(bt1.root.right, 7, false);
        
        List<Integer> result=new ArrayList<Integer>(List.of(4,5,2,6,7,3,1));   // postorder
        
        Assert.assertArrayEquals(result.toArray(),result.toArray());
        Assert.assertArrayEquals(result.toArray(),bt1.postorder(bt1.root, true).toArray());
        
        Assert.assertArrayEquals(result.toArray(),bt1.postorder(bt1.root, false).toArray());
    }
    
    @Test
    public void testinorder(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        
        List<Integer> result=new ArrayList<Integer>(List.of());   // dfs
        Assert.assertArrayEquals(result.toArray(),bt1.inorder(bt1.root,false).toArray());

        bt1.root=new BinaryNode<Integer>(1);
        bt1.addNode(bt1.root, 2, true);
        bt1.addNode(bt1.root.left, 3, true);
        bt1.addNode(bt1.root.left, 4, false);
        bt1.addNode(bt1.root.left.right, 5, true);
        bt1.addNode(bt1.root.left.right, 6, false);
        
        result=new ArrayList<Integer>(List.of(3,2,5,4,6,1));   // inorder
        
        Assert.assertArrayEquals(result.toArray(),result.toArray());
        Assert.assertArrayEquals(result.toArray(),bt1.inorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(result.toArray(),bt1.inorder(bt1.root, false).toArray());
    }

    @Test
    public void testbfs() throws QueueException{
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        
        List<Integer> result=new ArrayList<Integer>(List.of());   // dfs
        Assert.assertArrayEquals(result.toArray(),bt1.bfs(bt1.root).toArray());

        bt1.root=new BinaryNode<Integer>(1);

        bt1.root.left=bt1.createNode(2);
        bt1.root.right=bt1.createNode(3);

        bt1.root.left.left=bt1.createNode(4);
        bt1.root.left.right=bt1.createNode(5);
        bt1.root.right.left=bt1.createNode(6);
        bt1.root.right.right=bt1.createNode(7);
        
        result=new ArrayList<Integer>(List.of(1,2,3,4,5,6,7));   // bfs
        bt1.print_list(bt1.bfs(bt1.root));
        Assert.assertArrayEquals(result.toArray(),bt1.bfs(bt1.root).toArray());
    }
    
    @Test
    public void testdfs(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        
        List<Integer> result=new ArrayList<Integer>(List.of());   // dfs
        Assert.assertArrayEquals(result.toArray(),bt1.dfs(bt1.root).toArray());
        
        bt1.root=new BinaryNode<Integer>(1);

        bt1.root.left=bt1.createNode(2);
        bt1.root.right=bt1.createNode(3);

        bt1.root.left.left=bt1.createNode(4);
        bt1.root.left.right=bt1.createNode(5);
        bt1.root.right.left=bt1.createNode(6);
        bt1.root.right.right=bt1.createNode(7);
        
        result=new ArrayList<Integer>(List.of(1,2,4,5,3,6,7));   // dfs
        Assert.assertArrayEquals(result.toArray(),bt1.dfs(bt1.root).toArray());
    }

    @Test
    public void testisFull() throws QueueException{
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        bt1.root=bt1.createNode(20);
        bt1.root.right=bt1.createNode(50);
        bt1.root.left=bt1.createNode(10);
        
        Assert.assertEquals(true, bt1.isFull(bt1.root));
        bt1.root.left.left=bt1.createNode(5);
        Assert.assertEquals(false, bt1.isFull(bt1.root));
        
        bt1.root.left.right=bt1.createNode(15);
        /*
               20       
            10   50   
            5 15 - - 
         */
        
        Assert.assertEquals(true, bt1.isFull(bt1.root));
    }
    @Test
    public void testisDegenerate(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        bt1.root=bt1.createNode(20);
        bt1.root.right=bt1.createNode(50);
        Assert.assertEquals(true, bt1.isDegenerate(bt1.root));
        bt1.root.left=bt1.createNode(10);
        Assert.assertEquals(false, bt1.isDegenerate(bt1.root));
        
    }
    @Test
    public void testisDegenerate2(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        Assert.assertEquals(true, bt1.isDegenerate(bt1.root));
        bt1.root=bt1.createNode(10);
        Assert.assertEquals(true, bt1.isDegenerate(bt1.root));
        bt1.root.left=bt1.createNode(20);
        Assert.assertEquals(true, bt1.isDegenerate(bt1.root));
        bt1.root.left.right=bt1.createNode(30);
        Assert.assertEquals(true, bt1.isDegenerate(bt1.root));
        bt1.root.left.right.right=bt1.createNode(40);
        Assert.assertEquals(true, bt1.isDegenerate(bt1.root));
        
        bt1.root.right=bt1.createNode(10);
        Assert.assertEquals(false, bt1.isDegenerate(bt1.root));
        
    }

    @Test
    public void testisLeftSkewed(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        Assert.assertEquals(true, bt1.isLeftSkewed());
        
        bt1.root=bt1.createNode(10);
        Assert.assertEquals(true, bt1.isLeftSkewed());
        
        bt1.root.left=bt1.createNode(20);
        Assert.assertEquals(true, bt1.isLeftSkewed());
        
        bt1.root.left.left=bt1.createNode(30);
        Assert.assertEquals(true, bt1.isLeftSkewed());
        
        bt1.root.left.left.left=bt1.createNode(40);
        Assert.assertEquals(true, bt1.isLeftSkewed());

        bt1.root.left.right=bt1.createNode(10);
        Assert.assertEquals(false, bt1.isLeftSkewed());
        
        bt1.root.left.right.left=bt1.createNode(10);
        Assert.assertEquals(false, bt1.isLeftSkewed());
        
    }

    @Test
    public void testisRightSkewed(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        Assert.assertEquals(true, bt1.isRightSkewed());
        
        bt1.root=bt1.createNode(10);
        Assert.assertEquals(true, bt1.isRightSkewed());
        
        bt1.root.right=bt1.createNode(20);
        Assert.assertEquals(true, bt1.isRightSkewed());
        
        bt1.root.right.right=bt1.createNode(30);
        Assert.assertEquals(true, bt1.isRightSkewed());
        
        bt1.root.right.right.right=bt1.createNode(40);
        Assert.assertEquals(true, bt1.isRightSkewed());

        bt1.root.right.left=bt1.createNode(10);
        Assert.assertEquals(false, bt1.isRightSkewed());
        
        bt1.root.right.left.right=bt1.createNode(10);
        Assert.assertEquals(false, bt1.isRightSkewed());
        
    }

    @Test 
    public void testrightRotate() throws QueueException{
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        
        bt1.root=new BinaryNode<Integer>(1);
        bt1.addNode(bt1.root, 2, true);
        bt1.addNode(bt1.root.left, 3, true);
        bt1.addNode(bt1.root.left, 4, false);
        bt1.addNode(bt1.root.left.right, 5, true);
        bt1.addNode(bt1.root.left.right, 6, false);
        
        /*
                   1               
               2       -       
             3   4   -   -   
            - - 5 6 - - - - 
        */

        List<Integer> pre=new ArrayList<Integer>(List.of(1,2,3,4,5,6));   // preorder
        List<Integer> post=new ArrayList<Integer>(List.of(3,5,6,4,2,1));   // postorder
        List<Integer> in=new ArrayList<Integer>(List.of(3,2,5,4,6,1));   // inorder
        
        Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(pre.toArray(),bt1.preorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(post.toArray(),bt1.postorder(bt1.root, true).toArray());

        bt1.root=bt1.rightRotate(bt1.root);
        /*
                   2               
               3       1       
             -   -   4   -   
            - - - - 5 6 - - 
        */

        pre=new ArrayList<Integer>(List.of(2,3,1,4,5,6));   // preorder

        Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(pre.toArray(),bt1.preorder(bt1.root, true).toArray());
        
        bt1.root.right=bt1.rightRotate(bt1.root.right);
        /*
                   2               
               3       4       
             -   -   5   1   
            - - - - - - 6 - 
        */

        pre=new ArrayList<Integer>(List.of(2,3,4,5,1,6));   // preorder

        Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(pre.toArray(),bt1.preorder(bt1.root, true).toArray());


        
    }
    @Test
    public void testleftRotate(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        
        bt1.root=new BinaryNode<Integer>(1);
        bt1.root.left=bt1.createNode(7);
        bt1.root.right=bt1.createNode(2);
        bt1.root.right.left=bt1.createNode(4);
        bt1.root.right.right=bt1.createNode(5);
        bt1.root.right.left.right=bt1.createNode(3);
        
        /*
                   1               
               7       2       
             -   -   4   5   
            - - - - - 3 - - 
        */

        List<Integer> pre=new ArrayList<Integer>(List.of(1,7,2,4,3,5));   // preorder
        List<Integer> post=new ArrayList<Integer>(List.of(7,3,4,5,2,1));   // postorder
        List<Integer> in=new ArrayList<Integer>(List.of(7,1,4,3,2,5));   // inorder
        
        Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(pre.toArray(),bt1.preorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(post.toArray(),bt1.postorder(bt1.root, true).toArray());

        bt1.root=bt1.leftRotate(bt1.root);
        /*
                   2               
               1       5       
             7   4   -   -   
            - - - 3 - - - - 
        */

        pre=new ArrayList<Integer>(List.of(2,1,7,4,3,5));   // preorder

        Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(pre.toArray(),bt1.preorder(bt1.root, true).toArray());
        
        bt1.root.left=bt1.leftRotate(bt1.root.left);
        /*
                   2               
               4       5       
             1   3   -   -   
            7 - - - - - - - 
        */

        pre=new ArrayList<Integer>(List.of(2,4,1,7,3,5));   // preorder

        Assert.assertArrayEquals(in.toArray(),bt1.inorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(pre.toArray(),bt1.preorder(bt1.root, true).toArray());


    }

    @Test
    public void testisBalanced() throws QueueException{

        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        bt1.root=new BinaryNode<Integer>(1);
        bt1.root.left=bt1.createNode(2);
        bt1.root.right=bt1.createNode(3);
        bt1.root.left.left=bt1.createNode(4);
        bt1.root.left.right=bt1.createNode(5);
        /*
               1
             2   3
            4 5 - -
        */
        Assert.assertEquals(true, bt1.isBalanced(bt1.root));
        
        bt1.root=bt1.createNode(2);
        bt1.root.left=bt1.createNode(4);
        bt1.root.right=bt1.createNode(1);
        bt1.root.right.left=bt1.createNode(5);
        bt1.root.right.right=bt1.createNode(3);
        /*
               2
             4   1
            - - 5 3
        */
        Assert.assertEquals(true, bt1.isBalanced(bt1.root));
        
        bt1.root=bt1.createNode(4);
        bt1.root.right=bt1.createNode(2);
        bt1.root.right.left=bt1.createNode(1);
        bt1.root.right.right=bt1.createNode(1);
        bt1.root.right.right.left=bt1.createNode(5);
        bt1.root.right.right.right=bt1.createNode(3);
        /*
                   4
               -       2       
             -   -   1   1
            - - - - - - 5 3
        */
        Assert.assertEquals(false, bt1.isBalanced(bt1.root));
        
        bt1.root=bt1.createNode(4);
        bt1.root.left=bt1.createNode(5);
        bt1.root.right=bt1.createNode(2);
        bt1.root.right.left=bt1.createNode(1);
        bt1.root.right.right=bt1.createNode(1);
        bt1.root.right.right.left=bt1.createNode(5);
        bt1.root.right.right.right=bt1.createNode(3);
        /*
                   4
               5       2
             -   -   1   1
            - - - - - - 5 3
        */
        Assert.assertEquals(false, bt1.isBalanced(bt1.root));
        
        bt1.root=bt1.createNode(4);
        bt1.root.left=bt1.createNode(5);
        bt1.root.left.right=bt1.createNode(4);
        bt1.root.right=bt1.createNode(2);
        bt1.root.right.left=bt1.createNode(1);
        bt1.root.right.right=bt1.createNode(1);
        bt1.root.right.right.left=bt1.createNode(5);
        bt1.root.right.right.right=bt1.createNode(3);
        
        /*        
                   4
               5       2
             -   4   1   1
            - - - - - - 5 3
        */        
        Assert.assertEquals(true, bt1.isBalanced(bt1.root));
        
    }
}

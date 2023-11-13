package datastructures;
import org.junit.Assert;
import org.junit.Test;

public class TestAVLTree {
    @Test
    public void testinsert() throws QueueException{
        // right skewed/degenerate binary tree
        AVLTree t1=new AVLTree();
        
        t1.insert(2);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());

        t1.insert(4);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(5);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(6);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(7);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(8);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(9);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
    }   
    
    @Test
    public void testinsert2() throws QueueException{
        // left skewed/degenerate binary tree
        AVLTree t1=new AVLTree();
        
        t1.insert(9);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());

        t1.insert(8);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(7);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(6);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(5);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(4);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(3);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
    }

    @Test
    public void testinsert3() throws QueueException{
    
        AVLTree t1=new AVLTree();
        
        t1.insert(5);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
    
        t1.insert(6);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(2);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(9);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(1);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(12);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
        
        t1.insert(14);
        //t1.printTree();
        Assert.assertEquals(true, t1.isBalanced());
    } 
}

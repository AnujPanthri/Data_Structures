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
        bt1.root=new BinaryNode<Integer>(1);
        bt1.addNode(bt1.root, 2, true);
        bt1.addNode(bt1.root.left, 3, true);
        bt1.addNode(bt1.root.left, 4, false);
        bt1.addNode(bt1.root.left.right, 5, true);
        bt1.addNode(bt1.root.left.right, 6, false);
        
        List<Integer> result=new ArrayList<Integer>(List.of(1,2,3,4,5,6));
        // List<Integer> result=new ArrayList<Integer>(List.of(3,5,6,4,2,1));   // postorder
        
        Assert.assertArrayEquals(result.toArray(),bt1.preorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(result.toArray(),bt1.preorder(bt1.root, false).toArray());
    }
    
    @Test
    public void testpostorder(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        bt1.root=new BinaryNode<Integer>(1);
        bt1.addNode(bt1.root, 2, true);
        bt1.addNode(bt1.root.left, 3, true);
        bt1.addNode(bt1.root.left, 4, false);
        bt1.addNode(bt1.root.left.right, 5, true);
        bt1.addNode(bt1.root.left.right, 6, false);
        
        List<Integer> result=new ArrayList<Integer>(List.of(3,5,6,4,2,1));   // postorder
        
        Assert.assertArrayEquals(result.toArray(),result.toArray());
        Assert.assertArrayEquals(result.toArray(),bt1.postorder(bt1.root, true).toArray());
        
        // System.out.println();
        // for(Object el : bt1.postorder(bt1.root, false).toArray()) {
        //     System.out.print(el+",");
        // }
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
        bt1.root=new BinaryNode<Integer>(1);
        bt1.addNode(bt1.root, 2, true);
        bt1.addNode(bt1.root.left, 3, true);
        bt1.addNode(bt1.root.left, 4, false);
        bt1.addNode(bt1.root.left.right, 5, true);
        bt1.addNode(bt1.root.left.right, 6, false);
        
        List<Integer> result=new ArrayList<Integer>(List.of(3,2,5,4,6,1));   // inorder
        
        Assert.assertArrayEquals(result.toArray(),result.toArray());
        Assert.assertArrayEquals(result.toArray(),bt1.inorder(bt1.root, true).toArray());
        Assert.assertArrayEquals(result.toArray(),bt1.inorder(bt1.root, false).toArray());
    }

    @Test
    public void testbfs() throws QueueException{
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        bt1.root=new BinaryNode<Integer>(1);

        bt1.root.left=bt1.createNode(2);
        bt1.root.right=bt1.createNode(3);

        bt1.root.left.left=bt1.createNode(4);
        bt1.root.left.right=bt1.createNode(5);
        bt1.root.right.left=bt1.createNode(6);
        bt1.root.right.right=bt1.createNode(7);
        
        List<Integer> result=new ArrayList<Integer>(List.of(1,2,3,4,5,6,7));   // bfs
        bt1.print_list(bt1.bfs(bt1.root));
        Assert.assertArrayEquals(result.toArray(),bt1.bfs(bt1.root).toArray());
    }
    
    @Test
    public void testdfs(){
        BinaryTree<Integer> bt1=new BinaryTree<Integer>();
        bt1.root=new BinaryNode<Integer>(1);

        bt1.root.left=bt1.createNode(2);
        bt1.root.right=bt1.createNode(3);

        bt1.root.left.left=bt1.createNode(4);
        bt1.root.left.right=bt1.createNode(5);
        bt1.root.right.left=bt1.createNode(6);
        bt1.root.right.right=bt1.createNode(7);
        
        List<Integer> result=new ArrayList<Integer>(List.of(1,2,4,5,3,6,7));   // dfs
        // bt1.print_list(bt1.dfs(bt1.root));
        Assert.assertArrayEquals(result.toArray(),bt1.dfs(bt1.root).toArray());
    }
}

package datastructures;
import org.junit.Assert;
import org.junit.Test;
import java.lang.IndexOutOfBoundsException;


public class TestLinkedList {
    
    @Test
    public void testinsertBeg(){
        LinkedList<Integer> l1=new LinkedList<Integer>();
        Assert.assertEquals("", l1.toString());
        l1.insertBeg(1);
        Assert.assertEquals("1", l1.toString());
        l1.insertBeg(2);
        Assert.assertEquals("2->1", l1.toString());
        l1.insertBeg(3);
        Assert.assertEquals( "3->2->1", l1.toString());
    }

    @Test 
    public void testisEmpty(){
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        Assert.assertEquals(true, l1.isEmpty());
        l1.insertBeg(5);
        Assert.assertEquals(false, l1.isEmpty());
    }

    @Test
    public void testinsertEnd(){
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        l1.insertEnd(1);
        Assert.assertEquals("1", l1.toString());
        l1.insertEnd(2);
        Assert.assertEquals("1->2", l1.toString());
        l1.insertEnd(3);
        Assert.assertEquals("1->2->3", l1.toString());
    }


    @Test
    public void testdeleteBeg(){
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        l1.insertBeg(1);
        l1.insertBeg(2);
        l1.insertBeg(3);
        Assert.assertEquals((Integer)(3) , l1.deleteBeg());
        Assert.assertEquals( "2->1" , l1.toString());
        Assert.assertEquals( (Integer)(2) , l1.deleteBeg());
        Assert.assertEquals( "1" , l1.toString());
        Assert.assertEquals( (Integer)(1) , l1.deleteBeg());
        Assert.assertEquals( true , l1.isEmpty());

        Exception ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.deleteBeg();
        });
       
        Assert.assertTrue("can't delete from empty LinkedList".contains(ex1.getMessage()));
    }

    @Test
    public void testdeleteEnd(){
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        l1.insertBeg(1);
        l1.insertBeg(2);
        l1.insertBeg(3);
        Assert.assertEquals( (Integer)(1) , l1.deleteEnd());
        Assert.assertEquals( "3->2" , l1.toString());
        Assert.assertEquals((Integer)(2) , l1.deleteEnd());
        Assert.assertEquals( "3" , l1.toString());
        Assert.assertEquals( (Integer)(3) , l1.deleteEnd());
        Assert.assertEquals( true , l1.isEmpty());


        Exception ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.deleteEnd();
        });
       
        Assert.assertTrue(ex1.getMessage().contains("can't delete from empty LinkedList"));
    }

    @Test
    public void testinsertNth(){
        LinkedList<Integer> l1 = new LinkedList<Integer>();

        Exception ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.insertNth(-12, 4);
        });
        Assert.assertTrue(ex1.getMessage().contains("invalid index"));
        
        ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.insertNth(1, 4);
        });
        Assert.assertTrue(ex1.getMessage().contains("invalid index"));
        
        l1.insertEnd(1);
        l1.insertEnd(3);
        l1.insertEnd(6);
        
        ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.insertNth(-1, 0);
        });
        Assert.assertTrue(ex1.getMessage().contains("invalid index"));
        
        ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.insertNth(4, 7);
        });
        Assert.assertTrue(ex1.getMessage().contains("invalid index"));
        
        ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.insertNth(6, 7);
        });
        Assert.assertTrue(ex1.getMessage().contains("invalid index"));

        l1.insertNth(0,0);
        Assert.assertEquals("0->1->3->6", l1.toString());
        
        l1.insertNth(2,2);
        Assert.assertEquals("0->1->2->3->6", l1.toString());
        
        l1.insertNth(4,4);
        Assert.assertEquals("0->1->2->3->4->6", l1.toString());
        
        l1.insertNth(6,7);
        Assert.assertEquals("0->1->2->3->4->6->7", l1.toString());

    }
    @Test
    public void testdeleteNth(){
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        
        Exception ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.deleteNth(-1);
        });
        Assert.assertTrue(ex1.getMessage().contains("invalid index"));
        
        ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.deleteNth(1);

        });
        
        Assert.assertTrue(ex1.getMessage().contains("invalid index"));
        ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.deleteNth(0);

        });
        Assert.assertTrue(ex1.getMessage().contains("invalid index"));
        

        l1.insertEnd(1);
        l1.insertEnd(2);
        l1.insertEnd(3);
        l1.insertEnd(4);
        l1.insertEnd(6);
        
        ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.deleteNth(-1);
        });
        Assert.assertTrue(ex1.getMessage().contains("invalid index"));
        
        ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.deleteNth(5);
        });
        Assert.assertTrue(ex1.getMessage().contains("invalid index"));
        
        ex1 = Assert.assertThrows(IndexOutOfBoundsException.class, ()->{
            l1.deleteNth(6);
        });
        Assert.assertTrue(ex1.getMessage().contains("invalid index"));

        l1.deleteNth(0);
        Assert.assertEquals("2->3->4->6", l1.toString());
        
        l1.deleteNth(1);
        Assert.assertEquals("2->4->6", l1.toString());
        
        l1.deleteNth(2);
        Assert.assertEquals("2->4", l1.toString());

    }
}
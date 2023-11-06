package datastructures;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Test;

public class TestQueue {
    @Test
    public void testenqueue(){
        Queue<Integer> q1 = new Queue<Integer>();
        Assert.assertEquals("", q1.toString());
        q1.enqueue(1);
        Assert.assertEquals("1", q1.toString());
        q1.enqueue(2);
        q1.enqueue(3);
        Assert.assertEquals("1->2->3", q1.toString());
    }    

    @Test
    public void testisEmpty(){
        Queue<Integer> q1 = new Queue<Integer>();
        Assert.assertEquals(true, q1.isEmpty());
        q1.enqueue(1);
        Assert.assertEquals(false, q1.isEmpty());
    }

    @Test
    public void testdequeue() throws QueueException{
        Queue<Integer> q1 = new Queue<Integer>();
        Exception ex1 = Assert.assertThrows(QueueException.class, ()->{
            q1.dequeue();
        });
        Assert.assertTrue(ex1.getClass().toString().contains("QueueException"));
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);

        Assert.assertEquals((Integer)(1), q1.dequeue());
        Assert.assertEquals((Integer)(2), q1.dequeue());
        Assert.assertEquals((Integer)(3), q1.dequeue());
        Assert.assertEquals(true, q1.isEmpty());

        ex1 = Assert.assertThrows(QueueException.class, ()->{
            q1.dequeue();
        });
        Assert.assertTrue(ex1.getClass().toString().contains("QueueException"));

    }

    @Test
    public void testpeek() throws QueueException{
        Queue<Integer> q1 = new Queue<Integer>();
        Exception ex1 = Assert.assertThrows(QueueException.class, ()->{
            q1.peek();
        });
        Assert.assertTrue(ex1.getClass().toString().contains("QueueException"));

        q1.enqueue(1);
        Assert.assertEquals((Integer)(1),q1.peek());
        q1.enqueue(2);
        Assert.assertEquals((Integer)(1),q1.peek());
        q1.dequeue();
        Assert.assertEquals((Integer)(2),q1.peek());
    }


    @Test
    public void testcopyconstructor(){
        Queue<Integer> q1 = new Queue<Integer>();
        q1.enqueue(3);
        q1.enqueue(2);
        q1.enqueue(1);
        Queue<Integer> q2 = new Queue<Integer>(q1);
        Assert.assertEquals("3->2->1", q2.toString());
        Assert.assertEquals(q1.toString(), q2.toString());
    }
}

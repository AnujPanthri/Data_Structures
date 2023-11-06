package datastructures;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Test;

public class TestStack {
    @Test
    public void testpush(){
        Stack<Integer> s1 = new Stack<Integer>();
        Assert.assertEquals("",s1.toString());
        
        s1.push(1);
        Assert.assertEquals("1", s1.toString());
        s1.push(2);
        s1.push(3);

        Assert.assertEquals("3->2->1",s1.toString());
    }    
    
    @Test
    public void testisEmpty(){
        Stack<Integer> s1 = new Stack<Integer>();
        Assert.assertEquals(true,s1.isEmpty());
        s1.push(2);
        Assert.assertEquals(false,s1.isEmpty());
    }

    @Test
    public void testpop(){
        Stack<Integer> s1 = new Stack<Integer>();
        Exception ex1 = Assert.assertThrows(EmptyStackException.class, ()->{
            s1.pop();
        });
        Assert.assertTrue(ex1.getClass().toString().contains("EmptyStackException"));

        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);

        Assert.assertEquals((Integer)(4), s1.pop());
        Assert.assertEquals("3->2->1", s1.toString());
        
        Assert.assertEquals((Integer)(3), s1.pop());
        Assert.assertEquals("2->1", s1.toString());
        Assert.assertEquals((Integer)(2), s1.pop());
        Assert.assertEquals("1", s1.toString());
        Assert.assertEquals((Integer)(1), s1.pop());
        Assert.assertEquals("", s1.toString());
        Assert.assertEquals(true, s1.isEmpty());

        ex1 = Assert.assertThrows(EmptyStackException.class, ()->{
            s1.pop();
        });
        Assert.assertTrue(ex1.getClass().toString().contains("EmptyStackException"));

    }

    @Test
    public void testpeek(){
        Stack<Integer> s1 = new Stack<Integer>();
        Exception ex1 = Assert.assertThrows(EmptyStackException.class, ()->{
            s1.peek();
        });
        Assert.assertTrue(ex1.getClass().toString().contains("EmptyStackException"));

        s1.push(1);
        Assert.assertEquals((Integer)(1),s1.peek());
        s1.push(2);
        Assert.assertEquals((Integer)(2),s1.peek());
    }

    @Test
    public void testcopyconstructor(){
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(3);
        s1.push(2);
        s1.push(1);
        Stack<Integer> s2 = new Stack<Integer>(s1);
        Assert.assertEquals(s1.toString(), s2.toString());

    }
}

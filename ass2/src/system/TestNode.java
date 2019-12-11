package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNode {
    final int size = 10;
    Node tree;

    @Before
    public void setUp(){
        tree = new Tree("root");
        tree.depth=0;
    }

    @After
    public void tearDown() throws Exception {

    }

    //Checking root edge case :
    @Test
    public void testGetPathRoot(){
        assertEquals(tree.getPath().length,0);
        assertEquals(tree.parent,null);
    }

    @Test
    public void testGetPath(){
        Node child1 = new Tree("f1");
        Node child2 = new Tree("f2");
        child1.parent=(Tree) tree;
        child1.depth=1;
        child2.parent=(Tree) child1;
        child2.depth=2;
        String[] expected1 = {"f1"};
        String[] expected2 = {"f1","f2"};
        assertArrayEquals(expected1,child1.getPath());
        assertArrayEquals(expected2,child2.getPath());
    }

}

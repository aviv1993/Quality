package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import system.Tree;

import static org.junit.Assert.*;
public class TestTree {

    Tree root;
    @Before
    public void setUp() throws Exception {
        root = new Tree("root");
        root.depth=0;
    }

    @After
    public void tearDown() throws Exception {
    }

    //Checking that get create a node if not existed
    @Test
    public void testGetChildByName1(){
        String name = "Aviv";
        Tree child = root.GetChildByName(name);
        assertTrue(root.children.containsKey(name));
        assertEquals(child.name,name);
        assertEquals(child.depth,1);
        assertEquals(child.parent,root);
    }

    //Checking that get works :
    @Test
    public void testGetChildByName2(){
        String name1 = "Aviv",name2= "Bibi";
        Tree child1 = new Tree(name1);
        Tree child2=new Tree(name2);
        child1.depth=1;
        child2.depth=2;
        child1.parent=root;
        child2.parent=child1;
        child1.children.put(name2,child2);
        root.children.put(name1,child1);

        assertEquals(root.GetChildByName(name1),child1);
        assertEquals(child1.GetChildByName(name2),child2);


    }

}

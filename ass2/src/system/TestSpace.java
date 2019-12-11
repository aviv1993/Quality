package system;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSpace {
    final int size = 10;
    FileSystem fs;

    @Before
    public void setUp() throws Exception {
        fs = new FileSystem(size);
    }

    @After
    public void tearDown() throws Exception {
    }


    //Testing allocating space and the effect on leaf and Space classes
    @Test
    public void testAlloc1() {
        int leafSize=5;
        try {
            Leaf leaf1 = new Leaf("Aviv", leafSize); //Allocates 5 blocks
            //Testing that remaining size is ok :
            assertEquals(leafSize, FileSystem.fileStorage.countFreeSpace());
            //Testing that the array size of leaf is correct :
            assertEquals(leaf1.allocations.length,leafSize);
            int[] allocs = leaf1.allocations;
            //Testing that the leaf know the blocks its allocated to:
            for (int i = 0; i < leafSize; i++)
                assertEquals(allocs[i], i);
            //Testing that the Space know that bloack 0-5 allocated to leaf1:
            Leaf[] blocks = FileSystem.fileStorage.getAlloc();
            for(int i=0;i<leafSize;i++)
                assertEquals(blocks[i],leaf1);
        }
        catch (Exception e) { assertTrue(false);}

    }


    //Allocating more space than needed :
    @Test
    public void testAlloc2(){
        int leafSize=11;
        try {
            Leaf leaf2 = new Leaf("Bibi",leafSize) ; //allocating more space than allowed
            assertTrue(false);

        }
        catch (NullPointerException e){
            assertTrue(true); //Means we allocated too much space
        }
        catch (OutOfSpaceException e){
            assertTrue(false);
        }
    }


    //Testing De-alloc
    @Test
    public void testDeAlloc1(){
        int leafSize=4;
        try{
            Tree parent = new Tree("root");
            Leaf leaf = new Leaf("Aviv",leafSize);
            //Adds leaf to parent :
            parent.children.put(parent.name,leaf);
            //Adds parent to leaf :
            leaf.parent=parent;
            //De-alloc :
            FileSystem.fileStorage.Dealloc(leaf);
            Leaf[] blocks = FileSystem.fileStorage.getAlloc();
            //Checking that blocks were de- allocated :
            for(int i=0;i<leafSize;i++)
                assertEquals(blocks[i],null);
            //Checking that the space was freed :
            assertEquals(size,FileSystem.fileStorage.countFreeSpace());
            //Checking that leaf ws dissconnected from parent :
            assertFalse(parent.children.containsKey(leaf.name));
        }
        catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }


}

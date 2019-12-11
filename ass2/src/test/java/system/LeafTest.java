package system;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class LeafTest {

    FileSystem fs;
    @Before
    public void setUp(){
        fs = new FileSystem(5);
    }
    @Test
    public void testAllocate() {
        int size = 5;
        String name = "Aviv";
        try {
            Leaf leaf1 = new Leaf(name, size);
            assertEquals(FileSystem.fileStorage.countFreeSpace(), 0);
        }
        catch (Exception e){   fail(); }

    }
}

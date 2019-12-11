package system;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        NodeTest.class,
        SpaceTest.class,
        TreeTest.class,
        LeafTest.class,
        FileSystemTest.class
})

public class TestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
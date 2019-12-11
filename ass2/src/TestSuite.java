import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import system.TestNode;
import system.TestSpace;
import system.TestTree;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestNode.class,
        TestSpace.class,
        TestTree.class
})

public class TestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
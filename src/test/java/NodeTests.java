import org.jakub.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTests {

    public Node treeExampleFromDescription = new Node(
            5,
            new Node(
                    3,
                    new Node(
                            2,
                            null,
                            null
                    ),
                    new Node(
                            5,
                            null,
                            null
                    )
            ),
            new Node(
                    7,
                    new Node(
                            1,
                            null,
                            null
                    ),
                    new Node(
                            0,
                            new Node(
                                    2,
                                    null,
                                    null
                            ),
                            new Node(
                                    8,
                                    null,
                                    new Node(
                                            5,
                                            null,
                                            null
                                    )
                            )
                    )
            )
    );
    public Node treeExampleFromDescriptionButChangedOneNode = new Node(
            5,
            new Node(
                    3,
                    new Node(
                            2,
                            null,
                            null
                    ),
                    new Node(
                            1, //difference
                            null,
                            null
                    )
            ),
            new Node(
                    7,
                    new Node(
                            1,
                            null,
                            null
                    ),
                    new Node(
                            0,
                            new Node(
                                    2,
                                    null,
                                    null
                            ),
                            new Node(
                                    8,
                                    null,
                                    new Node(
                                            5,
                                            null,
                                            null
                                    )
                            )
                    )
            )
    );
    public Node loneNode = new Node(1);
    public Node onlyRightPath = new Node(
            1,
            null,
            new Node(
                    2,
                    null,
                    new Node(
                            3,
                            new Node(
                                    4,
                                    null,
                                    null
                            ),
                            null
                    )
            )
    );
    public Node subtree = new Node(
            2,
            new Node(
                    3,
                    null,
                    null
            ),
            null
    );

    public Node onePath = new Node(
            1,
            subtree,
            null
    );

    public Node twoSubtreesWithSameEdgeLength = new Node(
            1,
            subtree,
            subtree
    );

    @Test
    void maxEdgeLengthTest() {
        assertEquals(0, loneNode.maxEdgeLength());
        assertEquals(2, onePath.maxEdgeLength());
        assertEquals(2, twoSubtreesWithSameEdgeLength.maxEdgeLength());
        assertEquals(3, onlyRightPath.maxEdgeLength());
        assertEquals(4, treeExampleFromDescription.maxEdgeLength());
    }

    @Test
    void numberOfLeafsTest() {
        assertEquals(1, loneNode.numberOfLeafs());
        assertEquals(1, onePath.numberOfLeafs());
        assertEquals(2, twoSubtreesWithSameEdgeLength.numberOfLeafs());
        assertEquals(1, onlyRightPath.numberOfLeafs());
        assertEquals(5, treeExampleFromDescription.numberOfLeafs());
    }

    @Test
    void checkSamenessTest(){
        assertTrue(loneNode.checkSameness(loneNode));
        assertTrue(onePath.checkSameness(onePath));
        assertTrue(twoSubtreesWithSameEdgeLength.checkSameness(twoSubtreesWithSameEdgeLength));
        assertTrue(onlyRightPath.checkSameness(onlyRightPath));
        assertTrue(treeExampleFromDescription.checkSameness(treeExampleFromDescription));

        assertFalse(onlyRightPath.checkSameness(onePath));
        assertFalse(loneNode.checkSameness(onePath));
        assertFalse(treeExampleFromDescription.checkSameness(loneNode));
        assertFalse(treeExampleFromDescription.checkSameness(treeExampleFromDescriptionButChangedOneNode));
    }
}

import org.example.BinaryTree;
import org.example.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    void testCreateTreeWithValidInput() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        assertEquals(1, tree.getRoot().getValue());
        assertEquals(2, tree.getRoot().getLeft().getValue());
        assertEquals(3, tree.getRoot().getRight().getValue());
        assertEquals(4, tree.getRoot().getLeft().getLeft().getValue());
        assertEquals(5, tree.getRoot().getLeft().getRight().getValue());
        assertEquals(6, tree.getRoot().getRight().getLeft().getValue());
        assertEquals(7, tree.getRoot().getRight().getRight().getValue());
    }

    @Test
    void testCreateTreeWithEmptyInput() {
        BinaryTree tree = new BinaryTree();
        int[] array = {};
        tree.createTree(array);

        assertNull(tree.getRoot());
    }

    @Test
    void testPreOrderTraversal() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        StringBuilder result = new StringBuilder();
        tree.preOrder(tree.getRoot(), result);
        assertEquals("1 2 4 5 3 6 7 ", result.toString());
    }

    @Test
    void testPreOrderTraversalWithEmptyTree() {
        BinaryTree tree = new BinaryTree();

        StringBuilder result = new StringBuilder();
        tree.preOrder(tree.getRoot(), result);
        assertEquals("", result.toString());
    }

    @Test
    void testInOrderTraversal() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        StringBuilder result = new StringBuilder();
        tree.inOrder(tree.getRoot(), result);
        assertEquals("4 2 5 1 6 3 7 ", result.toString());
    }

    @Test
    void testInOrderTraversalWithEmptyTree() {
        BinaryTree tree = new BinaryTree();

        assertNull(tree.getRoot());

        StringBuilder result = new StringBuilder();
        tree.inOrder(tree.getRoot(), result);
        assertEquals("", result.toString());
    }

    @Test
    void testPostOrderTraversal() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        StringBuilder result = new StringBuilder();
        tree.postOrder(tree.getRoot(), result);
        assertEquals("4 5 2 6 7 3 1 ", result.toString());
    }

    @Test
    void testPostOrderTraversalWithEmptyTree() {
        BinaryTree tree = new BinaryTree();

        StringBuilder result = new StringBuilder();
        tree.postOrder(tree.getRoot(), result);
        assertEquals("", result.toString());
    }

    @Test
    void testCountLeaves() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        int result = tree.countLeaves(tree.getRoot());
        assertEquals(4, result);
    }

    @Test
    void testCountLeavesWithEmptyTree() {
        BinaryTree tree = new BinaryTree();

        int result = tree.countLeaves(tree.getRoot());
        assertEquals(0, result);
    }

    @Test
    void testInsertWithNonLeafNodes() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        assertEquals(8, tree.getRoot().getLeft().getLeft().getLeft().getValue());
        assertEquals(9, tree.getRoot().getLeft().getLeft().getRight().getValue());
        assertEquals(10, tree.getRoot().getLeft().getRight().getLeft().getValue());

        StringBuilder result = new StringBuilder();
        tree.preOrder(tree.getRoot(), result);
        assertEquals("1 2 4 8 9 5 10 3 6 7 ", result.toString());
    }

    @Test
    void testInsertWithLeafNodes() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6};
        tree.createTree(array);

        tree.insert(7);
        assertEquals(7, tree.getRoot().getRight().getRight().getValue());

        StringBuilder result = new StringBuilder();
        tree.preOrder(tree.getRoot(), result);
        assertEquals("1 2 4 5 3 6 7 ", result.toString());
    }

    @Test
    void testInsertWithRepetitiveNodes() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6};
        tree.createTree(array);

        tree.insert(2);
        assertEquals(2, tree.getRoot().getRight().getRight().getValue());

        StringBuilder result = new StringBuilder();
        tree.preOrder(tree.getRoot(), result);
        assertEquals("1 2 4 5 3 6 2 ", result.toString());
    }

    @Test
    void testInsertIntoEmptyTree() {
        // 创建一个新的二叉树实例
        BinaryTree tree = new BinaryTree();

        tree.insert(1);

        assertNotNull(tree.getRoot());  // 根节点不为空
        assertEquals(1, tree.getRoot().getValue());  // 根节点值应为 10

        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        assertNotNull(tree.getRoot().getLeft());
        assertNotNull(tree.getRoot().getRight());
        assertNotNull(tree.getRoot().getLeft().getLeft());

        assertEquals(1, tree.getRoot().getValue());
        assertEquals(2, tree.getRoot().getLeft().getValue());
        assertEquals(3, tree.getRoot().getRight().getValue());
        assertEquals(4, tree.getRoot().getLeft().getLeft().getValue());
    }

    @Test
    void testDeleteWithExistentNonLeafNode() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        tree.delete(3); // 非叶子结点

        StringBuilder result = new StringBuilder();
        tree.preOrder(tree.getRoot(), result);
        assertEquals("1 2 4 5 7 6 ", result.toString());
    }

    @Test
    void testDeleteWithExistentLeafNode() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        tree.delete(6); // 非叶子结点

        StringBuilder result = new StringBuilder();
        tree.inOrder(tree.getRoot(), result);
        assertEquals("4 2 5 1 7 3 ", result.toString());
    }

    @Test
    void testDeleteWithExistentRootNode() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        tree.delete(1); // 非叶子结点

        StringBuilder result = new StringBuilder();
        tree.inOrder(tree.getRoot(), result);
        assertEquals("4 2 5 7 6 3 ", result.toString());
    }

    @Test
    void testDeleteWithSingRootNode() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1};
        tree.createTree(array);

        tree.delete(1); // 非叶子结点

        assertNull(tree.getRoot());

        StringBuilder result = new StringBuilder();
        tree.inOrder(tree.getRoot(), result);
        assertEquals("", result.toString());
    }

    @Test
    void testDeleteWithNonExistentNode() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        StringBuilder result1 = new StringBuilder();
        tree.preOrder(tree.getRoot(), result1);

        tree.delete(10); // 非叶子结点

        StringBuilder result2 = new StringBuilder();
        tree.preOrder(tree.getRoot(), result2);
        assertEquals(result1.toString(), result2.toString());
    }

    @Test
    void testDeleteWithEmptyTree() {
        BinaryTree tree = new BinaryTree();
        int[] array = {};
        tree.createTree(array);

        tree.delete(10); // 非叶子结点

        assertNull(tree.getRoot());
    }

    @Test
    void testSearchWithExistentNode() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        boolean result = tree.search(tree.getRoot(), 3);
        assertTrue(result);
    }

    @Test
    void testSearchWithNonExistentNode() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        boolean result = tree.search(tree.getRoot(), 22);
        assertFalse(result);

    }

    @Test
    void testSearchWithEmptyTree() {
        BinaryTree tree = new BinaryTree();
        int[] array = {};
        tree.createTree(array);

        boolean result = tree.search(tree.getRoot(), 22);
        assertFalse(result);

    }
}

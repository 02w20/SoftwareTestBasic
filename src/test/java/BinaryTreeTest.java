import org.example.BinaryTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    void testCreateTree() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        tree.createTree(array);

        assertEquals(1, tree.getRootValue());
        assertEquals(2, tree.getLeftValue());
        assertEquals(3, tree.getRightValue());
    }

    @Test
    void testPreOrderTraversal() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5};
        tree.createTree(array);

        // 验证前序遍历
        StringBuilder result = new StringBuilder();
        tree.preOrder(tree.getRoot());
        assertEquals("1 2 4 5 3 ", result.toString());
    }

    @Test
    void testInsert() {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        assertEquals(1, tree.getRootValue());
        assertEquals(2, tree.getLeftValue());
        assertEquals(3, tree.getRightValue());
    }

    @Test
    void testDelete() {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5};
        tree.createTree(array);

        tree.delete(3);

        assertFalse(tree.search(tree.getRoot(), 3));  // 3 已被删除
    }
}

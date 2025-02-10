package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getLeft() {
        return root.left;
    }

    public TreeNode getRight() {
        return root.right;
    }

    // 使用数组创建二叉树
    public void createTree(int[] array) {

        root = createTreeFromArray(array, 0);
    }

    private TreeNode createTreeFromArray(int[] array, int index) {
        if (index < array.length) {
            TreeNode node = new TreeNode(array[index]);
            node.left = createTreeFromArray(array, 2 * index + 1);
            node.right = createTreeFromArray(array, 2 * index + 2);
            return node;
        }
        return null;
    }

    // 前序遍历
    public void preOrder(TreeNode node, StringBuilder result) {
        if (node != null) {
            result.append(node.value).append(" ");
            preOrder(node.left, result);
            preOrder(node.right, result);
        }
    }

    // 中序遍历
    public void inOrder(TreeNode node, StringBuilder result) {
        if (node != null) {
            inOrder(node.left, result);
            result.append(node.value).append(" ");
            inOrder(node.right, result);
        }
    }

    // 后序遍历
    public void postOrder(TreeNode node, StringBuilder result) {
        if (node != null) {
            postOrder(node.left, result);
            postOrder(node.right, result);
            result.append(node.value).append(" ");
        }
    }

    // 统计叶子结点数
    public int countLeaves(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // 查找节点
    public boolean search(TreeNode node, int value) {
        if (node == null) return false;
        if (node.value == value) return true;
        return search(node.left, value) || search(node.right, value);
    }

    // 插入节点
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left == null) {
                current.left = new TreeNode(value);
                return;
            } else {
                queue.add(current.left);
            }
            if (current.right == null) {
                current.right = new TreeNode(value);
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // 删除节点
    public void delete(int key) {
        if (root == null) {
            System.out.println("树为空，无法删除！");
            return;
        }

        // 找到要删除的节点和最后一个节点
        TreeNode keyNode = null;
        TreeNode lastNode = null;
        TreeNode parentOfLast = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            // 找到要删除的节点
            if (current.value == key) {
                keyNode = current;
            }

            // 记录最后一个节点及其父节点
            if (current.left != null) {
                parentOfLast = current;
                queue.add(current.left);
            }
            if (current.right != null) {
                parentOfLast = current;
                queue.add(current.right);
            }
            lastNode = current;
        }

        if (keyNode == null) {
            System.out.println("未找到节点：" + key);
            return;
        }

        // 用最后一个节点的值替换要删除的节点
        keyNode.value = lastNode.value;

        // 删除最后一个节点
        if (parentOfLast != null) {
            if (parentOfLast.right == lastNode) {
                parentOfLast.right = null;
            } else {
                parentOfLast.left = null;
            }
        } else {
            root = null;  // 如果整个树只有一个节点
        }
        System.out.println("节点 " + key + " 已删除。");
    }

    // 测试功能
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        tree.createTree(array);

        //System.out.println("前序遍历:");
        //tree.preOrder(tree.root);
        //System.out.println("\n中序遍历:");
        //tree.inOrder(tree.root);
        //System.out.println("\n后序遍历:");
        //tree.postOrder(tree.root);

        System.out.println("叶子结点个数: " + tree.countLeaves(tree.root));

        System.out.println("查找节点 5: " + tree.search(tree.root, 5));
        System.out.println("查找节点 12: " + tree.search(tree.root, 12));
        System.out.println("插入节点 10");
        tree.insert(10);
        System.out.println("中序遍历:");


        System.out.println("\n删除节点 3");
        tree.delete(3);
        System.out.println("\n删除节点 14");
        tree.delete(14);
        System.out.println("中序遍历:");

    }
}

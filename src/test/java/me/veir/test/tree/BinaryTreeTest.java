package me.veir.test.tree;

import me.veir.learn.algorithm.ch109.BinaryTree;
import me.veir.learn.algorithm.ch109.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @create by Veir, veir.xw@gmail.com at 2020/8/18 16:02
 */
public class BinaryTreeTest {
    TreeNode tree;

    @After
    public void tearDown() throws Exception {
    }



    @Before
    public void createBinarySearchTree() {
        int[] data = {5, 4, 8, 9, 1, 7, 3};
        /**
         *               5
         *           4         8
         *      1           7     9
         *         3
         */
        tree = BinaryTree.createBinarySearchTree(data);
    }

    @Test
    public void preTraverseBTree() {
        // 5    4   1   3   8   7   9
        BinaryTree.preTraverseBTree(tree);
    }

    @Test
    public void inTraverseBTree() {
        //1    3   4   5    7   8   9
        BinaryTree.inTraverseBTree(tree);
    }

    @Test
    public void rightTraverseBTree() {
        //3     1   4   7   9   8   5
        BinaryTree.rightTraverseBTree(tree);
    }
}
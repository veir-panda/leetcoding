package me.veir.learn.algorithm.ch109;

/**
 * @create by Veir, veir.xw@gmail.com at 2020/8/18 13:18
 */
public class BinaryTree {

    /**
     * 创建二叉查找树
     * @param 
     * @return
     */
    public static TreeNode createBinarySearchTree(int[] data){
        TreeNode root = new TreeNode();
        if (data == null || data.length == 0){
            return root;
        }

        root.setVal(data[0]);
        for (int i = 1; i < data.length; i++) {
            addNode(root, data[i]);
        }
        return root;
    }

    private static void addNode(TreeNode root, int value){
        if (root == null){
            return;
        }
        if (value > root.getVal()){
            if (root.getRight() == null){
                root.setRight(new TreeNode().setVal(value));
            }else {
                addNode(root.getRight(), value);
            }
        }else {
            if (root.getLeft() == null){
                root.setLeft(new TreeNode().setVal(value));
            }else{
                addNode(root.getLeft(), value);
            }
        }
    }

    /**
     * 获取树的深度
     * @param root 树
     * @return
     */
    public static int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftHeight = getHeight(root.getLeft());

        int rightHeight = getHeight(root.getRight());

        int max = leftHeight;

        if (rightHeight > max){
            max = rightHeight;
        }
        return max + 1;
    }

    /**
     * 先序遍历：根-左-右
     * @param root 树
     * @param 
     */
    public static void preTraverseBTree(TreeNode root){
        if (root == null){
            return;
        }
        //根节点
        System.out.print(root.getVal() + "\t");

        //遍历左子树
        preTraverseBTree(root.getLeft());

        //遍历右子树
        preTraverseBTree(root.getRight());
    }

    /**
     * 中序遍历：左-根-右
     * 特点：遍历二叉查找树时，结果自动为升序
     * @param root 树
     * @param 
     */
    public static void inTraverseBTree(TreeNode root){
        if (root == null){
            return;
        }
        //遍历左子树
        inTraverseBTree(root.getLeft());

        //根节点
        System.out.print(root.getVal()  + "\t");

        //遍历右子树
        inTraverseBTree(root.getRight());
    }

    /**
     * 后序遍历：左-右-根
     * @param root 树
     * @param 
     */
    public static void rightTraverseBTree(TreeNode root){
        if (root == null){
            return;
        }
        //遍历左子树
        rightTraverseBTree(root.getLeft());

        //遍历右子树
        rightTraverseBTree(root.getRight());

        //根节点
        System.out.print(root.getVal()  + "\t");
    }
}

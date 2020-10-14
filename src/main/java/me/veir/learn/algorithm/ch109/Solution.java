package me.veir.learn.algorithm.ch109;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * /**
 *      * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *      *
 *      * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *      *
 *      * 示例:
 *      *
 *      * 给定的有序链表： [-10, -3, 0, 5, 9],
 *      *
 *      * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *      *
 *      *       0
 *      *      / \
 *      *    -3   9
 *      *    /   /
 *      *  -10  5
 *      *
 *      * 来源：力扣（LeetCode）
 *      * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 *      * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Veir, veir.xw@gmail.com
 * @create 2020/8/18 21:19
 */
public class Solution {

    public static void main(String[] args) {
        ListNode end = new ListNode(9);
        ListNode head = null;
        ListNode next = end;
        for (int i = 9; i > -1; i--) {
            head = new ListNode(i);
            head.setNext(next);
            next = head;
        }

        Solution solution = new Solution();
        TreeNode tree = solution.sortedListToBST(head);

        BinaryTree.inTraverseBTree(tree);
    }
    /**
     * 根据给定的链表，创建一个高度平衡的二叉搜索树
     * 实现的原理是：序列的中位数作为树的根节点，中位数的两边元素个数相差为1或相等，
     * 则可以证明：以中位数作为树或子树的根节点的树，是一个高度平衡的二叉树
     * 构造树的过程使用分治的思想，对中位数的左右两边分别进行递归构建子树
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    /**
     * 递归构建平衡二叉搜索树
     * @param head
     * @param right
     * @return
     */
    public TreeNode sortedListToBST(ListNode head, ListNode right) {
        if (head == right){
            return null;
        }
        ListNode mid = getMedia(head, right);
        TreeNode tree = new TreeNode(mid.getVal());
        tree.setLeft(sortedListToBST(head, mid));
        tree.setRight(sortedListToBST(mid.getNext(), right));
        return tree;
    }

    /**
     * 获取中位数
     * @param left 链表开始节点
     * @param right 链表结束节点, 可以为null
     * @return 链表中位数节点
     */
    public ListNode getMedia(ListNode left, ListNode right){
        /**
         * 快慢指针法：快指移动2步，慢指针移动1步，
         * 快指针移动到链表尾部或尾部前一个时，慢指针指向中位数，
         * 此时，中位数下标（从0计数）：
         *      奇数个时，下标为向下取整(n/2)，
         *      偶数个时，为n/2
         */
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.getNext() != right){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }
}

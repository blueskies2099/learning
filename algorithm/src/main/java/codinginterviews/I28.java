package codinginterviews;

import leetcode.common.TreeNode;

import java.util.*;

/**
 * @author admin
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 */
public class I28 {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.val == -1) {
                continue;
            }
            if (node.left != null) {
                queue.offer(node.left);
            } else {
                queue.add(new TreeNode(-1));
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else {
                queue.add(new TreeNode(-1));
            }
        }
        Stack<Integer> stack = new Stack<>();
        list.remove(0);
        int top, index;
        for (int i = 0; i < list.size(); i++) {
            if (stack.isEmpty()) {
                stack.push(list.get(i));
            } else {
                top = stack.pop();
                index = list.get(i);
                if (top != index) {
                    stack.push(top);
                    stack.push(index);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = null;
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
}

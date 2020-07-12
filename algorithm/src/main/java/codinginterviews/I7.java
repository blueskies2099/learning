package codinginterviews;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 * @author qing
 */
public class I7 {
    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(0, 0, inorder.length - 1);
    }

    private TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {
        if (in_left_idx > in_right_idx){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_root_idx]);
        int idx = map.get(preorder[pre_root_idx]);
        root.left = recursive(pre_root_idx + 1, in_left_idx, idx-1);
        root.right = recursive(pre_root_idx + (idx-1-in_left_idx+1) + 1, idx+1, in_right_idx);
        return root;
    }
}

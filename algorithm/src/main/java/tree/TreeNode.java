package tree;

import java.util.*;

/**
 * 二叉树
 * @author qing
 * @date 2020 04 25
 */
public class TreeNode {
    int val;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int val){
        this.val =val;
    }

    /**
     * 创建二叉树
     * @param preOrder 先序队列
     * @param inOrder 中序队列
     * @return treeNode 根节点
     */
    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i], i);
        }
        return build(preOrder, map, 0, preOrder.length - 1, 0);
    }

    private TreeNode build(int[] preOrder, HashMap<Integer, Integer> map, int preStart, int preEnd, int inStart) {
        if (preEnd < preStart){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);

        int rootIndex = map.get(root.val);

        int len = rootIndex - inStart;

        root.leftChild = build(preOrder, map, preStart + 1, preStart + len, inStart);
        root.rightChild = build(preOrder, map, preStart + len + 1, preEnd, rootIndex + 1);
        return root;
    }

    /**
     * 层序遍历
     * @param root 二叉树根节点
     * @return list 层序遍历列表
     */
    public List printTop2Bottom(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }
        return list;
    }

}

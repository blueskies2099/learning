package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @author qing
 */
public class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        backtrack(nums, len, 0, used, new ArrayList<>(), res);

        return res;

    }

    public void backtrack(int[] nums, int len, int depth, boolean[] used, List<Integer> path, List<List<Integer>> res){
        if (len == depth){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]){
                used[i] = true;
                path.add(nums[i]);

                backtrack(nums, len, path.size(), used, path, res);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

}

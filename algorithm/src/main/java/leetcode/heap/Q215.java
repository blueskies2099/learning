package leetcode.heap;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k个最大的元素，
 * 而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @author qing
 */
public class Q215 {
    public static void main(String[] args) {
        System.out.println(new Q215().findKthLargest(new int[]{21, 2, 4565, 12, 4, 2, 6, 0}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int element : nums){
            heap.offer(element);
            if (heap.size() > k){
                heap.poll();
            }
        }
        return heap.poll();
    }
}

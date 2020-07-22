package codinginterviews;

/**
 * @author admin
 *
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 */
public class I21 {
    public static int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        int tmp;
        while (i < j){
            // 非奇数 交换
            if (nums[i] % 2 == 0){
                // 找到奇数
                while (nums[j] % 2 == 0){
                    j--;
                }
                tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;

            }
            i++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = exchange(new int[]{1, 2, 3, 4});
    }
}

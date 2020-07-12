package codinginterviews;

/**
 * 面试题10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 提示：
 *
 * 0 <= n <= 100
 * @author qing
 */
public class I10_2 {
    public static int numWays(int n) {
        if(n == 0 || n == 1){
            return 1;
        }else if ( n == 2){
            return 2;
        }
        // 定义dp[]
        int[] dp = new int[n+1];
        // 初始化
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            // 转移方程
            dp[i] = dp[i-1] + dp[i-2];
        }
        // 返回结果
        return dp[n]%1000000007;
    }

    public static void main(String[] args) {
        System.out.println(numWays(0));
    }
}

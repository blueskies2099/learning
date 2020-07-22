package codinginterviews;

/**
 * @author qing
 *
 * 剑指 Offer 16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 */
public class I16 {
    public double myPow(double x, int n) {
        if (x == 0){
            return 0;
        }
        long p = n;
        if (p < 0){
            x = 1/x;
            p = -p;
        }
        double res = 1.0;
        while (p > 0){
            if ((p&1) == 1){
                res *= x;
            }
            p = p >> 1;
            x *= x;
        }
        return res;
    }
}

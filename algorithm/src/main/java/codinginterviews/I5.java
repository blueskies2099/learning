package codinginterviews;

/**
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 *
 * @author qing
 */
public class I5 {
    public String replaceSpace(String s) {
        return s.replaceAll("\\s", "%20");
    }

    public String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()) {
            if (ch == ' ') {
                sb.append("%20");
            }else {
                sb.append(ch);
            }

        }
        return sb.toString();
    }
}

package codinginterviews;

import codinginterviews.common.ListNode;

/**
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 *
 * @author qing
 */
public class I6 {
    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }
        ListNode current = head;
        int len = 0;
        while (current != null){
            current = current.next;
            len++;
        }
        int[] reverse = new int[len];
        while (head != null){
            reverse[len-1] = head.val;
            len--;
            head = head.next;
        }
        return reverse;
    }
}
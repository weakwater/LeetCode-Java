package org.example.math;

import org.example.model.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class LeetCode_2 {
    /**
     *    核心思路:
     *       1. 要对2个链表同时进行遍历
     *       2. 相同位置的节点需要相加，同时要考虑超过10以后，需要加到下一个节点上
     *       3. 需要考虑2个链表为空的情况，以及相加结果超过10以后，链表为空的情况
     *       4. 对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点 head。
     *       使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     *       定义一个 carry 变量。记录节点相加后，超过10的内容，例如 9+9 = 18，那么carry = 18/10 = 1; 节点的值=18%10 =8；
     *       定义一个初始化的pre链表 ListNode res = new ListNode(0);
     *       定义一个需要移动的指针链表 ListNode cursor = res;
         * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cursor = res;
        int parse = 0;
        while (l1 != null || l2 != null || parse > 0) {
            if (l1 != null) {
                parse += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                parse += l2.val;
                l2 = l2.next;
            }
            cursor.next = new ListNode(parse % 10);
            parse /= 10;
            cursor = cursor.next;
        }
        return res.next;
    }
}

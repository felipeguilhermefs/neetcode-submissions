/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int size = lists.length;
        int step = 1;

        while (step < size) {
            for (int i = 0; i < size-step; i+= 2*step) {
                lists[i] = merge(lists[i], lists[i+step]);
            }
            step *= 2;
        }

        return lists[0];
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        ListNode head = new ListNode();
        ListNode cur = head;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }

            cur = cur.next;
        }

        if (left != null) {
            cur.next = left;
        }

        if (right != null) {
            cur.next = right;
        }

        return head.next;
    }
}

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
        ListNode result = null;
        for (var node: lists) {
            result = merge(result, node);
        }
        return result;
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        ListNode head = null;
        
        if (left.val <= right.val) {
            head = new ListNode(left.val);
            left = left.next;
        } else {
            head = new ListNode(right.val);
            right = right.next;
        }
        ListNode cur = head;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = new ListNode(left.val);
                left = left.next;
            } else {
                cur.next = new ListNode(right.val);
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

        return head;
    }
}

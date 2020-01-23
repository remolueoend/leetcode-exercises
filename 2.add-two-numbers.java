/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */


 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }


// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode cl = l1;
        ListNode cr= l2;
        ListNode prev = null;
        ListNode first = null;
        
        while(cl != null || cr != null) {
            int sum = (cl != null ? cl.val : 0) + (cr != null ? cr.val : 0) + carry;
            carry = sum / 10;
            ListNode n = new ListNode(sum % 10);
            if(prev != null) {
                prev.next = n;
            }
            if(first == null) {
                first = n;
            }
            prev = n;
            cl = cl != null ? cl.next : null;
            cr = cr != null ? cr.next : null;
        }
        if(carry != 0) {
            prev.next = new ListNode(carry);
        }
        
        return first;
        
    }
}
// @lc code=end


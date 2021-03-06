package wr.leetcode.algo.remove_nth_node_from_end_of_list;

import wr.leetcode.algo.ListNode;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode helper = new ListNode(-1);
        helper.next = head;
        ListNode fast = helper;
        ListNode slow = helper;
        int count = n;
        if( n <= 0 ) {
            return helper.next;
        }

        while( count-- > 0 ) {
            fast = fast.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode next = slow.next.next;
        slow.next = next;
        return helper.next;
    }








    /*
    public ListNode removeNthFromEnd0(ListNode head, int n) {

        ListNode helper = new ListNode(-1);
        helper.next = head;

        int len = getLen(head);
        if(0 == len) {
            return helper.next;
        }
        if(0 != n) {
            ListNode fast = helper;
            ListNode slow = helper;
            int i = 0;
            while(fast.next != null) {
                fast = fast.next;
                i ++;
                if (i > n) {
                    slow = slow.next;
                }
            }
            ListNode tmp = slow.next;
            slow.next = tmp.next;
        }
        return helper.next;
    }

    public int  getLen(ListNode head) {
        int i = 0;
        while(head != null) {
            i ++;
            head = head.next;
        }
        return i;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode helper = new ListNode(-1);
        helper.next = head;

        ListNode fast = helper;
        ListNode slow = helper;

        if( n <= 0) {
            return helper.next;
        }

        while( fast.next != null && n -- > 0) {
            fast = fast.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return helper.next;
    }*/
}
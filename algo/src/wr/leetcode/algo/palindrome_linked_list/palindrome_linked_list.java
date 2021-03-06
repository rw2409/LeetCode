package wr.leetcode.algo.palindrome_linked_list;

import wr.leetcode.algo.ListNode;

class Solution1 {


    public int size(ListNode head) {
        int ret = 0;
        while(head != null) {
            head = head.next;
            ret++;
        }
        return ret;
    }

    public ListNode split(ListNode head, int index) {
        ListNode ret = null;
        for (int i = 1; i < index; ++i) {
            if(index - 1 == i) {
                ret = head.next;
                head.next = null;
                break;
            }
            head = head.next;
        }
        return ret;
    }

    public ListNode reverse(ListNode head){
        ListNode helper = new ListNode(0);
        helper.next = null;
        while(null != head) {
            ListNode next = head.next;
            head.next = helper.next;
            helper.next = head;
            head = next;
        }
        return helper.next;
    }

    public boolean isPalindrome(ListNode head) {
        int len = size(head);
        boolean ret = true;
        if(len > 1) {
            int rStart = (len+1)/2+1;
            ListNode nStart = split(head, rStart);
            ListNode tail = reverse(nStart);
            ret = true;
            for (int i = 1; i <= (len-1)/2; ++i) {
                if(head.val != tail.val) {
                    ret = false;
                    break;
                }
                head = head.next;
                tail = tail.next;
            }
        }
        return ret;
    }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        if(count == n) {
            return head.next;
        }
        cur = head;
        for(int i = 0; i < count - n && cur != null; i++) {
            if(i == count - n - 1) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}

*********************************************************************

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        if(head.next == null && n == 1) return null;
        
        // when n == size of linked list
        ListNode p = head;
        int size = 0;
        while(p != null) {
            p = p.next;
            size++;
        }
        if(size == n) {
            return head.next;
        }
        
        // all other cases
        ListNode sp = head, ep = head;
        for(int i = 0; i < n; i++) ep = ep.next;
        while(ep.next != null) {
            sp = sp.next;
            ep = ep.next;
        }
        sp.next = sp.next.next;
        
        return head;
    }
}

********************************************************************************************

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1)
        {
            return null;
        }
        ListNode sp=head;
        ListNode fp=head;
        int c=0;
        while(c<n)
        {
            fp=fp.next;
            c++;
        }
       if(fp==null)
       {
           head=head.next;
           return head;
       }
        while(fp.next!=null)
        {
            sp=sp.next;
            fp=fp.next;
        }
        sp.next=sp.next.next;
        return head;
    }
}

*****************************************************************************

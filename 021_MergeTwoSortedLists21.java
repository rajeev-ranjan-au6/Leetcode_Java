class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode r = l1, l = l2;
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        while(r != null || l != null){
            int rValue = (r == null) ? Integer.MAX_VALUE : r.val;
            int lValue = (l == null) ? Integer.MAX_VALUE : l.val;
            int minValue = Math.min(rValue, lValue);
            if(rValue == minValue){r = r.next;} 
            else {l = l.next;}
            curr.next = new ListNode(minValue);
            curr = curr.next;
        }
        return dummyNode.next;
    }
}

*********************************************************************

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tail = res, p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            tail.next = new ListNode(p1.val < p2.val ? p1.val : p2.val);
            tail = tail.next;
            if (p1.val < p2.val) p1 = p1.next;
            else p2 = p2.next;
        }
        tail.next = p1 == null ? p2 : p1;
        return res.next;
    }
}

***************************************************

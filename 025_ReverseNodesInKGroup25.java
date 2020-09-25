class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        int len = 1;
        ListNode firstTail = head;
        
        //Loop to find the tail of the group starting by head
        //The group must be k-length
        for(; firstTail != null && len < k; len++) firstTail = firstTail.next;
        
        if (firstTail == null || len < k) return head; //k is greater than num of total nodes, or the last nodes don't make a k-length group (a non-group)
        
        ListNode tail, auxHead, aux1, aux2, aux3;
        while (len == k) {
            auxHead = head;
            aux1 = head;
            aux2 = aux1.next;
            aux3 = null;
            
            //Loop to reverse a group
            //It takes k-1 iterations (for the group {1 -> 2}, we just have to make {2 -> 1}, which takes one iteration)
            //This loop is to reverse a group, we still have to join 2 different groups, which takes place outside this loop
            for(int i = 0; i < k-1; i++) {
                aux3 = aux2.next;
                aux2.next = aux1;
                aux1 = aux2;
                aux2 = aux3;
            }
            
            //Since aux3 is the next node which the head of the actual group had before it was reversed, we find the tail of this new group starting by aux3
            //The code is the same as above
            len = 1;
            head = aux3;
            tail = head;
            for(; tail != null && len < k; len++) tail = tail.next;
            
            //There wasn't enough nodes to make a k-length group (a non-group), so we decrease its length so it doesn't count the null node
            //Also, the tail of the previous calculated group will point to the head of the non-group
            if (tail == null) {
                tail = head;
                len--;
            }
            auxHead.next = tail;
        }
        return firstTail;
    }
}

***************************************************************************************************

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head==null || head.next ==null || k==1)
            return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
        int i=0;
        while (head != null){
            i++;
            if (i%k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyhead.next;
    }

    public ListNode reverse(ListNode begin, ListNode end){
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr!=end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }
}

*************************************************************************************************************************
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode newPtr = null;
        ListNode current = head;
        ListNode first = null;
        ListNode cap = null;
        
        while(current != null){
            // Gonna need this to reverse the k group
            first = current;
            
            // Get the k group
            for(int i = 0; i < k-1; i++){
                if(current == null) break;
                current = current.next;
            }
            
            // If we have a full k group
            if(current != null){
                cap = current.next;
                current.next = null;
                ListNode reversed = reverse(first);
                
                // Add to the end or head of our new linked list
                if(newHead == null){
                    newHead = reversed;
                    newPtr = newHead;
                }
                else newPtr.next = reversed;
                while(newPtr != null && newPtr.next != null) newPtr = newPtr.next;
            }
            
            // HANDLE REMAINING NODES
            else{
                newPtr.next = first;
                break;
            }
            // Resume where we left off
            current = cap;
        }
        return newHead;
    }
    
    public ListNode reverse(ListNode head) {
        if(head == null) return null;
        ListNode prev = null;
        ListNode current = head;
        ListNode temp = null;
        
        while(current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        head.next = null;
        return prev;
    }
}

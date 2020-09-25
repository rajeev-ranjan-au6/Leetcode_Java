class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(ListNode list: lists) {
            while(list != null) {
                pq.add(list.val);
                list = list.next;
            }
        }
        
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        while(!pq.isEmpty()) {
            ListNode t = new ListNode(pq.poll());
            curr.next = t;
            curr = curr.next;
        }
        return head.next;
    }
}

****************************************************************************
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists==null || lists.length==0)
            return null;
        
        List<Integer>list=new ArrayList<Integer>();
        for(int i=0;i<lists.length;i++){
            ListNode cur=lists[i];
            while(cur!=null){
                list.add(cur.val);
                cur=cur.next;
            }
        }
        ListNode head=null;
        if(list.size()>0){
            Collections.sort(list);
            head=new ListNode(list.get(0));
            ListNode cur=head;
            for(int i=1;i<list.size();i++){
             ListNode node=new ListNode(list.get(i));
             cur.next=node;
             cur=cur.next;
          }
        }
         
        return head;
    }
}

**************************************************************************

class Solution {
	public ListNode mergeKLists(ListNode[] lists) {

		//using lambda define a PriorityQueue to sort the heads 
		Queue<ListNode> queue = new PriorityQueue<>((l1, l2) -> {return l1.val - l2.val;});   
		for(ListNode list : lists) if(list != null) queue.offer(list);
		if(queue.size() == 0) return null;

		//keep polling the head with minimal val and put the next node of that head into PriorityQueue
		ListNode head = queue.poll();
		ListNode pointer = head;
		if(head.next != null) queue.offer(head.next);
		while(!queue.isEmpty()) {
			pointer.next = queue.poll();
			pointer = pointer.next;
			if(pointer.next != null) queue.offer(pointer.next);
		}

		return head;
	}
}

******************************************************************

public class Solution {

	// using priority queue
	public ListNode mergeKLists(ListNode[] lists) 
	{
		int n = lists.length;
		if(n == 0) return null;
		if(n == 1) return lists[0];
		PriorityQueue<Integer> q = new PriorityQueue<>();

		// add all items form all lists
		for(int i=0;i<lists.length;i++)
		{
			ListNode c = lists[i];
			while(c != null)
			{
				q.add(c.val);
				c = c.next;
			}
		}
		ListNode res = null;
		ListNode c = null;
		ListNode last = null;

		// convert q back to listNode
		while(q.isEmpty() == false)
		{
			c = new ListNode(q.poll());
			if(last != null)
			{
				last.next = c;
			}
			last = c;
			if(res == null)
			{
				res = last;
			}
		}

		return res;
	}
}

************************************************************************


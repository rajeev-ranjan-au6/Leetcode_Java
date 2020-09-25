class Solution {
 
    ListNode th =null;
    ListNode tt = null;
    
    public void addLast(int x){
        ListNode nn = new ListNode(x);
        if(th == null){
            th = nn;
            tt = nn;
        }else{
            tt.next = nn;
            tt = nn;
        }   
    }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null  && l2 ==  null)return null;
        if(l1==null) return l2;
        if(l2 == null) return l1;
        
       ListNode c1 = (l1);
         ListNode c2 = (l2);
        int carry = 0;
        int add1 = 0;
        while(c1!=null && c2!=null){
            int x = c1.val + c2.val + carry;
             carry = x/10; 
            add1 = x%10;
            addLast(add1);
            c1= c1.next;
            c2 = c2.next;
        }
        
        if(carry == 0){
            tt.next = (c1 == null?c2:c1);
            return th;
        }
        
        
        while(c1!=null){
            int x = c1.val + carry;
            carry = x/10;
            add1 = x%10;
            addLast(add1);
            c1 = c1.next;
        }
        
        while(c2!=null){
            int x = c2.val + carry;
            carry = x/10;
            add1 = x%10;
            addLast(add1);
            c2 = c2.next;
        }
        
        if(carry!=0) addLast(carry);
        
      return th;   
    }
}

*************************************************************************


public class Solution {
    // example in leetcode book
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                return new int[]{map.get(target - x), i};
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

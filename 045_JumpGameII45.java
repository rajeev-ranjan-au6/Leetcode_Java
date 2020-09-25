class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        for(int i=0; i < nums.length - 1; i++){
            jumps++;
            int temp = i;
            i = findMax(nums, i);
            if(i == temp){
                break;
            }
            i--;
        }
        return jumps;
    }
    
    private int findMax(int[] nums, int beg){
        int max = 0;
        int idx = -1;
        
        for(int i=beg; i <= beg + nums[beg]; i++){
            if(i + nums[i] >= nums.length - 1){
                return i;
            }
            //we check the maximum jump which can be reached from the given set of elements
            if(i != beg && i + nums[i] >= max + idx){
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}
***********************************************************

class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int currend=0;
        int currfarthest=0;
        //nums.length-1 cause we dont need to jump from end index
        for(int i=0;i<nums.length-1;i++){
            // the farthest we can reach from a index
            currfarthest=Math.max(currfarthest,nums[i]+i);
            //if we reach end index before reaching currend we already
			//know that we should have jumped earlier so we will 
			//update currend to farthest(i.e end index or greater) 
			//increment jumps and break 
            if(i==currend){
                // when we reach currentend we need to take another jump
                jumps++;
                currend=currfarthest;
                // break the loop if we already reached end or further
                if(currend>=nums.length-1){
                break;
            }
            }
            
        }
        return jumps;
        
    }
}

*************************************************

class Solution 
{
    public int jump(int[] nums) 
    {
        int pos=0;
        int reach=0;
        int jumps=0;
        //last jump is useless so run loop to nums.length-1 only
        
        for(int i=0;i<nums.length-1;i++)
        {
            reach=Math.max(reach,i+nums[i]);
            
            if(pos==i)
            {
                pos=reach;
                jumps++;
            }
        }
        return jumps;
        
    }
}

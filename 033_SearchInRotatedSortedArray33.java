class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            // nums[left to mid] is sorted
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } 
            // nums[mid to right] is sorted
            else {
                if (target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;   
            }
        }
        return -1;
    } 
}

*******************************************************************************

class Solution {
    public int search(int[] nums, int target) {
      
       
        int low=0;
        int high=nums.length-1;
        
        while(low<high)
        {
            int mid=(low+high)/2;
            if(nums[mid]>nums[high])
                low=mid+1;
            else
                high=mid;
        }
        int rot=low;
        
       // System.out.println(rot);
       
        if(target>=nums[0] && rot!=0)
        {
            high=rot-1;
            low=0;
        }else{
            low=rot;
            high=nums.length-1;
        }
        // System.out.println(low+"|"+high);
         while(low<=high)
        {
            int mid=(low+high)/2;
             if(nums[mid]==target)
                 return mid;
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        
        return -1;
    }
    
   
}

************************************************************

class Solution {
    
    public int search(int[] nums, int target) {
        
        int pivot=0;
        //Find pivot
        for(int i=1; i<nums.length; i++){
            if(nums[i]<nums[i-1]){
                pivot=i;
                break;
            }
        }
        
        if(target> nums[pivot] && target>nums[nums.length-1]){
          return binarySearch(nums, 0, pivot-1, target);
        }else{
            return binarySearch(nums, pivot, nums.length-1, target);
        }
    }
    
    
    private int binarySearch(int[] nums, int beg, int end, int target){
        
        while(beg<=end){
            int mid = (beg+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid -1;
            }else if(nums[mid]<target){
                beg = mid +1;
            }
        }
        return -1;
    }
}

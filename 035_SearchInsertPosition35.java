class Solution {
public int searchInsert(int[] nums, int target) {
int i = 0 ;

          if(target==1 ||nums[i]==target){
        return i;
    }
    
    
    if(target==0){
      return 0;
    }
    

        if((nums.length-1)==0){
       return i+1 ; 
        }
        
    while(target>=nums[i]){
      
        if(target==nums[i]){
            return i ;
        }
                    if(i==nums.length-1){
            return i+1 ;
        } 
        i++;

    }
    return i;

}
}


****************************************************************
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0, index = 0;
        int n = nums.length;
        for(i = 0; i < n; i++)
        {
            if(nums[i] == target)
            {
                index = i;
            }
            
            else
            {
                if(nums[i] < target)
                {
                    index = i+1;
                }
            }
        }
        return index;
    }
}
********************************************************************
class Solution {
public int searchInsert(int[] nums, int target) {
int i,a=-1;
for(i=0;i<nums.length;i++){
if(nums[i]==target)
a=i;

    }
    if(a==-1){
        for(i=0;i<nums.length;i++){
     if(nums[i]>target || i==nums.length-1){
          if(i==(nums.length-1) && target>nums[i]){
                a=i+1;
              break;
          }
         else
             a=i;
                a=i;
                break;
            }
        }
    }

    return a;
}
}

******************************************************************************

class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
            if(nums[i]>=target)
                return i;
        return nums.length;
    }
}
**********************************************************************
class Solution {
public int searchInsert(int[] nums, int target) {
int i=0;
for(i=0;i<nums.length;i++)
{
if(nums[i]==target)
{
return i;
}
if(nums[i]>target)
{
return i;
}
}
return i;
}
}

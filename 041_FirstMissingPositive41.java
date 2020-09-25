class Solution {
public int firstMissingPositive(int[] A) {
int n = A.length;
boolean[] present = new boolean[n + 1];
for (int i = 0; i < n; i++)
{
if (A[i] > 0 && A[i] <= n)
present[A[i]] = true;
}
for (int i = 1; i <= n; i++)
if (!present[i])
return i;
return n + 1;
}
}

*******************************************************************************************

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        // Solving using the cyclic sort pattern
        int i=0;
        
        while(i < nums.length) {
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
            {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        
        for(i = 0; i< nums.length; i++) {
            if(nums[i] != i + 1) {
                return i+1;
            }
        }
        
        return nums.length + 1;
    }
}


******************************************************************************************


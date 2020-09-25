class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum  = nums[i] + nums[left] + nums[right];
                
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                
                if (sum > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return (target-diff);
    }
}

****************************************************************************************

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++)
        {
            int j=i+1;
            int k=nums.length-1;
            while(j<k)
            {
                if(Math.abs(target-(nums[i]+nums[j]+nums[k]))<Math.abs(ans))
                    ans=target-(nums[i]+nums[j]+nums[k]);
                if((nums[i]+nums[j]+nums[k])<target) j++;
                else k--;
                
            }
        }
        return target-ans;               
    }
}

***************************************************************************************

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // sort array asc
        Arrays.sort(nums);
        
        // closed value to the target
        int closest = Integer.MAX_VALUE;
        // here we will store the result value
        int result = 0;
        
        // iterate from start to the end.
        // 'curr' is one of the pointers
        for(int curr = 0; curr < nums.length - 1; curr ++) {
            
            // find the other values in an area between current pointer and the end
            int start = curr + 1;
            int end = nums.length - 1;
            
            // iterate before two pointers meet each other
            while(start != end) {
                
                // our three pointers
                int v1 = nums[start];
                int v2 = nums[curr];
                int v3 = nums[end];

                // just a summ of all of pointers
                int sum = v1 + v2 + v3;

                // if we found exact value (suit for regular 3Sum)
                if(sum == target) {
                    return sum;
                }
                // if the summ is higher than target move 'end' pointer to make the next summ lower (as far as we used sorted array)
                if(sum > target) {
                    end--;
                }
                // if sum is too low than move start pointer to increase the value of the next sum
                if(sum < target) {
                    start++;
                }

                // difference between 'target' and current 'sum'
                int sumDif = 0;
                // keep in mind that target can be below zero
                // keep diff value as a positive as far as we're looking for the closest value from both size from the 'target'
                if(target > 0) sumDif = Math.abs(target - sum);
                else sumDif = Math.abs(sum - target);

                // store result
                if(sumDif < closest) {
                    closest = sumDif;
                    result = sum;
                }
            }
        }
        return result;
    }
}


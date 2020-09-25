class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>(); // if nums less than 3 element
        Arrays.sort(nums); // sort array
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }

        }

        return new ArrayList<>(set);
    }
}

*************************************************************************************************

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
                Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            if(i==0 || (i>0 && nums[i]!=nums[i-1]))
            {
                int lo=i+1,hi=nums.length-1;
                int target=0-nums[i];
                while(lo<hi)
                {
                    int sum=nums[lo]+nums[hi];
                    if(sum==target)
                    {
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo<hi && nums[lo]==nums[lo+1])lo++;
                        while(lo<hi && nums[hi]==nums[hi-1])hi--;
                        lo++;
                        hi--;
                    }
                    else if(sum>target)
                    {
                        hi--;
                    }
                    else
                    {
                        lo++;
                    }
                }
            }
        }
        return res;
    }
}

***********************************************************************

/*
    Video explanation: https://youtu.be/1aQvO4JPo70
*/
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums == null || nums.length < 3)
        	return result;
    	// sort the array in-place
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length - 2; i++) {
    	    if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
    	        int low = i+1, high = nums.length - 1;
    	        int sum = 0 - nums[i];
                // Finding two sum using two pointer
    	        while (low < high) {
    	           if (nums[low] + nums[high] == sum) {
    	              result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                      // if next number is duplicates skip that
    	              while (low < high && nums[low] == nums[low+1]) low++;
                      // if previous number is duplicates skip that
    	              while (low < high && nums[high] == nums[high-1]) high--;
    	              low++; 
		              high--;
    	           } else if (nums[low] + nums[high] < sum) {
    	              low++;
    	           } else {
    	              high--;
    	           }
    	        }
    	    }
    	}
    	
       return result;
    }
}

***************************************************************************

//Two pointer Solution
//Sort the array
//Get an element from the array
//Find it has pair from the remaining elements of the array

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList();
        for(int i=0; i<nums.length-2; i++)
        {
            if(i>0 && nums[i] == nums[i-1])  //To skip the same element
                continue;
            searchPair(-nums[i], i+1, nums, triplets); 
        }
        return triplets;
        
    }
    
    public static void searchPair(int target, int left, int[] arr, List<List<Integer>> triplets)
    {
        int right = arr.length-1;
        while(left < right)
        {
            int currentSum = arr[left] + arr [right];
            if(currentSum == target)
            {
                triplets.add(Arrays.asList(-target, arr[left], arr[right]));
                left++;
                right--;
                while(left<right && arr[left] == arr[left-1]) //skip the same element
                    left++;
                while(left<right && arr[right] == arr[right+1]) //skip the same element
                    right--;
            }
            else if(target > currentSum)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
    }
}

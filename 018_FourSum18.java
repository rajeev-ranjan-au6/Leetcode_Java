class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            int pointer = i + 1;
            int left = pointer + 1;
            int right = nums.length - 1;
            while (pointer < nums.length - 2) {
                int sum = nums[i] + nums[pointer] + nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[pointer], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                if (left >= right) {
                    pointer++;
                    left = pointer + 1;
                    right = nums.length - 1;
                }
            }
        }
        return new ArrayList<>(result);
    }
}

********************************************************************************************

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Map<Integer, List<Integer>> m = new HashMap<>();
        if (nums == null || nums.length < 4) return new ArrayList(res);
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                for (int k = j + 1; k < nums.length; k++){
                    int com = target - nums[i] - nums[j] - nums[k];
                    if (m.containsKey(com) && m.get(com).get(0) == i && m.get(com).get(1) == j){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], com);
                        Collections.sort(temp);
                        res.add(temp);     
                    }
                    m.put(nums[k], Arrays.asList(i, j));
                }
            }
        }
        return new ArrayList(res);       
    }
}

********************************************************************************************************

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low++], nums[high--]));
                        while (low < high && nums[low] == nums[low - 1]) low++;
                        while (low < high && nums[high] == nums[high + 1]) high--;
                    } else if (sum < target) low++;
                    else high--;
                }
            }
        }
        return result;
    }
}

***********************************************************************************************************************


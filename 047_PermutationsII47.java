class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> list = new ArrayList<>();
       permute(nums,0,list); 
       return list;
    }
    
    private void permute(int[] nums, int i, List<List<Integer>> list) {
        if(i==nums.length){
            List<Integer> l1 = new ArrayList<>();
            for(int n:nums) {
                l1.add(n);
            }
            list.add(l1);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int s=i;s<nums.length;s++) {
            if(set.add(nums[s])) {
                swap(nums,s,i);
                permute(nums,i+1,list);
                swap(nums,s,i);
            }
        }
    }
    
    private void swap(int[] nums,int i,int j) {
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}

*********************************************************************************
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations=new ArrayList();
        backtrack(new boolean[nums.length], new ArrayList(),permutations,nums);
        return permutations;
    }
    public void backtrack(boolean[] used, List<Integer> current,List<List<Integer>> permutations,int[] nums){
        if(current.size()==nums.length){
            permutations.add(new ArrayList(current));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
                used[i]=true;
                current.add(nums[i]);
                backtrack(used,current,permutations,nums);
                used[i]=false;
                current.remove(current.size()-1);
            }
        }
    }
}

*****************************************************************
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = toList(nums);

        backtrack(list, 0);

        return ans;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        return list;
    }

    private void backtrack(List<Integer> nums, int pos) {
        if (pos == nums.size()) {
            ans.add(new ArrayList<>(nums));
        }

		// Hash also works, but slower for testcases they have right now
        List<Integer> used = new ArrayList<>();

        // select nums[pos] as start point for nums from pos to the end
        for (int i = pos; i < nums.size(); i++) {
            if (!used.contains(nums.get(i))) {
                used.add(nums.get(i));

                Collections.swap(nums, pos, i);
                backtrack(nums, pos + 1);
                Collections.swap(nums, pos, i);
            }
        }
    }
}


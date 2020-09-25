class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helperFunction(result, current, nums, 0);
        return result;
    }
    public void helperFunction(List<List<Integer>> result, List<Integer> current, int [] nums, int start) {
       if (current.size() == nums.length) {
           result.add(new ArrayList<>(current));
           return;
        }
        for (int i=start; i<nums.length; i++) {
            if (current.contains(nums[i])) continue;
            current.add(nums[i]);
            helperFunction(result, current, nums, 0);
            current.remove(current.size()-1);
            
        }
    }
}

*****************************************************************

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permutations(nums,0,list);
        return list;
    }
    
    public void permutations(int[] nums,int i,List<List<Integer>> list) {
        if(i==nums.length) {
            List<Integer> sublist = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                sublist.add(nums[j]);
            }
            list.add(sublist);
            return;
        }
        for(int start=i;start<nums.length;start++) {
            swap(nums,i,start);
            permutations(nums,i+1,list);  
            swap(nums,i,start);            
        }

    }
    
    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
}

***************************************************************************
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // traverse through all nums and for each number, they can be in any position
        List<Integer[]> res = new ArrayList<>();
        res.add(new Integer[nums.length]);
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            List<Integer[]> newRes = new ArrayList<>();
            for (int j = 0; j < res.size(); j++) {
                Integer[] curList = res.get(j);
                for (int k = 0; k < curList.length; k++) {
                    if (curList[k] != null) {
                        continue;
                    }
                    Integer[] copy = curList.clone();
                    copy[k] = curNum;
                    newRes.add(copy);
                }
            }
            res = newRes;
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            ret.add(Arrays.asList(res.get(i)));
        }

        return ret;
    }
}

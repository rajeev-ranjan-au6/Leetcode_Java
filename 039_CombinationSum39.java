class Solution {
    List<List<Integer>> comb;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        comb = new ArrayList();
        List<Integer> lt = new ArrayList();
        findSum(lt, candidates, 0, target);
        return comb;
    }
    
    private void findSum(List<Integer> sumList, int[] candidates, int beg, int target){
        if(target == 0){
                comb.add(sumList);
                return;
            }
		if(beg == candidates.length){
            return;
        }
        if(candidates[beg] <= target){
            List<Integer> lst = new ArrayList();
            lst.addAll(sumList);
            lst.add(candidates[beg]);
            findSum(lst, candidates, beg, target - candidates[beg]);
        }
        findSum(sumList, candidates, beg+1, target);
        
    }
}

***************************************************************************************************
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helperFunction(result, current, candidates, 0, target, 0);
        return result;
    }
    public void helperFunction(List<List<Integer>> result, List<Integer> current, int [] candidates, int start, int target, int sum) {
        if (sum > target)
            return;
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=start; i<candidates.length; i++) {
            current.add(candidates[i]);
            helperFunction(result, current, candidates, i, target, sum+candidates[i]);
            current.remove(current.size()-1);
        }
            
    }
}

*************************************************************************************

class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        helper(candidates, target, 0, 0, new ArrayList<>());

        return resultList;

    }

    private void helper(int[] candidates, int target, int index, int sum, List<Integer> list) {

        if (sum > target) return;

        if (sum == target) {

            resultList.add(new ArrayList(list));
        }

        for (int i = index; i < candidates.length; i++) {
            
            list.add(candidates[i]);
            helper(candidates, target, i , sum + candidates[i], list);
            list.remove(list.size() - 1);

        }
    }
}

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 */


*****************************************************************************

class Solution {
    public int maxArea(int[] height) {
        //check them all 
        List<Integer> areas = new ArrayList<Integer>();
        int count = 1;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                if(height[i] < height[j]){
                    areas.add(height[i] * count);
                }else{
                    areas.add(height[j] * count);    
                }
                count++;
            }
            count = 1;
        }
        return Collections.max(areas);
    }
}

*************************************************************************

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length-1;
        while(start < end){
            int x = end - start;
            if(height[start] <= height[end]) max = Math.max(max, height[start++]*x);
            else max = Math.max(max, height[end--]*x);
        }
        return max;
    }
}

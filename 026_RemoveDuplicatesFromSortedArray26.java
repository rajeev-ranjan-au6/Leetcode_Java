class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length, i = 0, j = 1, last = nums[0];
        while(j < n) {
            if(nums[j] != last) {
                i++;
                last = nums[j];
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}

*******************************************************************
class Solution {
public int removeDuplicates(int[] nums) {
int startindex=1;
int n=nums.length;
for(int i=0;i<n-1;i++)
{
if(nums[i+1]==nums[i])
{
int a=nums[i];
while(i<n && nums[i]==a)
i++;
if(i<n){
nums[startindex]=nums[i];
startindex++;
i--;
}
else
break;
}
else
{
nums[startindex]=nums[i+1];
startindex++;
}
}

    return startindex;
}
}

******************************************************************
class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer=0;
        int current=1;
        for(int index=0;index<nums.length-1;index++)
        {
            if(nums[current]==nums[pointer])
            {
                current++;
            }
            else
            {
                pointer++;
               nums[pointer]=nums[current];
                current++;
            }
        }
        return pointer+1;
    }
}

*******************************************************************
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int curRepPos=1;
        int i=0;
        while(i<nums.length-1){
            int j=i+1;
            while(j<nums.length && nums[i]==nums[j]) j++;
            if(j==nums.length) break;
            nums[curRepPos++] = nums[j];
            i=j;
        }
        return curRepPos;
    }
}

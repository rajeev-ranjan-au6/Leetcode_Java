class Solution {
    public int trap(int[] height) {
        
        int water = 0;
        
        if(height.length == 0) return water;
        
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i++)
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        
        rightMax[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        
        for(int i = 0; i < height.length; i++)
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        
        return water;
    }
}
******************************************************************
class Solution {
    public int trap(int[] height) {
        int len=height.length;
        if(len<2)
            return 0;
        int[] left_max=new int[len];
        int[] right_max=new int[len];
        int result=0;
        left_max[0]=height[0];
        for(int i=1;i<len;i++)
            left_max[i]=Math.max(left_max[i-1],height[i]);
        right_max[len-1]=height[len-1];
        for(int i=len-2;i>=0;i--)
            right_max[i]=Math.max(right_max[i+1],height[i]);
        for(int i=0;i<len;i++)
        {
            result+=Math.min(left_max[i],right_max[i])-height[i];
        }
        return result;
    }
}


******************************************************************

class Solution {
    public int trap(int[] height) {
         //two pointer approach  
        int size = height.length;
        if(size<3)
            return 0;
        int totalWater=0;
        int i = 0;
        int j = size-1;
        int lMax=height[0];
        int rMax=height[size-1];
        while(i<=j){
            lMax=Math.max(lMax,height[i]);
            rMax=Math.max(rMax,height[j]);
            if(lMax>=rMax){
                totalWater=totalWater+(rMax-height[j]);
                j=j-1;
            }
            else if(rMax>lMax){
                totalWater=totalWater+(lMax-height[i]);
                i=i+1;
            }
        }
        return totalWater;
    }
}

*************************************************************

class Solution {
public int trap(int[] height) {
int n=height.length;
int leftmax[]=new int[n];
int rightmax[]= new int[n];
if(n==0)
return 0;
leftmax[0]=height[0];
rightmax[n-1]=height[n-1];

    for(int i=1;i<n-1;i++)
    {
        if(height[i]>leftmax[i-1])
            leftmax[i]=height[i];
        else
            leftmax[i]=leftmax[i-1];
    }
    
    for(int j=n-2;j>=1;j--)
    {
        if(height[j]>rightmax[j+1])
            rightmax[j]=height[j];
        else
            rightmax[j]=rightmax[j+1];
    }
    int water=0;
    for(int i=1;i<n-1;i++)
    {
        water+=Math.min(leftmax[i],rightmax[i])-height[i];
    }
    
    return water; 
}
}

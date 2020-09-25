public class Solution {
    // example in leetcode book
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int p1 = 0, p2 = 0, pos = 0;
    	int ls1 = nums1.length, ls2 = nums2.length;
    	int[] all_nums = new int[ls1+ls2];
    	double median = 0.0;
    	while (p1 < ls1 && p2 < ls2){
    		if (nums1[p1] <= nums2[p2])
    			all_nums[pos++] = nums1[p1++];
    		else
    			all_nums[pos++] = nums2[p2++];
    	}
    	while (p1 < ls1)
    		all_nums[pos++] = nums1[p1++];
    	while (p2 < ls2)
    		all_nums[pos++] = nums2[p2++];
    	if ((ls1 + ls2) % 2 == 1)
    		median = all_nums[(ls1 + ls2) / 2];
    	else
    		median = (all_nums[(ls1 + ls2) / 2] + all_nums[(ls1 + ls2) / 2 - 1]) / 2.0;
        return median;
    }
}

****************************************************************************************************

class Solution {
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        int length = num1.length + num2.length;
        int mid1 = 0;
        int mid2 = 0;
        int index = 0;
        int i = 0;
        int j = 0;
        
        while (index <= length/2) {
            while (index <= length/2 && i < num1.length && j < num2.length) {
                if (num1[i] < num2[j]) {
                    mid1 = mid2;
                    mid2 = num1[i];
                    i++;
                } else {
                    mid1 = mid2;
                    mid2 = num2[j];
                    j++;
                }
                index++;
            }
            while(index <= length/2 && i < num1.length) {
                mid1 = mid2;
                mid2 = num1[i];
                i++;
                index++;
            }
            while(index <= length/2 && j < num2.length) {
                mid1 = mid2;
                mid2 = num2[j];
                j++;
                index++;
            }
        }
        
        double median = 0d;
        if (length % 2 == 0) {
            median = (mid1 + mid2) / 2.0;
        } else {
            median = mid2;
        }
        
        return median;
    }
}

************************************************************************************************

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l3 = l1 + l2;
        int [] merge = new int [l3];

        for (int i = l3 - 1; i >= 0; i--) {
            while (l1 != 0 && l2 != 0) {
                if (nums1[l1 - 1] >= nums2[l2 - 1]) {
                    merge[i--] = nums1[--l1];
                } else {
                    merge[i--] = nums2[--l2];
                }
            }

            while (l1 != 0) {
                merge[i--] = nums1[--l1];
            }

            while (l2 != 0) {
                merge[i--] = nums2[--l2];
            }

        }
        double median;
        int mid = l3 / 2;

        if (l3%2 > 0) {
            median = merge[mid];
        } else {
            median = (double) (merge[mid - 1] + merge[mid]) / 2;
        }
        return median;
        
    }
}

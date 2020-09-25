class Solution {
    public void nextPermutation(int[] nums) {
      int k = 0;
       StringBuilder t = new StringBuilder();
       List<String> j = new ArrayList<String>(); 
               List<Integer> y = new ArrayList<Integer>(); 

       for(int x : nums){
           t.append(String.valueOf(x));
       }
        permute("",t.toString(), j);
        for(String w : j){
           y.add(Integer.parseInt(w));
       }
     Collections.sort(y);
        System.out.println(y);
     int pos = y.indexOf(Integer.parseInt(t.toString()));
        System.out.println(pos);

    if(pos == y.size()-1){
       k =  y.get(0);
        String[] sNums = Integer.toString(k).split("");
        for (int u = 0; u < sNums.length; u++) {
            nums[u] = Integer.parseInt(sNums[u]);
        }
    }else{
        if(y.size() < 2){
            k = y.get(0);
        }else{
         k = y.get(pos+1);
        }
    String[] sNums = Integer.toString(k).split("");
    for (int u = 0; u < sNums.length; u++) {
        nums[u] = Integer.parseInt(sNums[u]);
            }
        }
    }
    
    void permute(String prefix, String nums, List<String> ot){
        int l = nums.length();
        if(l == 0){
            if(!ot.contains(prefix)){
                ot.add(prefix);
            }
        }else{
            for(int i = 0; i < l; i++)
                permute(prefix + nums.charAt(i), nums.substring(0, i) + nums.substring(i+1, l), ot);
            }   
        }
    }

******************************************************************

class Solution {
public void nextPermutation(int[] nums) {
int n = nums.length;
if(n==0){return;}
for(int i=n-1;i>=0;i--){
if(i==0){Arrays.sort(nums);return;}
else{
if(nums[i-1]<nums[i]){
for(int j=n-1;j>=i;j--){
if(nums[j]>nums[i-1]){
int temp = nums[j];
nums[j] = nums[i-1];
nums[i-1]=temp;
break;
}
}
Arrays.sort(nums,i,n);
return;
}
}

}
}
}

*****************************************************************************
class Solution {
	
	private void swap (int[] nums, int i, int j) {
		
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private void reverse (int[] nums, int i, int j) {
		
		while (i < j) {
			swap (nums, i++, j--);
		}
	}
	
	public void nextPermutation (int[] nums) {
		
		int i = nums.length - 2;
		
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			--i;
		}
		
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i]) {
				--j;
			}
			swap (nums, i, j);
		}
		
		reverse (nums, i + 1, nums.length - 1);
	}
}

*******************************************************************
class Solution {
    public void nextPermutation(int[] arr) {
        int max=arr[arr.length-1];
        int idx=-1;
        for(int i=arr.length-2;i>=0;i--){
            if(max<=arr[i]){
                max=arr[i];
            }
            else{
                idx=i;
                break;
            }
        }
          if(idx==-1){
            Arrays.sort(arr);
            return;
        }
        int nmax=Integer.MAX_VALUE;
        int k=idx;
      
        for(int j=idx+1;j<arr.length;j++){
            if( arr[j]>arr[idx] && arr[j]-arr[idx]<nmax){
                nmax=arr[j]-arr[idx];
                k=j;
            }
        }
        System.out.println(idx+" "+k);
        int temp=arr[idx];
        arr[idx]=arr[k];
        arr[k]=temp;
        Arrays.sort(arr,idx+1,arr.length);
        
        
        
       
        
    }
}
******************************************************************

class Solution {
    public void nextPermutation(int[] nums) {
        int size = nums.length;
        if(size == 1) return;
        
        for(int i = size - 1; i > 0; i--){
            if(nums[i] <= nums[i-1]) continue;
            for(int j = size - 1; j >= i; j--){
                if(nums[j] > nums[i - 1]) {
                    swap(nums, j, i - 1);
                    reverse(nums, i, size - 1);
                    return;
                }
            }
        }
        reverse(nums, 0, size - 1);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while(i <= j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}


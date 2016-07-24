
public class P215_KthLargestElementInAnArray {

//	Find the kth largest element in an unsorted array. 
//	Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//	For example,
//	Given [3,2,1,5,6,4] and k = 2, return 5.
//
//	Note: 
//	You may assume k is always valid, 1 ≤ k ≤ array's length.
//
//	Credits:
//	Special thanks to @mithmatt for adding this problem and creating all test cases.
	
    public int findKthLargest(int[] nums, int k) {
    	int lastIndex = nums.length-1;
    	for(int i = nums.length-1;i>=0;i--){
    		sink(nums,i,lastIndex);
    	}
    	
    	int   kk = k ;
    	while(kk>=1) {//use k instead of N 
    		swap(nums,0,lastIndex);// should be arr[1] in real heap sort
    		lastIndex--; //to not tough the last one
    		
    		sink(nums,0,lastIndex);
    		kk--;
    	}
    	//lastIndex == nums.length-1 -k after the "while loop"
    	//lastIndex:  nums[lastIndex-2],nums[lastIndex-1],nums[lastIndex]
    	//k:		  3rd			   ,2nd			   	 ,1st
    	return nums[lastIndex+1];
    }
	
    private void sink(int[] nums, int k, int lastIndex){
    	while(2*k+1<= lastIndex){// 2*k+1<N means, it has child
    		int j =2*k+1;
    		if(j+1 <= lastIndex && nums[j]<nums[j+1]) j++;
    		
    		if(nums[k] < nums[j]) swap(nums,k,j);
    		else break;
    		
    		k=j;
    	}
    }
    private void swap(int[] nums, int i, int j){
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

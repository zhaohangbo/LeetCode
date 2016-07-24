
public class P303_RangeSumQueryImmutable {
	private int[] nums ;
	private int dp[] ;  //dp[i] means the sum between indices 0 and i (0 ≤ i), inclusive.
						//Thus, dp[j] - dp[i] means the sum between indices i and j
    public P303_RangeSumQueryImmutable(int[] nums) {
    	this.nums = nums;
    	if(nums.length!=0){
	    	dp   =new int[nums.length];
	    	dp[0] =nums[0];
	    	for(int i=1;i<dp.length;i++){
	    		dp[i] = dp[i-1]+nums[i];
	    	}
    	}
    }

    public int sumRange(int i, int j) {
    	if(this.nums.length==0)
    		return 0;
    	
    	if(i==0)
    		return dp[j];
        
    	return dp[j]-dp[i-1];
    }
    
 // Your NumArray object will be instantiated and called as such:
 // NumArray numArray = new NumArray(nums);
 // numArray.sumRange(0, 1);
 // numArray.sumRange(1, 2);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

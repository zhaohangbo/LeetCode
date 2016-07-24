
public class P152_MaximumProductSubarray {
	
	public int maxProduct(int[] nums) {
		if (nums.length==0)
				return 0;
		int[] positive  =new int[nums.length];
		int[] negative  =new int[nums.length];
		positive[0] = nums[0];
		negative [0] = nums[0];
		
		int maxSofar = nums[0];
		for(int i =1;i<nums.length;i++){
			//nums[i] has 3 possible values: positive, 0 ,negative
			//what if positive[i-1] == 0 , solved by nums[i] in Math.max()
			//what if nums[i] == 0 		 , solved by maxSofar, which recored the history
										  // 		  pos*nums[i],          neg*nums[i] ,      pos[i-1] 
			positive[i] = Math.max(Math.max(positive[i-1]*nums[i],negative[i-1]*nums[i]), nums[i]);
			negative[i] = Math.min(Math.min(negative[i-1]*nums[i],positive[i-1]*nums[i] ),nums[i]);
			maxSofar = Math.max(maxSofar, positive[i]);
		}
		return maxSofar;
	}
	
	public int maxProduct2(int[] nums) {
		if (nums.length==0)
				return 0;
		
		int posi  =  nums[0];
		int nega  =  nums[0];
		int maxSofar = nums[0];
		
		for(int i =1;i<nums.length;i++){
			//nums[i] has 3 possible values: positive, 0 ,negative
			//what if positive[i-1] == 0 , solved by nums[i] in Math.max()
			//what if nums[i] == 0 		 , solved by maxSofar, which recored the history
										  // 		  pos*nums[i],          neg*nums[i] ,      pos[i-1]
			
			int tempPosi = posi;
			int tempNega = nega;
			posi = Math.max(Math.max(tempPosi*nums[i],tempNega*nums[i]), nums[i]);
			nega = Math.min(Math.min(tempPosi*nums[i],tempNega*nums[i]),nums[i]);
			maxSofar = Math.max(maxSofar, posi);
		}
		return maxSofar;
	}
	
    public int maxProduct3(int[] nums) {
    	int[][] dp = new int[nums.length][nums.length];
    	//dp[i][j] means the max product of subArray from i to j
    	//think what's the relation between dp[i][j],dp[i-1][j],dp[i][j-1],dp[i-1][j-1]
    	
    	for(int i=0;i<nums.length;i++){
    		for(int j=i;j<nums.length;j++){
    			if(i==0 && j==0){
    				dp[0][0] = nums[0];
    				break;
    			}
    			if(i==nums.length-1){
    				dp[nums.length-1][nums.length-1]=nums[nums.length-1];
    				break;
    			}
    			//[-3,0,1,-2]
//    			dp[i][j] =Math.max( dp[i-1][j]/nums[i-1] , nums[j]*dp[i][j-1] );
//    			dp[i][j] =Math.max( nums[i]*dp[i+1][j] , nums[j]*dp[i][j-1] );
    			
//    			dp[i][j]   //    i-------j
//    			dp[i+1][j] //     i+1----j
//    			dp[i-1][j] //i-1-i-------j    			
//    			dp[i][j-1]//	 i----j-1     
//    			dp[i+1][j-1]//    i+1-j-1

    		}
    	}
    	return dp[0][nums.length-1];    
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

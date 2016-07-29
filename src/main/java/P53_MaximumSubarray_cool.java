
public class P53_MaximumSubarray_cool {
	
	
	//states[][0] = start to end
	//states[][1] = start to end
	
	
    public int maxSubArray(int[] nums) {
    	
    	int maxSoFar =nums[0];
    	int maxCur   =nums[0];
    	
    	for(int i=1;i<nums.length;i++){
    		//maxCur  = Math.max(maxCur +nums[i], maxCur);这样没有意义
    		//Determined by nums[i]
    		//if nums[i]<=0, then maxCur = maxCur ,no change,but how to extend the sub_array
    		//if nums[i]>0,  then maxCur = maxCur+nums[i]
    		
    		
    		//Understand the Math.max() deeply ,and make clear which element determines the result.
    		
    		
    		//Determined by maxCur
    		//If maxCur <= 0, maxCur = nums[i], give up the previous arr, begin with a new start nums[i]
    		//If maxCur >0  , maxCur = maxCur +nums[i], continue extending the sub_array
    		maxCur  = Math.max(maxCur +nums[i], nums[i]);
    		
    		//Although the nums[i] maybe <0 , but the history max sum is recoreded in maxSoFar)
    		maxSoFar= Math.max(maxSoFar, maxCur);
    	}
    	
    	return maxSoFar;
    }

    public static void main(String[] args){
    	int[] arr ={-2,1,-3,4,-1,2,1,-5,4};
    	System.out.println(new P53_MaximumSubarray_cool().maxSubArray(arr));
    }
}

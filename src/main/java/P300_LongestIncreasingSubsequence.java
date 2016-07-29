
public class P300_LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
    	if(nums.length==0 ) return 0;

    	//len_map_min[i] means len i and the last min value
    	int[] len_map_min =new int[nums.length];
    	for(int len = 0;len < len_map_min.length; len ++){
    		len_map_min[len] = Integer.MAX_VALUE;
    	}
    	
    	for(int i=0;i<nums.length;i++){
    		for(int len =0 ;len<len_map_min.length; len ++ ){
    			if(nums[i] <= len_map_min[len]){
    				len_map_min[len] = nums[i];
    				break;
    			}
    		}
    	}
    	int max_len = -1;
    	for(int i=len_map_min.length-1;i>=0;i--){
    		if(len_map_min[i] != Integer.MAX_VALUE){
    			max_len= i + 1;  //length = index + 1
    			break;
    		}
    	}
    	
    	return max_len;
    }
	//10, 9, 2, 5, 3, 7, 101, 18}
    
    //10,
    //9
    //2
    //2 5
    //2 3
    //2 3 7
    //2 3 7 101
    //2 3 7 18
    
    //2 2
    //2
    //2
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		//int[] nums2= {1,3,6,7,9,4,10,5,6};
		int[] nums3={2 ,2};
		//System.out.println(lengthOfLIS(nums));
		//System.out.println(lengthOfLIS(nums2));
		System.out.println(lengthOfLIS(nums3));
	}

}

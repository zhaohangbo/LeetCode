
public class P213_HouseRobberII_coolcool {
	
	public int rob(int[] nums) {
	    if (nums.length == 1) return nums[0];
	    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}
	
	private int rob(int[] nums, int lo, int hi) {
	    int include = 0, exclude = 0;
	    for (int j = lo; j <= hi; j++) {
	        int i = include, e = exclude;//记录e=exclude[j-1],i=include[j-1]
	        include = e + nums[j];	 // include[j] =exclude[j-1]+num[j]
	        exclude = Math.max(e, i);// exclude[j] =max(exclude[j-1],include[j-1])
	    }
	    return Math.max(include, exclude);
	}
	
	
	private int rob2(int[] nums, int lo, int hi){
		int robThis =0;
		int notRobThis=0;
		
		for(int i=lo;i<hi;i++){
			int lastRT =robThis; int lastNRT =notRobThis;
			robThis    = lastNRT + nums[i];
			notRobThis = Math.max(lastNRT,lastRT);
		}
		
		return Math.max(robThis, notRobThis);
	}
	
	
	
	//My Solution ---- Failed
    public int rob2(int[] nums) {
    	int len =nums.length;
    	if(len == 0) return 0;
    	if(len == 1) return nums[0];
    	if(len == 2) return Math.max(nums[0], nums[1]);
    	if(len == 3) return Math.max(nums[0],Math.max(nums[1],nums[2]));
    	
    	int[] states =new int[len];
    	states[0] = nums[0];
    	states[1] = Math.max(nums[0],nums[1]);
    	
    	
    	int[] states_skip_head =new int[len];
    	states_skip_head[1]=nums[1];
    	states_skip_head[2]=Math.max(nums[1],nums[2]);
    	
    	int[] states_skip_tail =new int[len];
    	states_skip_tail[0]=nums[0];
    	states_skip_tail[1]=Math.max(nums[0],nums[1]);
    	boolean headInclued =true;
    	boolean checkHead= true;
    	for(int i=2;i<len;i++){//i-th row ,means i-th start
    		if(states[i-1]==states[i-2]){
    			//initialize skip head and tail states 
				if(i!=2){
					states_skip_head[i] =states_skip_head[i-1]+nums[i];
				}
				if(i!=len-1){
					states_skip_tail[i] =states_skip_tail[i-1]+nums[i];
				}
				
				//states
    			if(i==len-1 && headInclued){ //head and tail are both included
    				states[i]=Math.max(states_skip_head[i], states_skip_tail[i-1]);
    			}
    			else{
    				states[i] = states[i-2]+nums[i];
    			}
    		}
    		else{
    			//initialize skip head and tail states 
				if(i!=2){
					states_skip_head[i] =Math.max(states_skip_head[i-2]+nums[i], states_skip_head[i-1]);
				}
				if(i!=len-1){
					states_skip_tail[i] =Math.max(states_skip_tail[i-2]+nums[i], states_skip_tail[i-1]);
				}
				
				//states
    			if(i==len-1 && headInclued){ //head and tail are both included
    				states[i] =Math.max(states_skip_head[i], states_skip_tail[i-1]);
    			}
    			else{
    				states[i] =Math.max(states[i-1],states[i-2]+nums[i]);
    			}
    		}
    		
    			if(states_skip_head[i-1]!=states[i-1]){
    				headInclued =true;
    			}
    			else{
    				headInclued =false;
    			}
    		
    	}    	
    	return states[len-1];
    }
    
    public static void main(String[] args){
    	int[] nums ={2,7,9,3,1};
//    	int[] nums ={2,1,1,2};
    	System.out.println(new P213_HouseRobberII_coolcool().rob(nums));
    }
//[1,1,3,6,7,10,7,1,8,5,9,1,4,4,3]
// 1,1,4,7,
}



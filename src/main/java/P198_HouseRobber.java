
public class P198_HouseRobber {
	
    public int rob(int[] nums) {
    	int len =nums.length;
    	if(len==0){
    		return 0;
    	}
    	int[] states =new int[len];
    	
    	// states[i]
    	
    	// 1.states[i-1]==states[i-2]   i-1 is not robbed, or another rob sequence with i-1 robbed but same result
    	// So:			
    	//		states[i] = states[i-2] + nums[i];
    	
    	// 2.states[i-1] >states[i-2]   i-1 is robbed
    	// So:  choose the bigger in a and b.
    	//		a.will not rob nums[i]  ,then states[i] =states[i-1]
    	//		b.give up  rob nums[i-1],then states[i] =states[i-1] + nums[i]
    	//        notice, it doesn't matter if i-2 is robbed or not.we should focus on states.
    	
    	
    	
    	for(int i=0;i<len;i++){
    		if(i==0){
    			states[0] = nums[0];
    		}
    		else if(i==1){
    			states[i] = Math.max(nums[0], nums[1]);
    		}
    		else{
    			if(states[i-1]==states[i-2]){// nums[i-1] not robbed or 
    				states[i] = states[i-2]+nums[i];
    			}
    			if(states[i-1]>states[i-2]){
    				states[i]=Math.max(states[i-1], nums[i]+states[i-2]);
    			}
    		}
    	}
    	
    	return states[len-1];   
    }
    
    
    public static void main(String[] args){
    	int[] nums ={10, 1, 1,10,1,1,10000};
    	//			 10,10,11,,1000011
    	System.out.println(new P198_HouseRobber().rob(nums));
    }

}

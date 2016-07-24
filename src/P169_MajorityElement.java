import java.util.HashMap;

public class P169_MajorityElement {

	
	
    public int majorityElement(int[] nums) {
     
    	HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(nums[i])){
    			int count = map.get(nums[i]);
    			if(count> nums.length/2){
    				return nums[i];
    			}
    			map.put(nums[i], count +1);
    		}
    		else{
    			map.put(nums[i],1);
    		}
    	}
    	return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
